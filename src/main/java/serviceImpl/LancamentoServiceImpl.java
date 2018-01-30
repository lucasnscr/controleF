package serviceImpl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import Constantes.MensagemErro;
import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import entity.CentroGastos;
import entity.Lancamento;
import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import repository.LancamentoRepository;
import service.LancamentoService;
import validacoes.ValidacoesImpl;

public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ValidacoesImpl validacao;
	
	@Autowired
	private CentroGastosRepository centroGastosRepository;

	@Override
	public Long incluir(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.validaLancamento(lancamentoDTO);
			Lancamento lancamento = new Lancamento();
			BeanUtils.copyProperties(lancamentoDTO, lancamento);
			CentroGastos centroGastos = centroGastosRepository.findByIdUsuario(lancamentoDTO.getIdUsuario());
			if(centroGastos != null) {
				lancamento.setIdCentroGastos(centroGastos.getId());
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.CENTRO_GASTOS));
			}
			if (lancamentoDTO.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
				String valor = lancamentoDTO.getTipoRecebimento().getValor();
				switch (valor) {
				case "Salário":
					lancamento.setTipoRecebimento(TipoRecebimento.SALARIO.getValor());
					break;
				case "Investimento":
					lancamento.setTipoRecebimento(TipoRecebimento.INVESTIMENTO.getValor());
					break;
				case "Freelancer":
					lancamento.setTipoRecebimento(TipoRecebimento.FREELANCER.getValor());
					break;
				case "Herança":
					lancamento.setTipoRecebimento(TipoRecebimento.HERANCA.getValor());
					break;
				}
			}else{
				String valor = lancamentoDTO.getTipoGastos().getValor();
				switch (valor) {
				case "Moradia":
					lancamento.setTipoGasto(TipoGastos.MORADIA.getValor());
					break;
				case "Bares e Restaurantes":
					lancamento.setTipoGasto(TipoGastos.BARES_RESTAURANTES.getValor());
					break;
				case "Mercado":
					lancamento.setTipoGasto(TipoGastos.MERCADO.getValor());
					break;
				case "Lazer":
					lancamento.setTipoGasto(TipoGastos.LAZER.getValor());
					break;
				case "Compras":
					lancamento.setTipoGasto(TipoGastos.COMPRAS.getValor());
					break;
				case "Outros":
					lancamento.setTipoGasto(TipoGastos.OUTROS.getValor());
					break;
				}
			}
			
			lancamento.setCadastro(Date.from(Instant.now()));	
			lancamento.setAtualizacao(Date.from(Instant.now()));
			lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
			
			Lancamento lancamentoSave = lancamentoRepository.save(lancamento);
			if(lancamentoSave != null) {
				return lancamentoSave.getId();
			}else {
				throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.LANCAMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	@Override
	public LancamentoDTO alterar(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.validaLancamento(lancamentoDTO);
			Lancamento lancamento = lancamentoRepository.findByIdAndAtivo(lancamentoDTO.getId(), FlagAtivo.ATIVO.getValor());
			if(lancamento != null) {
				if (lancamentoDTO.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
					String valor = lancamentoDTO.getTipoRecebimento().getValor();
					switch (valor) {
					case "Salário":
						lancamento.setTipoRecebimento(TipoRecebimento.SALARIO.getValor());
						break;
					case "Investimento":
						lancamento.setTipoRecebimento(TipoRecebimento.INVESTIMENTO.getValor());
						break;
					case "Freelancer":
						lancamento.setTipoRecebimento(TipoRecebimento.FREELANCER.getValor());
						break;
					case "Herança":
						lancamento.setTipoRecebimento(TipoRecebimento.HERANCA.getValor());
						break;
					}
				}else{
					String valor = lancamentoDTO.getTipoGastos().getValor();
					switch (valor) {
					case "Moradia":
						lancamento.setTipoGasto(TipoGastos.MORADIA.getValor());
						break;
					case "Bares e Restaurantes":
						lancamento.setTipoGasto(TipoGastos.BARES_RESTAURANTES.getValor());
						break;
					case "Mercado":
						lancamento.setTipoGasto(TipoGastos.MERCADO.getValor());
						break;
					case "Lazer":
						lancamento.setTipoGasto(TipoGastos.LAZER.getValor());
						break;
					case "Compras":
						lancamento.setTipoGasto(TipoGastos.COMPRAS.getValor());
						break;
					case "Outros":
						lancamento.setTipoGasto(TipoGastos.OUTROS.getValor());
						break;
					}
				}
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.LANCAMENTO));
			}
			
			Lancamento lancamentoSave = lancamentoRepository.save(lancamento);
			if(lancamentoSave != null) {
				BeanUtils.copyProperties(lancamentoSave, lancamentoDTO);
				return lancamentoDTO;
			}else {
				throw new ValidacaoException(MensagemErro.ERRO_ATUALIZAR.concat(MensagemErro.LANCAMENTO));
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public LancamentoDTO inativar(Long id) throws ServicoException, ValidacaoException {
		try {
			Lancamento lancamento = lancamentoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO.getValor());
			if (lancamento != null) {
				lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
				Lancamento lancamentoSave = lancamentoRepository.save(lancamento);
				if(lancamentoSave != null){
					LancamentoDTO lancamentoDTO =  null;
					BeanUtils.copyProperties(lancamentoSave, lancamentoDTO);
					return lancamentoDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_INATIVAR.concat(MensagemErro.LANCAMENTO));
				}
			}else {
				throw new ServicoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.LANCAMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public LancamentoDTO detalharLancamento(Long id) throws ServicoException, ValidacaoException {
		try {
			Lancamento lancamento = lancamentoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO.getValor());
			if(lancamento !=  null) {
				LancamentoDTO lancamentoDTO = null;
				BeanUtils.copyProperties(lancamento, lancamentoDTO);
				return lancamentoDTO;
			}else {
				throw new ServicoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.LANCAMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public AnaliseLancamentoDTO analiseLancamento(AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		try {
			List<Lancamento> analisarLancamentosList = lancamentoRepository.analisarLancamentosFiltro(analiseLancamentoDTO);
			if (CollectionUtils.isNotEmpty(analisarLancamentosList)) {
				AnaliseLancamentoDTO analise =  new AnaliseLancamentoDTO();
				for (Lancamento lancamento : analisarLancamentosList) {
					if (lancamento.getTipoLancamento().equals(TipoLancamento.CREDITO.getValor())) {
						String valor = lancamento.getTipoRecebimento();
						switch (valor) {
						
						case "Salário":
							Double recebidoSalario =+ lancamento.getValor();
							analise.setValoresRecebidosSalario(recebidoSalario);
							break;
						case "Investimento":
							Double recebidoInvestimento =+ lancamento.getValor();
							analise.setValoresRecebidosInvestimento(recebidoInvestimento);
							break;
						case "Freelancer":
							Double recebidoFreela =+ lancamento.getValor();
							analise.setValoresRecebidosFreelancer(recebidoFreela);
							break;
						case "Herança":
							Double recebidoHeranca =+ lancamento.getValor();
							analise.setValoresRecebidosHeranca(recebidoHeranca);
							break;
						}
						Double valorRecebido =+ lancamento.getValor();
						analise.setValoresRecebidos(valorRecebido);
					}else{
						String valor = lancamento.getTipoGasto();
						switch (valor) {
						case "Moradia":
							Double gastoMoradia =+  lancamento.getValor();
							analise.setValoresGastoMoradia(gastoMoradia);
							break;
						case "Bares e Restaurantes":
							Double gastoBaresRestaurante =+  lancamento.getValor();							
							analise.setValoresGastoBarRestaurante(gastoBaresRestaurante);
							break;
						case "Mercado":
							Double gastoMercado =+  lancamento.getValor();
							analise.setValoresGastoBarRestaurante(gastoMercado);
							break;
						case "Lazer":
							Double gastoLazer =+  lancamento.getValor();
							analise.setValoresGastoBarRestaurante(gastoLazer);
							break;
						case "Compras":
							Double gastoCompras =+  lancamento.getValor();
							analise.setValoresGastoBarRestaurante(gastoCompras);
							break;
						case "Outros":
							Double gastoOutros =+  lancamento.getValor();
							analise.setValoresGastoBarRestaurante(gastoOutros);
							break;
						}
						Double valorGasto =+ lancamento.getValor();
						analise.setValoresGastos(valorGasto);
					}
				}
				return analise;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
