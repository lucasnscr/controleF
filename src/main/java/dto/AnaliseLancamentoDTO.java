package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;

public class AnaliseLancamentoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Analise Gastos
	 */
	
	private List<TipoGastos> tiposGastosList;
	private List<TipoRecebimento> tipoRecebimentoList;
	
	/**
	 * PESQUISA
	 */

	private Double valorInicial;
	
	private Double valorFinal;
	
	private Date inicio;
	
	private Date fim;
	
	private FlagAtivo ativo;
	
	private TipoLancamento tipoLancamento;
	
	private TipoGastos tipoGastos;
	
	private TipoRecebimento tipoRecebimento;
	
	/**
	 * RESULTADO
	 */
	
	private Double valoresGastos;
	
	private Double valoresGastoMoradia;

	private Double valoresGastoBarRestaurante;
	
	private Double valoresGastoMercado;

	private Double valoresGastoLazer;
	
	private Double valoresGastoOutros;
	
	private Double valoresGastoCompras;
	
	private Double valoresRecebidos;

	private Double valoresRecebidosSalario;
	
	private Double valoresRecebidosInvestimento;
	
	private Double valoresRecebidosHeranca;
	
	private Double valoresRecebidosFreelancer;

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public TipoGastos getTipoGastos() {
		return tipoGastos;
	}

	public void setTipoGastos(TipoGastos tipoGastos) {
		this.tipoGastos = tipoGastos;
	}

	public TipoRecebimento getTipoRecebimento() {
		return tipoRecebimento;
	}

	public void setTipoRecebimento(TipoRecebimento tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}

	public Double getValoresGastos() {
		return valoresGastos;
	}

	public void setValoresGastos(Double valoresGastos) {
		this.valoresGastos = valoresGastos;
	}

	public Double getValoresGastoMoradia() {
		return valoresGastoMoradia;
	}

	public void setValoresGastoMoradia(Double valoresGastoMoradia) {
		this.valoresGastoMoradia = valoresGastoMoradia;
	}

	public Double getValoresGastoBarRestaurante() {
		return valoresGastoBarRestaurante;
	}

	public void setValoresGastoBarRestaurante(Double valoresGastoBarRestaurante) {
		this.valoresGastoBarRestaurante = valoresGastoBarRestaurante;
	}

	public Double getValoresGastoMercado() {
		return valoresGastoMercado;
	}

	public void setValoresGastoMercado(Double valoresGastoMercado) {
		this.valoresGastoMercado = valoresGastoMercado;
	}

	public Double getValoresGastoLazer() {
		return valoresGastoLazer;
	}

	public void setValoresGastoLazer(Double valoresGastoLazer) {
		this.valoresGastoLazer = valoresGastoLazer;
	}

	public Double getValoresGastoOutros() {
		return valoresGastoOutros;
	}

	public void setValoresGastoOutros(Double valoresGastoOutros) {
		this.valoresGastoOutros = valoresGastoOutros;
	}

	public Double getValoresGastoCompras() {
		return valoresGastoCompras;
	}

	public void setValoresGastoCompras(Double valoresGastoCompras) {
		this.valoresGastoCompras = valoresGastoCompras;
	}

	public Double getValoresRecebidos() {
		return valoresRecebidos;
	}

	public void setValoresRecebidos(Double valoresRecebidos) {
		this.valoresRecebidos = valoresRecebidos;
	}

	public Double getValoresRecebidosSalario() {
		return valoresRecebidosSalario;
	}

	public void setValoresRecebidosSalario(Double valoresRecebidosSalario) {
		this.valoresRecebidosSalario = valoresRecebidosSalario;
	}

	public Double getValoresRecebidosInvestimento() {
		return valoresRecebidosInvestimento;
	}

	public void setValoresRecebidosInvestimento(Double valoresRecebidosInvestimento) {
		this.valoresRecebidosInvestimento = valoresRecebidosInvestimento;
	}

	public Double getValoresRecebidosHeranca() {
		return valoresRecebidosHeranca;
	}

	public void setValoresRecebidosHeranca(Double valoresRecebidosHeranca) {
		this.valoresRecebidosHeranca = valoresRecebidosHeranca;
	}

	public Double getValoresRecebidosFreelancer() {
		return valoresRecebidosFreelancer;
	}

	public void setValoresRecebidosFreelancer(Double valoresRecebidosFreelancer) {
		this.valoresRecebidosFreelancer = valoresRecebidosFreelancer;
	}

	public List<TipoGastos> getTiposGastosList() {
		return tiposGastosList;
	}

	public void setTiposGastosList(List<TipoGastos> tiposGastosList) {
		this.tiposGastosList = tiposGastosList;
	}

	public List<TipoRecebimento> getTipoRecebimentoList() {
		return tipoRecebimentoList;
	}

	public void setTipoRecebimentoList(List<TipoRecebimento> tipoRecebimentoList) {
		this.tipoRecebimentoList = tipoRecebimentoList;
	}

}
