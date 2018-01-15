package enums;

public enum Escolaridade {
	
	FUNDAMENTAL_INCOMPLETO(1),
	FUNDAMENTAL_COMPLETO(2),
	MEDIO_INCOMPLETO(3),
	MEDIO_COMPLETO(4),
	SUPERIOR_INCOMPLETO(5),
	SUPERIOR_COMPLETO(6),
	POS_GRADUACAO(7),
	MESTRADO(8),
	DOUTORADO(9),
	PHD(10);
	
	private Integer valor;
	
	Escolaridade(Integer valor){
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
}
