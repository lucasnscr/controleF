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
@SequenceGenerator(name = "TELEFONE_SEQ", sequenceName = "TELEFONE_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELEFONE_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable= false)
	private Usuario usuario;
	
	@Column(name="codigo_pais", nullable= false)
	private Long codigoPais;
	
	@Column(nullable= false)
	private Long ddd;
	
	@Column(nullable= false)
	private Long numero;
	
	@Column(nullable= false)
	private Integer ativo;

}
