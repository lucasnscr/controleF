package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SequenceGenerator(name = "LANCAMENTOS_SEQ", sequenceName = "LANCAMENTOS_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANCAMENTOS_SEQ")
	private Long id;
	
	@Column(name="id_centro_gastos", nullable=false)
	private CentroGastos centroGastos;
	
	@Column(name="tipo_lancamento", nullable=false)
	private String tipoLancamento;
	
	@Column(nullable=false)
	private Double valor;
	
	@Column(nullable=true)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date atualizacao;
	
	@Column(nullable=true)
	private String tipoGasto;
	
	@Column(nullable=true)
	private String tipoRecebimento;
	
	@Column(nullable=false)
	private Integer ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CentroGastos getCentroGastos() {
		return centroGastos;
	}

	public void setCentroGastos(CentroGastos centroGastos) {
		this.centroGastos = centroGastos;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public String getTipoRecebimento() {
		return tipoRecebimento;
	}

	public void setTipoRecebimento(String tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
}
