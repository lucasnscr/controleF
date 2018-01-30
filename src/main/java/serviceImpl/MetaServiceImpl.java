package serviceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import Constantes.MensagemErro;
import dto.MetaDTO;
import entity.Meta;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.MetaRepository;
import service.MetaService;
import validacoes.ValidacoesImpl;

public class MetaServiceImpl implements MetaService {

	@Autowired
	private MetaRepository metaRepository;
	
	@Autowired
	private ValidacoesImpl validacoes;
	
	@Override
	public MetaDTO incluir(MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		try {
			validacoes.validaUsuario(metaDTO.getUsuario().getId());
			validacoes.validaMeta(metaDTO);
			
			LocalDate inicio = toLocalDate(metaDTO.getDataInicio());
			LocalDate fim = toLocalDate(metaDTO.getDataFinal());
			
			Boolean validaData = validacoes.validaData(inicio, fim);
			if(!validaData) {
				throw new ValidacaoException(MensagemErro.ERRO_DATA_MENOR);
			}
			
			Meta meta =  null;
			BeanUtils.copyProperties(metaDTO, meta);
			Meta metaSave = metaRepository.save(meta);
			if(metaSave != null) {
				BeanUtils.copyProperties(metaSave, metaDTO);
				return metaDTO;
			}else {
				throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.META));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public MetaDTO alterar(MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		try {
			validacoes.validaUsuario(metaDTO.getUsuario().getId());
			validacoes.validaMeta(metaDTO);
			
			LocalDate inicio = toLocalDate(metaDTO.getDataInicio());
			LocalDate fim = toLocalDate(metaDTO.getDataFinal());
			
			Boolean validaData = validacoes.validaData(inicio, fim);
			if(!validaData) {
				throw new ValidacaoException(MensagemErro.ERRO_DATA_FIM_INVESTIMENTO);
			}
			Meta meta =  metaRepository.findById(metaDTO.getId());
			if(meta != null) {
				BeanUtils.copyProperties(metaDTO, meta);
				Meta metaSave = metaRepository.save(meta);
				if(metaSave != null) {
					BeanUtils.copyProperties(metaSave, metaDTO);
					return metaDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.META));
				}
			}else{
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public MetaDTO inativar(Long id) throws ValidacaoException, ServicoException {
		try {
			Meta meta = metaRepository.findById(id);
			if(meta != null) {
				meta.setAtivo(FlagAtivo.INATIVO.getValor());
				Meta metaSave = metaRepository.save(meta);
				if(metaSave != null) {
					MetaDTO metaDTO =  null;
					BeanUtils.copyProperties(meta, metaDTO);
					return metaDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_INATIVAR.concat(MensagemErro.META));
				}
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public List<MetaDTO> pesquisarMeta(Long idUsuario) throws ValidacaoException, ServicoException {
		try {
			List<Meta> pesquisaMeta = metaRepository.findByIdUsuario(idUsuario);
			if(CollectionUtils.isNotEmpty(pesquisaMeta)) {
				List<MetaDTO> metasDTO =  new ArrayList<>();
				for (Meta meta : pesquisaMeta) {
					MetaDTO metaDTO =  new MetaDTO();
					BeanUtils.copyProperties(meta, metaDTO);
					metasDTO.add(metaDTO);
				}
				return metasDTO;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public MetaDTO detalheMeta(Long id) throws ValidacaoException, ServicoException {
		try {
			Meta meta = metaRepository.findById(id);
			if(meta != null) {
				MetaDTO metaDTO = null;
				BeanUtils.copyProperties(meta, metaDTO);
				return metaDTO;
			}else {
				throw new ServicoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
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
