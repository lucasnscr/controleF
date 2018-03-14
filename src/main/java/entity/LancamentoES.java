package entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "lancamentoES", type = "lancamentos")
public class LancamentoES implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Long idCentroGastos;
	private String tipoLancamento;
	private Double valor;
	private String descricao;
	private Date cadastro;
	private Date atualizacao;
	private String tipoGasto;
	private String tipoRecebimento;
	private Integer ativo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCentroGastos() {
		return idCentroGastos;
	}
	public void setIdCentroGastos(Long idCentroGastos) {
		this.idCentroGastos = idCentroGastos;
	}
	public String getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	public Date getAtualizacao() {
		return atualizacao;
	}
	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public String getTipoRecebimento() {
		return tipoRecebimento;
	}
	public void setTipoRecebimento(String tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public String toString() {
		return "LancamentoES" +
				"id='" + id + '\'' +
				", valor='" + valor + '\'' +
				" tipoGasto='" + tipoGasto + '\'' +
				'}';
	}

}
