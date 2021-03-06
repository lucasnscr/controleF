package validacoes;

import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Constantes.MensagemErro;
import dto.EnderecoDTO;
import dto.InvestimentoDTO;
import dto.LancamentoDTO;
import dto.MetaDTO;
import dto.TelefoneDTO;
import entity.Endereco;
import entity.Usuario;
import enums.Escolaridade;
import enums.TipoDocumento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.EnderecoRepository;
import repository.UsuarioRepository;

@Component
public class ValidacoesImpl {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public void validaLogin(String login) throws ValidacaoException {
		try {
			if (StringUtils.isNotBlank(login)) {
				Usuario usuario = usuarioRepository.findByLogin(login);
				if (usuario != null) {
					throw new ValidacaoException(MensagemErro.USER_JA_EXISTENTE);
				}
			} else {
				throw new ValidacaoException(MensagemErro.USER_NAO_INFORMADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaEmail(String email, String confirmacaoEmail) throws ValidacaoException {
		try {
			if (StringUtils.isNotBlank(email)) {
				Usuario usuario = usuarioRepository.findByEmail(email);
				if (usuario != null) {
					throw new ValidacaoException(MensagemErro.EMAIL_JA_CADASTRADO);
				} else {
					if (StringUtils.isNotBlank(confirmacaoEmail)) {
						if (!StringUtils.equals(email, confirmacaoEmail)) {
							throw new ValidacaoException(MensagemErro.CONFIRMACAO_DE_EMAIL_INVALIDA);
						}
					} else {
						throw new ValidacaoException(MensagemErro.CONFIRMACAO_DE_EMAIL_NAO_INFORMADA);
					}
				}
			} else {
				throw new ValidacaoException(MensagemErro.EMAIL_NAO_INFORMADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaSenha(String senha, String confirmaSenha) throws ValidacaoException {
		try {
			if (StringUtils.isNotBlank(senha)) {
				if (senha.length() <= 5 && senha.length() >= 13) {
					throw new ValidacaoException(MensagemErro.TAMANHO_DE_SENHA_INVALIDO);
				}
				if (!StringUtils.equals(senha, confirmaSenha)) {
					throw new ValidacaoException(MensagemErro.ERRO_CONFIRMA_SENHA);
				}
			} else {
				throw new ValidacaoException(MensagemErro.SENHA_NAO_INFORMADA);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaDocumento(TipoDocumento tipoDocumento, String documento) throws ValidacaoException {
		try {
			if (tipoDocumento.getValor() != 1 || tipoDocumento.getValor() != 2) {
				throw new ValidacaoException(MensagemErro.TIPO_DOCUMENTO_INVALIDO);
			}

			if (1 == tipoDocumento.getValor()) {
				if (!"".equals(documento) || (documento.length() > 11 || documento.length() < 9)) {
					throw new ValidacaoException(MensagemErro.CPF_INVALIDO);
				}
			} else {
				if (documento.length() < 14) {
					throw new ValidacaoException(MensagemErro.CNPJ_INVALIDO);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaTermoServico(Boolean termoServico) throws ValidacaoException {
		try {
			if (!termoServico) {
				throw new ValidacaoException(MensagemErro.TERMO_SERVICO_NAO_ASSINADO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Long geraChave() {
		Random gerador = new Random();
		long nextLong = gerador.nextLong();
		return nextLong;
	}

	public Usuario validaUsuario(Long id) throws ValidacaoException {
		try {
			Usuario usuario = usuarioRepository.findById(id);
			if (usuario == null) {
				throw new ValidacaoException(MensagemErro.ERRO_USUARIO_INEXISTENTE);
			}
			return usuario;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public void validaEscolaridade(Escolaridade escolaridade) throws ValidacaoException {
		try {
			if (escolaridade.getValor() > 10 && escolaridade.getValor() < 1) {
				throw new ValidacaoException(MensagemErro.ESCOLARIDADE_INVALIDA);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaEndereco(EnderecoDTO endercoDTO) throws ValidacaoException, ServicoException {

		try {
			if (StringUtils.isBlank(endercoDTO.getLogradouro()) || StringUtils.isBlank(endercoDTO.getBairro())
					|| StringUtils.isBlank(endercoDTO.getCidade()) || StringUtils.isBlank(endercoDTO.getPais())) {
				throw new ValidacaoException(MensagemErro.ERRO_ENDERECO_DADOS);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void enderecoJaExiste(Long id) throws ValidacaoException {
		try {
			Endereco endereco = enderecoRepository.findById(id);
			if (endereco == null) {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaTelefone(TelefoneDTO telefoneDTO) throws ValidacaoException {
		try {
			if (null == telefoneDTO.getCodigoPais()) {
				throw new ValidacaoException(MensagemErro.ERRO_TELEFONE_CODIGO_PAIS);
			}

			if (null == telefoneDTO.getDdd() || telefoneDTO.getDdd() < 2) {
				throw new ValidacaoException(MensagemErro.ERRO_TELEFONE_DDD);
			}

			if (null == telefoneDTO.getUsuario() && telefoneDTO.getNumero() < 6) {
				throw new ValidacaoException(MensagemErro.ERRO_TELEFONE_USUARIO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validaMeta(MetaDTO metaDTO) throws ValidacaoException {
		try {
			if (metaDTO.getUsuario().getId() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_USUARIO_META);
			}

			if (metaDTO.getDataInicio() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_DT_INICIO_META);
			}

			if (metaDTO.getDataFinal() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_DT_FIM_META);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Boolean validaData(LocalDate inicio, LocalDate fim) throws ValidacaoException {
		Boolean dataValida = null;
		if (fim.isAfter(inicio)) {
			dataValida = true;
		} else {
			dataValida = false;
		}
		return dataValida;
	}

	public void ValidaInvestimento(InvestimentoDTO investimentoDTO) throws ValidacaoException {
		try {
			if (investimentoDTO.getUsuario().getId() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_USUARIO_INVESTIMENTO);
			}

			if (investimentoDTO.getValor() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_VALOR_INVESTIMENTO);
			}

			if (investimentoDTO.getFim() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_DATA_FIM_INVESTIMENTO);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void validaLancamento(LancamentoDTO lancamentoDTO) throws ValidacaoException {
		try {
			if (lancamentoDTO.getTipoLancamento() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_INFORME_TIPO_LANCAMENTO);
			}
			if (lancamentoDTO.getValor() == null) {
				throw new ValidacaoException(MensagemErro.ERRO_INFORME_TIPO_LANCAMENTO);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
