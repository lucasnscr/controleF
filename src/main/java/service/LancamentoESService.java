package service;

import java.util.List;

import dto.LancamentoESDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface LancamentoESService {
	
	Long incluir(LancamentoESDTO lancamentoESDTO) throws ServicoException, ValidacaoException;
	
	Boolean excluir(Long id) throws ServicoException, ValidacaoException;
	
	LancamentoESDTO buscaPorId(Long id) throws ServicoException, ValidacaoException;
	
	List<LancamentoESDTO> buscarTodos() throws ServicoException, ValidacaoException;
	
}
