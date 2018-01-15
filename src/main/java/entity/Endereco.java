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
@SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ", initialValue = 1, allocationSize = 1)
@Entity(name="endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
	private Long id;
	
	@Column(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name="tipo_endereco", nullable=false)
	private String tipoEndereco;
	
	@Column(nullable=false)
	private String logradouro;
	
	@Column(nullable=false)
	private String bairro;
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String uf;
	
	@Column(nullable=false)
	private String pais;
	
	@Column(nullable=false)
	private Long cep;
	
	@Column(nullable=false)
	private Integer ativo;
	
}
