package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SequenceGenerator(name = "FLUXO_SEQ", sequenceName = "FLUXO_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="fluxo_caixa")
public class FluxoCaixa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLUXO_SEQ")
	private Long id;
	
	@Column(name="saldo_mensal", nullable=false)
	private Double saldoMensal;
	
	@Column(nullable=false)
	private Double recebimento;
	
	@Column(nullable=false)
	private Double pagamento;
	
	@Column(nullable=false)
	private Double resultado;
	
	@Column(nullable=false)
	private Double saldoAnual;
	
	@Column(nullable=false)
	private Integer ano;

}
