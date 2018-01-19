package enums;

public enum TipoRecebimento {
	
	SALARIO("Salário"),
	INVESTIMENTO("Investimento"),
	FREELANCER("Freelancer"),
	HERANCA("Herança");
	
	private String valor;
	
	private TipoRecebimento(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
