package service;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface LancamentoService {

	Long incluir(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException;

	LancamentoDTO alterar(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException;

	LancamentoDTO inativar(Long id) throws ServicoException, ValidacaoException;

	LancamentoDTO detalharLancamento(Long id) throws ServicoException, ValidacaoException;

	AnaliseLancamentoDTO analiseLancamento(AnaliseLancamentoDTO analiseLancamentoDTO) throws ServicoException, ValidacaoException;
	
}
