package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Lancamento;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;
import repositoryCustom.AnaliseLancamentoRepositoryCustom;

public interface LancamentoRepository  extends JpaRepository<Lancamento, Long>, AnaliseLancamentoRepositoryCustom{
	
	Lancamento findByIdAndAtivo(Long id, Integer ativo);
	
	Lancamento findByTipoGasto(TipoGastos tipoGastos);
	
	List<Lancamento>findByCadastroAndAtivo(Date cadastro, Integer ativo);
	
	List<Lancamento> findByTipoReceita(TipoRecebimento recebimento);
	
	List<Lancamento> findByTipoGastos(TipoGastos gastos);
	
	List<Lancamento> findByTipoLancamento(TipoLancamento tipoLancamento);
	
}
