package entity;

import java.io.Serializable;
import java.util.Date;

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
@SequenceGenerator(name = "GASTOS_SEQ", sequenceName = "GASTOS_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="centro_gastos")
public class CentroGastos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GASTOS_SEQ")
	private Long id;
	
	@Column(name= "id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name= "id_fluxo_caixa", nullable = false)
	private FluxoCaixa fluxoCaixa;
	
	@Column(nullable = false)
	private Double recebimento;
	
	@Column(nullable = false)
	private Double pagamento;
	
	@Column(nullable = false)
	private Double saldo;
	
	@Column(nullable = false)
	private Date periodo;
	

}
