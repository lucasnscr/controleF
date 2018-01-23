package repositoryCustom;

import java.time.LocalDate;
import java.util.List;

import dto.AnaliseLancamentoDTO;
import entity.Lancamento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface AnaliseLancamentoRepositoryCustom {

	List<Lancamento> analisarLancamentosFiltro(AnaliseLancamentoDTO analiseLancamentoDTO) throws ServicoException, ValidacaoException;
	List<Lancamento> pesquisaMensal(LocalDate inicio, LocalDate fim) throws ServicoException, ValidacaoException;
	
}
