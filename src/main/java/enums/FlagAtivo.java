package enums;

public enum FlagAtivo {

    ATIVO(1),
    INATIVO(0);

    public int valor;

    FlagAtivo(int valor) {
        this.valor = valor;
    }

	public int getValor() {
		return valor;
	}
}