package dto;

import java.io.Serializable;


public class GerenciarUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String emailAtual;
	
	private String emailNovo;
	
	private String confirmaEmailNovo;
	
	private Boolean desativaConta;
	
	private String chave;
	
	private String senhaAtual;
	
	private String senhaNovo;
	
	private String confirmaSenhaNovo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailAtual() {
		return emailAtual;
	}

	public void setEmailAtual(String emailAtual) {
		this.emailAtual = emailAtual;
	}

	public String getEmailNovo() {
		return emailNovo;
	}

	public void setEmailNovo(String emailNovo) {
		this.emailNovo = emailNovo;
	}

	public String getConfirmaEmailNovo() {
		return confirmaEmailNovo;
	}

	public void setConfirmaEmailNovo(String confirmaEmailNovo) {
		this.confirmaEmailNovo = confirmaEmailNovo;
	}

	public Boolean getDesativaConta() {
		return desativaConta;
	}

	public void setDesativaConta(Boolean desativaConta) {
		this.desativaConta = desativaConta;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNovo() {
		return senhaNovo;
	}

	public void setSenhaNovo(String senhaNovo) {
		this.senhaNovo = senhaNovo;
	}

	public String getConfirmaSenhaNovo() {
		return confirmaSenhaNovo;
	}

	public void setConfirmaSenhaNovo(String confirmaSenhaNovo) {
		this.confirmaSenhaNovo = confirmaSenhaNovo;
	}
	
}
