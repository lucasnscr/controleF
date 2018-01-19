package enums;

public enum TipoLancamento {

	CREDITO("C"), DEBITO("D");

	public String valor;

	TipoLancamento(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
}
