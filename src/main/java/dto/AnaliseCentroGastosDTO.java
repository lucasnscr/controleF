package dto;

import java.io.Serializable;

public class AnaliseCentroGastosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double valorMedioReceita;
	
	private Double valorMedioDespesa;
	
	public Double getValorMedioReceita() {
		return valorMedioReceita;
	}

	public void setValorMedioReceita(Double valorMedioReceita) {
		this.valorMedioReceita = valorMedioReceita;
	}

	public Double getValorMedioDespesa() {
		return valorMedioDespesa;
	}

	public void setValorMedioDespesa(Double valorMedioDespesa) {
		this.valorMedioDespesa = valorMedioDespesa;
	}

}
