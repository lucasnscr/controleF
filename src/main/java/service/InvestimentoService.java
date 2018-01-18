package service;

import java.util.List;

import dto.InvestimentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface InvestimentoService {

	Long incluir(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException;

	InvestimentoDTO alterar(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException;

	InvestimentoDTO inativar(Long id) throws ServicoException, ValidacaoException;

	List<InvestimentoDTO> listarInvestimentoUsuario(Long idUsuario) throws ServicoException, ValidacaoException;

	InvestimentoDTO detalharInvestimento(Long id) throws ServicoException, ValidacaoException;

	InvestimentoDTO simularInvestimento(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException;

}
