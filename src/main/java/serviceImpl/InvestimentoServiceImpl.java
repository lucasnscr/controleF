package serviceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Constantes.MensagemErro;
import dto.InvestimentoDTO;
import entity.Investimento;
import enums.FlagAtivo;
import enums.Rentabilidade;
import enums.TipoInvestimento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.InvestimentoRepository;
import service.InvestimentoService;
import validacoes.ValidacoesImpl;

/**
 * 
 * @author lucasnscr
 * CRUD de investimento e realização de cálculos
 *
 */

@Service
public class InvestimentoServiceImpl implements InvestimentoService {

	@Autowired
	private InvestimentoRepository investimentoRepository;
	
	@Autowired
	private ValidacoesImpl validacao;
	
	@Override
	public Long incluir(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException {
		
		try {
			validacao.ValidaInvestimento(investimentoDTO);
			validacao.validaUsuario(investimentoDTO.getUsuario().getId());
			
			Investimento investimento = null;
			
			if(investimentoDTO.getInicio() != null) {
				investimentoDTO.setInicio(Date.from(Instant.now()));
			}
			
			LocalDate inicio = toLocalDate(investimentoDTO.getInicio());
			LocalDate fim = toLocalDate(investimentoDTO.getFim());

			Boolean validaData = validacao.validaData(inicio, fim);
			if(validaData) {
				
				BeanUtils.copyProperties(investimentoDTO, investimento);
				Investimento investimentoSave = investimentoRepository.save(investimento);
				
				if(investimentoSave != null) {
					return investimentoSave.getId();
				}else {
					throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.INVESTIMENTO));
				}
			}else {
				throw new ValidacaoException(MensagemErro.ERRO_DATA_FIM_INVESTIMENTO);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public InvestimentoDTO alterar(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.ValidaInvestimento(investimentoDTO);
			validacao.validaUsuario(investimentoDTO.getUsuario().getId());
			
			LocalDate inicio = toLocalDate(investimentoDTO.getInicio());
			LocalDate fim = toLocalDate(investimentoDTO.getFim());
			
			Boolean validaData = validacao.validaData(inicio, fim);
			if(!validaData) {
				throw new ValidacaoException(MensagemErro.ERRO_DATA_FIM_INVESTIMENTO);
			}else {
				
				Investimento investimento =  investimentoRepository.findByIdAndAtivo(investimentoDTO.getId(), FlagAtivo.ATIVO.getValor());
				if(investimento != null) {
					
					BeanUtils.copyProperties(investimentoDTO, investimento);
					Investimento investimentoSave = investimentoRepository.save(investimento);

					if(investimentoSave != null) {
						BeanUtils.copyProperties(investimentoSave, investimentoDTO);
					}else {
						throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.INVESTIMENTO));
					}
					
				}else {
					throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public InvestimentoDTO inativar(Long id) throws ServicoException, ValidacaoException {
		try {
			Investimento investimento = investimentoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO.getValor());
			if(investimento != null) {
				investimento.setAtivo(FlagAtivo.INATIVO.getValor());
				Investimento investimentoSave = investimentoRepository.save(investimento);
				if(investimentoSave !=  null) {
					InvestimentoDTO investimentoDTO = null;
					BeanUtils.copyProperties(investimento, investimentoDTO);
					return investimentoDTO;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<InvestimentoDTO> listarInvestimentoUsuario(Long idUsuario) throws ServicoException, ValidacaoException {
		try {
			validacao.validaUsuario(idUsuario);
			List<Investimento> investimentos = investimentoRepository.findByIdUsuarioAndAtivo(idUsuario, FlagAtivo.ATIVO.getValor());
			if(CollectionUtils.isNotEmpty(investimentos)) {
				List<InvestimentoDTO> investimentosDTO =  new ArrayList<>();
				for (Investimento investimento : investimentos) {
					InvestimentoDTO investimentoDTO = new InvestimentoDTO();
					BeanUtils.copyProperties(investimento, investimentoDTO);
					investimentosDTO.add(investimentoDTO);
				}
				return investimentosDTO;
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.INVESTIMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public InvestimentoDTO detalharInvestimento(Long id) throws ServicoException, ValidacaoException {
		try {
			Investimento investimento = investimentoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO.getValor());
			if(investimento != null) {
				InvestimentoDTO investimentoDTO =  null;
				BeanUtils.copyProperties(investimento, investimentoDTO);
				return investimentoDTO;
			}else {
				throw new ServicoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.INVESTIMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public InvestimentoDTO simularInvestimento(InvestimentoDTO investimentoDTO)
			throws ServicoException, ValidacaoException {
		try {
			
			String tipoInvestidor = investimentoDTO.getTipoInvestidor();
			if(!tipoInvestidor.equals(null) && !tipoInvestidor.equals("")) {
				switch (tipoInvestidor) {
				case "RendaMensalDesejada":
					Double rendaMensalDesejada = investimentoDTO.getRendaMensal();
					TipoInvestimento tipoInvestimento = investimentoDTO.getTipoInvestimento();
					if(rendaMensalDesejada != null || tipoInvestimento !=  null) {
						Double valorAcumulado =  (rendaMensalDesejada * 12) / tipoInvestimento.getValor();
						investimentoDTO.setInvestimentoNecessario(valorAcumulado);
						return investimentoDTO;
					}else {
						throw new ValidacaoException(MensagemErro.SIMULACAO_INVESTIMENTO);
					}
									
				case "RendimentoMensalInvestimentoPeriodo":
					Double valorInvestimento = investimentoDTO.getValor();
					Rentabilidade jurosInvestimento = investimentoDTO.getRentabilidade();
					if(valorInvestimento != null || jurosInvestimento != null) {
						Double saldo = investimentoDTO.getSaldo();
						Double total = saldo + valorInvestimento;
						if(investimentoDTO.getInicio()!= null && investimentoDTO.getFim() != null){
							LocalDate inicio = toLocalDate(investimentoDTO.getInicio());
							LocalDate fim = toLocalDate(investimentoDTO.getFim());
							if(investimentoDTO.getRentabilidade() != null) {
								long meses = inicio.until(fim, ChronoUnit.MONTHS);
								List<Double> rendimentoPeriodo =  new ArrayList<Double>();
								for (int i = 0; i <= meses; i++) {
									Double rendimentoMensal = (investimentoDTO.getRentabilidade().getValor() * total)/100;
									rendimentoPeriodo.add(rendimentoMensal);
								}
								investimentoDTO.setRendimentoMensalPeriodo(rendimentoPeriodo);
								return investimentoDTO;
							}
						}
					}else {
						throw new ValidacaoException(MensagemErro.SIMULACAO_INVESTIMENTO);
					}
				default:
					throw new ValidacaoException(MensagemErro.OPCAO_INVALIDA);
				}
			}else {
				throw new ValidacaoException(MensagemErro.SIMULACAO_INVESTIMENTO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}
	
	private LocalDate toLocalDate(Date d) {
		Instant instant = Instant.ofEpochMilli(d.getTime());
		LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

}
