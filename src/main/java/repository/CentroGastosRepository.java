package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.CentroGastos;

public interface CentroGastosRepository extends JpaRepository<CentroGastos, Long> {
	
	CentroGastos findById(Long id);
	
	CentroGastos findByIdUsuario(Long idUsuario);

}
