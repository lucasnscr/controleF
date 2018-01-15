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
@SequenceGenerator(name = "META_SEQ", sequenceName = "META_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="meta")
public class Meta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "META_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(nullable=false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicial", nullable=false)
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_final", nullable=false)
	private Date dataFinal;
	
	
	@Column(nullable=false)
	private Double valor;
	
	@Column(nullable=false)
	private Double saldo;
	
	@Column(nullable=false)
	private Double investimentoMensal;
	

}
