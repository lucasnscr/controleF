package dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;

public class LancamentoESDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message="Lançamento está vinculado a um centro de gasto")
	private CentroGastosDTO centroGastosDTO;
	
	@NotNull(message="Informe o id do usuário")
	private Long idUsuario;
	
	@NotNull(message="Informe um tipo de lançamento")
	private TipoLancamento TipoLancamento;
	
	private TipoGastos tipoGastos;
	
	private TipoRecebimento TipoRecebimento;

	@NotNull(message="Informe um valor")
	private Double valor;
	
	private Date cadastro;
	
	private Date atualizacao;
	
	@Size(max=100, message="Informe uma descricao menor")
	private String descricao;
	
	private FlagAtivo ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CentroGastosDTO getCentroGastosDTO() {
		return centroGastosDTO;
	}

	public void setCentroGastosDTO(CentroGastosDTO centroGastosDTO) {
		this.centroGastosDTO = centroGastosDTO;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoLancamento getTipoLancamento() {
		return TipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		TipoLancamento = tipoLancamento;
	}

	public TipoGastos getTipoGastos() {
		return tipoGastos;
	}

	public void setTipoGastos(TipoGastos tipoGastos) {
		this.tipoGastos = tipoGastos;
	}

	public TipoRecebimento getTipoRecebimento() {
		return TipoRecebimento;
	}

	public void setTipoRecebimento(TipoRecebimento tipoRecebimento) {
		TipoRecebimento = tipoRecebimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}
	
}
