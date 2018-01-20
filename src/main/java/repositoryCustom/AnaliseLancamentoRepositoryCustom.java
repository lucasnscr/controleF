package repositoryCustom;

import java.util.List;

import dto.AnaliseLancamentoDTO;
import entity.Lancamento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface AnaliseLancamentoRepositoryCustom {

	List<Lancamento> analisarLancamentosFiltro(AnaliseLancamentoDTO analiseLancamentoDTO) throws ServicoException, ValidacaoException;
	
}
