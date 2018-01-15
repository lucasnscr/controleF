package dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import enums.Escolaridade;
import enums.EstadoCivil;
import enums.TipoDocumento;

public class AlteraDadosUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Informe o id do usuário")
	private Long id;
	
	private TipoDocumento tipoDocumento;
	
	@NotNull(message="Informe o documento do usuário")
	private String documento;
	
	private Date dataNascimento;
	
	private EstadoCivil estadoCivil;
	
	private String sexo;
	
	private String cidade;
	
	private String estado;
	
	private String pais;
	
	private Escolaridade escolaridade;

	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
