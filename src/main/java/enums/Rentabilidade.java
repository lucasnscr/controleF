package enums;

public enum Rentabilidade {
	
	TESOURO_DIRETO(1.53, true),
	CDB(1.00, true),
	POUPANCA(0.64, false),
	BOLSA_DE_VALORES(3.14, true);
	
	private Double valor;
	private Boolean taxas;
	
	Rentabilidade(Double valor, Boolean taxas) {
		this.valor = valor;
		this.taxas = taxas;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getTaxas() {
		return taxas;
	}

}
