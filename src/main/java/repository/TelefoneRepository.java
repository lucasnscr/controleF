package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	Telefone findByIdAndAtivo(Long id, Integer ativo);
	
	Telefone findById(Long id);
	
	List<Telefone> findByIdUsuario(Long idUsuario);

}
