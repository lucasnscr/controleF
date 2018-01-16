package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import MensagensErro.MensagemErro;
import dto.EnderecoDTO;
import entity.Endereco;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.EnderecoRepository;
import service.EnderecoService;
import validacoes.ValidacoesImpl;

public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ValidacoesImpl validacao;

	@Override
	public EnderecoDTO incluir(EnderecoDTO enderecoDTO) throws ValidacaoException, ServicoException {
		try {
			
			validacao.validaUsuario(enderecoDTO.getUsuario().getId());
			validacao.validaEndereco(enderecoDTO);
			
			Endereco endereco =  new Endereco();
			endereco.setIdUsuario(enderecoDTO.getUsuario().getId());
			endereco.setLogradouro(enderecoDTO.getLogradouro());
			endereco.setBairro(enderecoDTO.getBairro());
			endereco.setCidade(enderecoDTO.getCidade());
			endereco.setEstado(enderecoDTO.getEstado());
			endereco.setPais(enderecoDTO.getPais());
			endereco.setAtivo(FlagAtivo.ATIVO.getValor());
			
			Endereco enderecoSave = enderecoRepository.save(endereco);
			
			if(enderecoSave != null) {
				BeanUtils.copyProperties(enderecoSave, enderecoDTO);
				return enderecoDTO;
			}else {
				throw new ServicoException(MensagemErro.ERRO_AO_INSERIR_ENDERECO);
			}
		
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public EnderecoDTO alterar(EnderecoDTO enderecoDTO) throws ValidacaoException, ServicoException {
		try {
			validacao.enderecoJaExiste(enderecoDTO.getId());
			validacao.validaEndereco(enderecoDTO);
			Endereco endereco = enderecoRepository.findById(enderecoDTO.getId());
			if(endereco != null) {
				BeanUtils.copyProperties(enderecoDTO, endereco);
				Endereco enderecoSave = enderecoRepository.save(endereco);
				if(enderecoSave != null) {
					BeanUtils.copyProperties(enderecoSave, enderecoDTO);
					return enderecoDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_AO_ATUALIZAR_ENDERECO);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public EnderecoDTO inativar(Long id) throws ValidacaoException, ServicoException {
		try {
			Endereco endereco = enderecoRepository.findById(id);
			if(endereco !=null) {
				endereco.setAtivo(FlagAtivo.INATIVO.getValor());
				Endereco enderecoSave = enderecoRepository.save(endereco);
				if(enderecoSave != null) {
					EnderecoDTO enderecoDTO = null;
					BeanUtils.copyProperties(enderecoSave, enderecoDTO);
					return enderecoDTO;
				}else {
					throw new ServicoException(MensagemErro.ERRO_AO_INSERIR_ENDERECO);
				}
			}else{
				throw new ValidacaoException(MensagemErro.ERRO_PESQUISAR_ENDERECO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<EnderecoDTO> listarEnderecoUsuario(Long idUsuario) throws ValidacaoException, ServicoException {
		try {
			validacao.validaUsuario(idUsuario);
			List<Endereco> enderecos = enderecoRepository.findByIdUsuarioAndAtivo(idUsuario, FlagAtivo.ATIVO.getValor());
			if(CollectionUtils.isNotEmpty(enderecos)) {
				List<EnderecoDTO> enderecosDTO = new ArrayList<>();
				for (Endereco endereco : enderecos) {
					EnderecoDTO enderecoDTO =  new EnderecoDTO();
					BeanUtils.copyProperties(endereco, enderecoDTO);
					enderecosDTO.add(enderecoDTO);
				}
				
			}else{
				throw new ValidacaoException(MensagemErro.ERRO_PESQUISAR_ENDERECO);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public EnderecoDTO detalharEndereco(Long id) throws ValidacaoException, ServicoException {
		try {
			Endereco endereco = enderecoRepository.findById(id);
			if(endereco != null) {
				EnderecoDTO enderecoDTO = null;
				BeanUtils.copyProperties(endereco, enderecoDTO);
				return enderecoDTO;
			}else {
				throw new ValidacaoException(MensagemErro.ERRO_PESQUISAR_ENDERECO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
