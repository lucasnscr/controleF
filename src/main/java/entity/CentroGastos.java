package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SequenceGenerator(name = "GASTOS_SEQ", sequenceName = "GASTOS_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="centro_gastos")
public class CentroGastos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GASTOS_SEQ")
	private Long id;
	
	@Column(name= "id_usuario", nullable = false)
	private Long idUsurio;
	
	@Column(nullable = true)
	private Double recebimento;
	
	@Column(nullable = true)
	private Double pagamento;
	
	@Column(nullable = true)
	private Double saldo;
	
	@Column(nullable = false)
	private Date mêsAno;
	
	@Column(nullable = true)
	private List<Lancamento> lancamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsurio() {
		return idUsurio;
	}

	public void setIdUsurio(Long idUsurio) {
		this.idUsurio = idUsurio;
	}

	public Double getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Double recebimento) {
		this.recebimento = recebimento;
	}

	public Double getPagamento() {
		return pagamento;
	}

	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Date getMêsAno() {
		return mêsAno;
	}

	public void setMêsAno(Date mêsAno) {
		this.mêsAno = mêsAno;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
