package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Endereco;
import enums.FlagAtivo;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{
	
	Endereco findById(Long id);
	
	Endereco findByIdAndAtivo(Long id, FlagAtivo ativo);
	
	List<Endereco> findByIdUsuarioAndAtivo(Long idUsuario, Integer ativo);

}
