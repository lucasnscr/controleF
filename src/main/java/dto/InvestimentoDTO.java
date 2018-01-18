package dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import entity.Usuario;
import enums.FlagAtivo;
import enums.TipoInvestimento;

public class InvestimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message="Informe uma data de resgate do investimento")
	private Usuario usuario;
	
	@NotNull(message="Informe uma valor que deseja investir")
	private Double valor;

	private TipoInvestimento tipoInvestimento;

	private Date inicio;
	
	@NotNull(message="Informe uma data de resgate do investimento")
	private Date fim;

	private FlagAtivo ativo;

	private Double rendaMensal;
	
	private Double investimentoNecessario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoInvestimento getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
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

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Double getInvestimentoNecessario() {
		return investimentoNecessario;
	}

	public void setInvestimentoNecessario(Double investimentoNecessario) {
		this.investimentoNecessario = investimentoNecessario;
	}
	
}
