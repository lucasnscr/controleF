package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import MensagensErro.MensagemErro;
import dto.TelefoneDTO;
import entity.Telefone;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.TelefoneRepository;
import service.TelefoneService;
import validacoes.ValidacoesImpl;

public class TelefoneServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private ValidacoesImpl validacoes;
	
	@Override
	public TelefoneDTO incluir(TelefoneDTO telefoneDTO) throws ValidacaoException, ServicoException {
		
		
		try {
			Telefone telefone = null;
			validacoes.validaTelefone(telefoneDTO);
			BeanUtils.copyProperties(telefoneDTO, telefone);
			Telefone telefoneSave = telefoneRepository.save(telefone);
			if(telefoneSave != null) {
				BeanUtils.copyProperties(telefoneSave, telefoneDTO);
				return telefoneDTO;
			}else {
				throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.TELEFONE));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public TelefoneDTO alterar(TelefoneDTO telefoneDTO) throws ValidacaoException, ServicoException {
		try {
			Telefone telefone = telefoneRepository.findById(telefoneDTO.getId());
			if(telefone != null) {
				validacoes.validaTelefone(telefoneDTO);
				BeanUtils.copyProperties(telefoneDTO, telefone);
				Telefone telefoneSave = telefoneRepository.save(telefone);
				if(telefoneSave != null) {
					BeanUtils.copyProperties(telefoneSave, telefoneDTO);
					return telefoneDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_ATUALIZAR.concat(MensagemErro.TELEFONE));
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public TelefoneDTO inativar(Long id) throws ValidacaoException, ServicoException {
		try {
			Telefone telefone = telefoneRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO.getValor());
			if(telefone != null) {
				telefone.setAtivo(FlagAtivo.INATIVO.getValor());
				Telefone telefoneSave = telefoneRepository.save(telefone);
				if(telefoneSave != null) {
					TelefoneDTO telefoneDTO = null;
					BeanUtils.copyProperties(telefone, telefoneDTO);
					return telefoneDTO;
				}else{
					throw new ServicoException(MensagemErro.ERRO_ATUALIZAR.concat(MensagemErro.TELEFONE));
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
	public List<TelefoneDTO> listarTelefoneUsuario(Long idUsuario) throws ValidacaoException, ServicoException {
		try {
			validacoes.validaUsuario(idUsuario);
			List<Telefone> telefones = telefoneRepository.findByIdUsuario(idUsuario);
			if(CollectionUtils.isNotEmpty(telefones)) {
				List<TelefoneDTO> telefonesDTO =  new ArrayList<>();
				for (Telefone telefone : telefones) {
					TelefoneDTO telefoneDTO = new TelefoneDTO();
					BeanUtils.copyProperties(telefone, telefoneDTO);
					telefonesDTO.add(telefoneDTO);
				}
				return telefonesDTO;
			}else{
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public TelefoneDTO detalharTelefone(Long id) throws ValidacaoException, ServicoException {
		try {
			Telefone telefone = telefoneRepository.findById(id);
			if(telefone != null) {
				TelefoneDTO telefoneDTO = null;
				BeanUtils.copyProperties(telefone, telefoneDTO);
				return telefoneDTO;
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
