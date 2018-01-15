package enums;

import lombok.Getter;

public enum EstadoCivil {
	
	SOLTEIRO("SOL"),
	CASADO("CAS"),
	VIUVO("VIU"),
	SEPARADO("SEP"),
	DIVORCIADO("DIV"),
	OUTRO("OUT");
	
	@Getter
	private String valor;
	
	EstadoCivil(String valor){
		this.valor = valor;
	}

}
