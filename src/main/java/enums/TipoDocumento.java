package enums;

public enum TipoDocumento {

	CPF(1), CNPJ(2);

	public int valor;

	TipoDocumento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
