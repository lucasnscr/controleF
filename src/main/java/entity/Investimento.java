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
@SequenceGenerator(name = "INVESTIMENTO_SEQ", sequenceName = "INVESTIMENTO_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="investimento")
public class Investimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVESTIMENTO_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable= false)
	private Usuario usuario;
	
	@Column(nullable= false)
	private Double valor;
	
	@Column(nullable= false)
	private String tipoInvestimento;

	@Column(nullable= false)
	private Integer ativo;
	
}
