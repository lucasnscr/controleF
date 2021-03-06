package enums;

public enum TipoGastos {
	
	MORADIA("Moradia"),
	BARES_RESTAURANTES("Bares e Restaurantes"),
	MERCADO("Mercado"),
	LAZER("Lazer"),
	COMPRAS("Compras"),
	OUTROS("Outros");
	
	private String valor;
	
	private TipoGastos(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
