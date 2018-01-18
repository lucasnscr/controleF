package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

	Investimento findByIdAndAtivo(Long id, Integer ativo);

	List<Investimento> findByIdUsuarioAndAtivo(Long idUsuario, Integer ativo);

}
