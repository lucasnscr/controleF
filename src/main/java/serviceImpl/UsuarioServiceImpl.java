package serviceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import MensagensErro.MensagemErro;
import dto.AlteraDadosUsuarioDTO;
import dto.CadastroUsuarioDTO;
import dto.GerenciarUsuarioDTO;
import entity.CentroGastos;
import entity.Usuario;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import repository.UsuarioRepository;
import service.UsuarioService;
import validacoes.ValidacoesImpl;

/**
 * 
 * @author ldnascimento
 * Incluir usuário e seu centro de gastos
 */

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ValidacoesImpl validacoes;

	@Autowired
	private CentroGastosRepository centroGastosRepository;
	
	@Override
	@Rollback(value=true)
	public CadastroUsuarioDTO incluir(CadastroUsuarioDTO cadUsuarioDTO) throws ServicoException {
		try {
			Usuario usuario = new Usuario();
			CentroGastos gastos =  new CentroGastos();

			validacoes.validaLogin(cadUsuarioDTO.getLogin());
			validacoes.validaEmail(cadUsuarioDTO.getEmail(), cadUsuarioDTO.getEmailConfirmacao());
			validacoes.validaSenha(cadUsuarioDTO.getSenha(), cadUsuarioDTO.getConfirmaSenha());
			validacoes.validaDocumento(cadUsuarioDTO.getTipoDocumento(), cadUsuarioDTO.getDocumento());
			validacoes.validaTermoServico(cadUsuarioDTO.getTermoServico());
			Long geraChave = validacoes.geraChave();

			usuario.setLogin(cadUsuarioDTO.getLogin());
			usuario.setEmail(cadUsuarioDTO.getEmail());
			usuario.setSenha(cadUsuarioDTO.getSenha());
			usuario.setDocumento(cadUsuarioDTO.getDocumento());
			usuario.setCadastro(LocalDate.now());
			usuario.setAtualizacao(LocalDate.now());
			usuario.setAtivo(FlagAtivo.ATIVO.getValor());
			usuario.setChave(geraChave);

			Usuario usuCadastrado = usuarioRepository.save(usuario);
			if (usuCadastrado == null) {
				throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.USUARIO));
			} else {
				BeanUtils.copyProperties(usuCadastrado, cadUsuarioDTO);
				gastos.setIdUsurio(usuCadastrado.getId());
				gastos.setMêsAno(Date.from(Instant.now()));
				CentroGastos centroGastos = centroGastosRepository.save(gastos);
				if(centroGastos == null) {
					throw new ValidacaoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.CENTRO_GASTOS));
				}
			}
			return cadUsuarioDTO;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public AlteraDadosUsuarioDTO alterar(AlteraDadosUsuarioDTO alteraDadosUsuarioDTO)
			throws ValidacaoException, ServicoException {
		try {
			Usuario usuario = new Usuario();
			validacoes.validaUsuario(alteraDadosUsuarioDTO.getId());
			validacoes.validaEscolaridade(alteraDadosUsuarioDTO.getEscolaridade());
			if (alteraDadosUsuarioDTO.getNome() != null) {
				usuario.setNome(alteraDadosUsuarioDTO.getNome());
			}

			validacoes.validaDocumento(alteraDadosUsuarioDTO.getTipoDocumento(), alteraDadosUsuarioDTO.getDocumento());
			usuario.setDocumento(alteraDadosUsuarioDTO.getDocumento());

			if (alteraDadosUsuarioDTO.getDataNascimento() != null) {
				usuario.setDataNascimento(alteraDadosUsuarioDTO.getDataNascimento());
			}

			if (alteraDadosUsuarioDTO.getSexo() != null) {
				usuario.setSexo(alteraDadosUsuarioDTO.getSexo());
			}

			if (alteraDadosUsuarioDTO.getCidade() != null) {
				usuario.setCidade(alteraDadosUsuarioDTO.getCidade());
			}

			if (alteraDadosUsuarioDTO.getEstado() != null) {
				usuario.setEstado(alteraDadosUsuarioDTO.getEstado());
			}

			if (alteraDadosUsuarioDTO.getEstado() != null) {
				usuario.setEstado(alteraDadosUsuarioDTO.getEstado());
			}

			if (alteraDadosUsuarioDTO.getPais() != null) {
				usuario.setPais(alteraDadosUsuarioDTO.getPais());
			}

			Usuario usuAlterado = usuarioRepository.save(usuario);
			if (usuAlterado != null) {
				BeanUtils.copyProperties(usuAlterado, alteraDadosUsuarioDTO);
			} else {
				throw new ServicoException(MensagemErro.ERRO_ATUALIZAR.concat(MensagemErro.USUARIO));
			}

			return alteraDadosUsuarioDTO;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public GerenciarUsuarioDTO inativar(Long id) throws ValidacaoException, ServicoException {
		GerenciarUsuarioDTO gerenciarUsuarioDTO = null;
		try {
			Usuario usuario = usuarioRepository.findById(id);
			if (usuario != null) {
				usuario.setAtivo(FlagAtivo.INATIVO.getValor());
				Usuario usuarioInativado = usuarioRepository.save(usuario);
				if (usuarioInativado != null) {
					BeanUtils.copyProperties(usuarioInativado, gerenciarUsuarioDTO);
				} else {
					throw new ServicoException(MensagemErro.ERRO_INATIVAR.concat(MensagemErro.USUARIO));
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return gerenciarUsuarioDTO;
	}

	@Override
	public GerenciarUsuarioDTO alteraEmail(GerenciarUsuarioDTO gerenciarUsuarioDTO)
			throws ValidacaoException, ServicoException {
		try {
			if (!gerenciarUsuarioDTO.getEmailAtual().equals(gerenciarUsuarioDTO.getEmailNovo())) {
				if (gerenciarUsuarioDTO.getEmailNovo().equals(gerenciarUsuarioDTO.getConfirmaEmailNovo())) {
					Usuario usuario = usuarioRepository.findById(gerenciarUsuarioDTO.getId());
					if (usuario != null) {
						usuario.setEmail(gerenciarUsuarioDTO.getEmailNovo());
						Usuario usuEmailNovo = usuarioRepository.save(usuario);
						if (usuEmailNovo != null) {
							BeanUtils.copyProperties(usuEmailNovo, gerenciarUsuarioDTO);
							return gerenciarUsuarioDTO;
						} else {
							throw new ServicoException(MensagemErro.ALTERACAO_EMAIL_INVALIDA);
						}
					}
				} else {
					throw new ValidacaoException(MensagemErro.ALTERACAO_EMAIL_INVALIDA);
				}
			} else {
				throw new ValidacaoException(MensagemErro.ALTERACAO_EMAIL_INVALIDA);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public GerenciarUsuarioDTO alteraSenha(GerenciarUsuarioDTO gerenciarUsuarioDTO)
			throws ValidacaoException, ServicoException {
		try {
			Usuario usuario = usuarioRepository.findById(gerenciarUsuarioDTO.getId());
			if (usuario != null) {
				if (!"".equals(gerenciarUsuarioDTO.getSenhaAtual())) {
					if (!gerenciarUsuarioDTO.getSenhaAtual().equals(gerenciarUsuarioDTO.getSenhaNovo())) {
						usuario.setSenha(gerenciarUsuarioDTO.getSenhaNovo());
						Usuario usuSenhaNova = usuarioRepository.save(usuario);
						if (usuSenhaNova != null) {
							BeanUtils.copyProperties(usuSenhaNova, gerenciarUsuarioDTO);
							return gerenciarUsuarioDTO;
						} else {
							throw new ServicoException(MensagemErro.ALTERACAO_SENHA_INVALIDA);
						}
					} else {
						throw new ValidacaoException(MensagemErro.ALTERACAO_SENHA_INVALIDA);
					}
				} else {
					throw new ValidacaoException(MensagemErro.ALTERACAO_SENHA_INVALIDA);
				}
			} else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
