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

@SequenceGenerator(name = "META_SEQ", sequenceName = "META_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="meta")
public class Meta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "META_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(nullable=true)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicial", nullable=false)
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_final", nullable=false)
	private Date dataFinal;
	
	@Column(nullable=false)
	private Double valor;
	
	@Column(nullable=true)
	private Double saldo;
	
	@Column(nullable=false)
	private Double investimentoMensal;
	
	@Column(nullable=false)
	private Integer ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getInvestimentoMensal() {
		return investimentoMensal;
	}

	public void setInvestimentoMensal(Double investimentoMensal) {
		this.investimentoMensal = investimentoMensal;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	
}
