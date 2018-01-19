package dto;

import java.io.Serializable;

import enums.TipoGastos;
import enums.TipoRecebimento;

public class FluxoCaixaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Double pagamento;
	
	private TipoGastos tipoGasto;
	
	private TipoRecebimento tipoRecebimento;
	
	private Double recebimento;
	
	private Double saldoAnual;
	
	private Integer ano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPagamento() {
		return pagamento;
	}

	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}

	public TipoGastos getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGastos tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public TipoRecebimento getTipoRecebimento() {
		return tipoRecebimento;
	}

	public void setTipoRecebimento(TipoRecebimento tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}

	public Double getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Double recebimento) {
		this.recebimento = recebimento;
	}

	public Double getSaldoAnual() {
		return saldoAnual;
	}

	public void setSaldoAnual(Double saldoAnual) {
		this.saldoAnual = saldoAnual;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
