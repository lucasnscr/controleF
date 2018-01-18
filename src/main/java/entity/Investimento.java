package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(name = "INVESTIMENTO_SEQ", sequenceName = "INVESTIMENTO_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="investimento")
public class Investimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVESTIMENTO_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable= false)
	private Usuario usuario;
	
	@Column(nullable= false)
	private Double valor;
	
	@Column(nullable= false)
	private String tipoInvestimento;

	@Column(nullable= false)
	private Integer ativo;
	
	@Column(nullable= false)
	private Date inincio;
	
	@Column(nullable= false)
	private Date fim;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Date getInincio() {
		return inincio;
	}

	public void setInincio(Date inincio) {
		this.inincio = inincio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
}
