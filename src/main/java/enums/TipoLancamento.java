package enums;

import lombok.Getter;

public enum TipoLancamento {

	CREDITO("C"), DEBITO("D");

	@Getter
	public String valor;

	TipoLancamento(String valor) {
		this.valor = valor;
	}
}
