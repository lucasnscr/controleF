package serviceImpl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Constantes.MensagemErro;
import dto.CentroGastosDTO;
import dto.LancamentoDTO;
import entity.CentroGastos;
import entity.Lancamento;
import entity.Usuario;
import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import repository.LancamentoRepository;
import service.CentroGastosService;
import validacoes.ValidacoesImpl;

@Service
public class CentroGastosServiceImpl implements CentroGastosService {

	@Autowired
	private CentroGastosRepository centroGastosRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ValidacoesImpl validacao;

	@Override
	public CentroGastosDTO pesquisarCentroGastosUsuario(Long idUsuario) throws ValidacaoException, ServicoException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Usuario usuario = validacao.validaUsuario(idUsuario);
			CentroGastos centroGastos = centroGastosRepository.findByIdUsuario(idUsuario);

			if (centroGastos != null) {

				ArrayList<List<LancamentoDTO>> lancamentoDTOArrayList = new ArrayList<>();
				CentroGastosDTO centroGastosDTO = new CentroGastosDTO();

				Double valorCredito = 0.0;
				Double valorDebito = 0.0;
				Calendar cal = Calendar.getInstance();

				for (int i = 1; i < 13; i++) {

					int primeiroDiaMes = cal.getActualMinimum(i);
					int ultimoDiaMes = cal.getActualMaximum(i);
					int ano = cal.get(Calendar.YEAR);

					String dataParserInicio = primeiroDiaMes + "/" + i + "/" + ano;
					String dataParserFim = ultimoDiaMes + "/" + i + "/" + ano;
					Date inicioDate = sdf.parse(dataParserInicio);
					Date fimDate = sdf.parse(dataParserFim);
					LocalDate inicio = toLocalDate(inicioDate);
					LocalDate fim = toLocalDate(fimDate);

					List<LancamentoDTO> lancamentosDTOList = new ArrayList<>();
					List<Lancamento> listaMensal = lancamentoRepository.pesquisaMensal(inicio, fim);

					if (CollectionUtils.isNotEmpty(listaMensal)) {
						for (Lancamento lancamento : listaMensal) {

							LancamentoDTO lancamentoDTO = new LancamentoDTO();
							lancamentoDTO.setId(lancamento.getId());
							lancamentoDTO.setCadastro(lancamento.getCadastro());
							lancamentoDTO.setAtualizacao(lancamento.getAtualizacao());
							lancamentoDTO.setDescricao(lancamento.getDescricao());
							lancamentoDTO.setAtivo(FlagAtivo.ATIVO);

							if (lancamento.getTipoLancamento().equals(TipoLancamento.CREDITO.getValor())) {
								valorCredito = +lancamento.getValor();
								centroGastosDTO.setRecebimento(valorCredito);
								lancamentoDTO.setTipoLancamento(TipoLancamento.CREDITO);
								lancamentoDTO.setValor(lancamento.getValor());
								
								String valor = lancamento.getTipoRecebimento();
								switch (valor) {
								case "Salário":
									lancamentoDTO.setTipoRecebimento(TipoRecebimento.SALARIO);
									break;
								case "Investimento":
									lancamentoDTO.setTipoRecebimento(TipoRecebimento.INVESTIMENTO);
									break;
								case "Freelancer":
									lancamentoDTO.setTipoRecebimento(TipoRecebimento.FREELANCER);
									break;
								case "Herança":
									lancamentoDTO.setTipoRecebimento(TipoRecebimento.HERANCA);
									break;
								}

							} else {
								valorDebito =+ lancamento.getValor();
								centroGastosDTO.setPagamento(valorDebito);
								lancamentoDTO.setTipoLancamento(TipoLancamento.DEBITO);
								lancamentoDTO.setValor(lancamento.getValor());
								
								String valor = lancamento.getTipoGasto();
								
								switch (valor) {
								case "Moradia":
									lancamentoDTO.setTipoGastos(TipoGastos.MORADIA);
									break;
								case "Bares e Restaurantes":
									lancamentoDTO.setTipoGastos(TipoGastos.BARES_RESTAURANTES);
									break;
								case "Mercado":
									lancamentoDTO.setTipoGastos(TipoGastos.MERCADO);
									break;
								case "Lazer":
									lancamentoDTO.setTipoGastos(TipoGastos.LAZER);
									break;
								case "Compras":
									lancamentoDTO.setTipoGastos(TipoGastos.COMPRAS);
									break;
								case "Outros":
									lancamentoDTO.setTipoGastos(TipoGastos.OUTROS);
									break;
								}
							}
							lancamentosDTOList.add(lancamentoDTO);
						}
						lancamentoDTOArrayList.add(lancamentosDTOList);
					}
				}
				Double valorSaldo = valorCredito - valorDebito;
				centroGastosDTO.setSaldo(valorSaldo);
				centroGastosDTO.setUsuario(usuario);
				centroGastosDTO.setLancamentoList(lancamentoDTOArrayList);

				return centroGastosDTO;
			}else {
				throw new ValidacaoException(MensagemErro.USUARIO_CENTRO_GASTOS);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	private LocalDate toLocalDate(Date d) {
		Instant instant = Instant.ofEpochMilli(d.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}
}