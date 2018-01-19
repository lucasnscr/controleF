package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="usuario")
@SequenceGenerator(name = "USU_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_SEQ")
	private Long id;
	
	@Column(nullable=true)
	private String nome; 
	
	@Column(nullable=false)
	private String documento;
	
	@Column(name="rendiment_mensal", nullable=false)
	private Double rendimentoMensal;
	
	@Column(nullable=false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "data_nascimento", nullable=true)
	private Date dataNascimento;
	
	@Column(nullable=true)
	private String sexo;
	
	@Column(nullable=true)
	private String estado;
	 
	@Column(nullable=true)
	private String cidade;
	
	@Column(nullable=true)
	private String pais;
	
	@Column(nullable=true)
	private Integer escolaridade;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private LocalDate cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private LocalDate atualizacao;
	
	@Column(nullable=false)
	private Integer ativo;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private Long chave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public LocalDate getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}

	public LocalDate getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(LocalDate atualizacao) {
		this.atualizacao = atualizacao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}

}
