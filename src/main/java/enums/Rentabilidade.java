package enums;

public enum Rentabilidade {
	
	TESOURO_DIRETO_MES(1.53, "MEDIO-AGRESSIVO", true),
	TESOURO_DIRETO_ANO(20.00, "MEDIO-AGRESSIVO", true),
	CDB_MES(1.00, "CONSERVADOR-MEDIO", true),
	CBM_ANO(12.65, "CONSERVADOR-MEDIO", true),
	POUPANCA_MES(0.64, "CONSERVADOR", false),
	POUPANCA_ANO(8.00, "CONSERVADOR", false ),
	ACAO_MENSAL(3.14, "AGRESSIVO", true),
	ACAO_ANUAL(45.00, "AGRESSIVO", true);
	
	private Double valor;
	private String nome;
	private Boolean taxas;
	
	Rentabilidade(Double valor, String nome, Boolean taxas) {
		this.valor = valor;
		this.nome =  nome;
		this.taxas = taxas;
	}

	public Double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getTaxas() {
		return taxas;
	}

}
