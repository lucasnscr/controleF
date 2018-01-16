package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Meta;

public interface MetaRepository extends JpaRepository<Meta, Long> {
	
	Meta findById(Long id);
	List<Meta> findByIdUsuario(Long idUsuario);

}
