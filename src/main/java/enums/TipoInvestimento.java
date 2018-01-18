package enums;

public enum TipoInvestimento {
	
	CONSERVADOR(4),
	MEDIO(6),
	MEDIO2(8),
	AGRESSIVO(10);
	
	private Integer valor;
	
	private TipoInvestimento(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
}
