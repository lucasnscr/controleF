package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Lancamento;
import repositoryCustom.AnaliseLancamentoRepositoryCustom;

public interface LancamentoRepository  extends JpaRepository<Lancamento, Long>, AnaliseLancamentoRepositoryCustom{
	
	Lancamento findByIdAndAtivo(Long id, Integer ativo);
	
	Lancamento findByTipoGasto(String tipoGastos);
	
	List<Lancamento>findByCadastroAndAtivo(Date cadastro, Integer ativo);
	
	List<Lancamento> findByTipoReceitaAndAtivo(String recebimento, Integer ativo);
	
	List<Lancamento> findByTipoGastosAndAtivo(String gastos, Integer ativo);
	
	List<Lancamento> findByTipoLancamento(String tipoLancamento);
	
}
