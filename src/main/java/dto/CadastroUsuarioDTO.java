package dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import enums.TipoDocumento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CadastroUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Size(min=6, max= 50, message="Usuário deve conter até 50 caracteres")
	@NotNull(message="Informe um usuário")
	private String login;
	
	@NotNull(message="Informe o email para cadastro")
	private String  email;
	
	@NotNull(message="Informe a confirmação de email")
	private String  emailConfirmacao;
	
	@Size(min=6, max= 12, message="Senha deve conter até 12 caracteres")
	@NotNull(message="Informe uma senha")
	private String senha;
	
	@Size(min=6, max= 12, message="Senha deve conter até 12 caracteres")
	@NotNull(message="Informe a confirmação da senha")
	private String confirmaSenha;
	
	@NotNull(message="Informe o tipo de documento")
	private TipoDocumento tipoDocumento;
	
	@NotNull(message="Informe o documento")
	private String documento;
	
	@NotNull(message="Aceita os termos de serviço")
	private Boolean termoServico;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailConfirmacao() {
		return emailConfirmacao;
	}

	public void setEmailConfirmacao(String emailConfirmacao) {
		this.emailConfirmacao = emailConfirmacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Boolean getTermoServico() {
		return termoServico;
	}

	public void setTermoServico(Boolean termoServico) {
		this.termoServico = termoServico;
	}
	
}
