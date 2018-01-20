package dto;

import java.io.Serializable;
import java.util.Date;

import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;

public class AnaliseLancamentoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double valorInicial;
	
	private Double valorFinal;
	
	private Date inicio;
	
	private Date fim;
	
	private FlagAtivo ativo;
	
	private TipoLancamento tipoLancamento;
	
	private TipoGastos tipoGastos;
	
	private TipoRecebimento tipoRecebimento;
	
	private Double valoresGastos;
	
	private Double valoresRecebidos;

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

	public Double getValoresRecebidos() {
		return valoresRecebidos;
	}

	public void setValoresRecebidos(Double valoresRecebidos) {
		this.valoresRecebidos = valoresRecebidos;
	}
	
}
