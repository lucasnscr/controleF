package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable=false)
	private Long idUsuario;
	
	@Column(nullable=false)
	private String logradouro;
	
	@Column(nullable=false)
	private String bairro;
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String estado;
	
	@Column(nullable=false)
	private String pais;
	
	@Column(nullable=false)
	private Integer ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

}
