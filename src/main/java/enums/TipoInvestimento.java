package enums;

public enum TipoInvestimento {
	
	POUPANCA(1),
	RENDA_FIXA(2);
	
	private Integer valor;
	
	private TipoInvestimento(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
}
