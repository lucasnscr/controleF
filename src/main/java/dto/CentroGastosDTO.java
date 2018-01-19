package dto;

import java.io.Serializable;
import java.util.Date;

import entity.Usuario;

public class CentroGastosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Usuario usuario;
	
	private FluxoCaixaDTO fluxoCaixa;
	
	private Double recebimento;
	
	private Double pagamento;
	
	private Double saldo;
	
	private Date mesAno;

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

	public FluxoCaixaDTO getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixaDTO fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
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

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}

}
