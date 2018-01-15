package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SequenceGenerator(name = "LANCAMENTOS_SEQ", sequenceName = "LANCAMENTOS_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="fluxo_caixa")
public class Lancamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANCAMENTOS_SEQ")
	private Long id;
	
	@Column(name="id_centro_gastos", nullable=false)
	private CentroGastos centroGastos;
	
	@Column(name="tipo_lancamento", nullable=false)
	private String tipoLancamento;
	
	@Column(nullable=false)
	private Double valor;
	
	@Column(nullable=true)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date atualizacao;
	
	@Column(nullable=false)
	private Integer ativo;

}
