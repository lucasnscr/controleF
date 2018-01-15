package validacoes;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import MensagensErro.MensagemErro;
import entity.Usuario;
import enums.Escolaridade;
import enums.TipoDocumento;
import exceptions.ValidacaoException;
import repository.UsuarioRepository;

public class ValidacoesImpl {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void validaLogin(String login) throws ValidacaoException {
		Usuario usuario =  null;
		try {
			if(!"".equals(login)) {
				usuario = usuarioRepository.findByLogin(login);
				if(usuario != null) {
					throw new ValidacaoException(MensagemErro.USER_JA_EXISTENTE);
				}
			}else {
				throw new ValidacaoException(MensagemErro.USER_NAO_INFORMADO);
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void validaEmail(String email, String confirmacaoEmail) throws ValidacaoException{
		Usuario usuario = null;
		try{
			if(!"".equals(email)) {
				usuario = usuarioRepository.findByEmail(email);
				if(usuario != null) {
					throw new ValidacaoException(MensagemErro.EMAIL_JA_CADASTRADO); 
				}else {
					if(!"".equals(confirmacaoEmail)) {
						if(!confirmacaoEmail.equals(email)) {
							throw new ValidacaoException(MensagemErro.CONFIRMACAO_DE_EMAIL_INVALIDA);
						}
					}else {
						throw new ValidacaoException(MensagemErro.CONFIRMACAO_DE_EMAIL_NAO_INFORMADA);
					}
				}
			}else {
				throw new ValidacaoException(MensagemErro.EMAIL_NAO_INFORMADO);
			}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void validaSenha(String senha, String confirmaSenha) throws ValidacaoException {
		try {
			if(!"".equals(senha)) {
				if(senha.length() <= 5 && senha.length() >= 13) {
					throw new ValidacaoException(MensagemErro.TAMANHO_DE_SENHA_INVALIDO);
				}
				if(!confirmaSenha.equals(senha)) {
					throw new ValidacaoException(MensagemErro.ERRO_CONFIRMA_SENHA);
				}
			}else{
				throw new ValidacaoException(MensagemErro.SENHA_NAO_INFORMADA);
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void validaDocumento(TipoDocumento tipoDocumento, String documento) throws ValidacaoException {
		try {
			if(tipoDocumento.getValor() != 1 || tipoDocumento.getValor() != 2) {
				throw new ValidacaoException(MensagemErro.TIPO_DOCUMENTO_INVALIDO);
			}
			
			if(1 == tipoDocumento.getValor()) {
				if(!"".equals(documento) || (documento.length() > 11 || documento.length() < 9)) {
					throw new ValidacaoException(MensagemErro.CPF_INVALIDO);
				}
			}else {
				if(documento.length() < 14) {
					throw new ValidacaoException(MensagemErro.CNPJ_INVALIDO);
				}
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void validaTermoServico(Boolean termoServico) throws ValidacaoException {
		if(!termoServico) {
			throw new ValidacaoException(MensagemErro.TERMO_SERVICO_NAO_ASSINADO);
		}
	}
	
	public Long geraChave() {
		Random gerador = new Random();
	    long nextLong = gerador.nextLong();
	    return nextLong;
	}
	
	public void validaUsuario(Long id) throws ValidacaoException {
		try {
			Usuario usuario = usuarioRepository.findById(id);
			if(usuario == null) {
				throw new ValidacaoException(MensagemErro.ERRO_USUARIO_INEXISTENTE);
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void validaEscolaridade(Escolaridade escolaridade) throws ValidacaoException {
		try {
			if(escolaridade.getValor() > 10 && escolaridade.getValor() < 1) {
			throw new ValidacaoException(MensagemErro.ESCOLARIDADE_INVALIDA);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
