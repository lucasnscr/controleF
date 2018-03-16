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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import Constantes.MensagemErro;
import dto.AnaliseCentroGastosDTO;
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

	private static final String emailControleF = "l.nascimento.scr@gmail.com";

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
								valorDebito = +lancamento.getValor();
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
			} else {
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

	@Override
	public AnaliseCentroGastosDTO analiseCentroGastos(Long idCentroGastos) throws ValidacaoException, ServicoException {

		try {

			CentroGastos centroGastos = centroGastosRepository.findById(idCentroGastos);

			if (centroGastos != null) {

				AnaliseCentroGastosDTO analise = new AnaliseCentroGastosDTO();

				List<Lancamento> lancamentos = centroGastos.getLancamentos();

				Double valorReceita = 0.0;
				Double valorDebito = 0.0;
				Integer qtdDespesa = 0;
				Integer qtdReceita = 0;

				for (Lancamento lancamento : lancamentos) {
					String tipoLancamento = lancamento.getTipoLancamento();

					if (StringUtils.isBlank(tipoLancamento)) {
						throw new ValidacaoException(MensagemErro.ERRO_INFORME_TIPO_LANCAMENTO);
					}

					if (lancamento.getTipoGasto().equals(TipoLancamento.CREDITO.valor)) {
						qtdReceita++;
						valorReceita = +lancamento.getValor();

					} else if (lancamento.getTipoGasto().equals(TipoLancamento.DEBITO.valor)) {
						qtdDespesa++;
						valorDebito = +lancamento.getValor();

					}

				}

				Double valorMedioReceita = calcularMedia(valorReceita, qtdReceita);
				Double valorMedioDespesa = calcularMedia(valorDebito, qtdDespesa);

				analise.setValorMedioReceita(valorMedioReceita);
				analise.setValorMedioDespesa(valorMedioDespesa);

				return analise;

			} else {
				throw new ServicoException(MensagemErro.CENTRO_GASTOS_INVALIDO);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	private Double calcularMedia(Double valor, Integer qtd) {
		return valor / qtd;
	}

	@Override
	public Integer enviarEmail(CentroGastosDTO centroGastosDTO) {
		try {
			Long id = centroGastosDTO.getId();
			CentroGastos centroGastos = centroGastosRepository.findByIdUsuario(id);
			if (centroGastos != null) {
				Long idUsurio = centroGastos.getIdUsurio();
				Usuario usuario = validacao.validaUsuario(idUsurio);
				if (usuario != null) {
					String emailCliente = usuario.getEmail();
					if (!StringUtils.isBlank(emailCliente)) {
						AnaliseCentroGastosDTO analiseCentroGastos = analiseCentroGastos(id);
						
						Double valorMedioDespesa = analiseCentroGastos.getValorMedioDespesa();
						Double valorMedioReceita = analiseCentroGastos.getValorMedioReceita();
						
						String valorDespesaEmail = String.valueOf(valorMedioDespesa);
						String valorReceitaEmail = String.valueOf(valorMedioReceita);

						Email from = new Email(emailControleF);
						String subject = "Centro de Gastos";
						Email to = new Email(emailCliente);
						Content content = new Content("A receita média foi de: " + valorReceitaEmail, "\n" + "A despesa média foi de: " + valorDespesaEmail);
						Mail mail = new Mail(from, subject, to, content);
						
						
						SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
						
						Request request = new Request();
						request.setMethod(Method.POST);
						request.setEndpoint("mail/send");
						request.setBody(mail.build());
						Response response = sg.api(request);
						System.out.println(response.getStatusCode());
						System.out.println(response.getBody());
						System.out.println(response.getHeaders());
						
						return response.getStatusCode();
					} else {
						throw new ValidacaoException(MensagemErro.EMAIL_NAO_INFORMADO);
					}

				} else {
					throw new ValidacaoException(MensagemErro.ERRO_USUARIO_INEXISTENTE);
				}

			} else {
				throw new ValidacaoException(MensagemErro.CENTRO_GASTOS_INVALIDO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}