package service;

import dto.AnaliseCentroGastosDTO;
import dto.CentroGastosDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface CentroGastosService {

	CentroGastosDTO pesquisarCentroGastosUsuario(Long idUsuario) throws ValidacaoException, ServicoException;
	AnaliseCentroGastosDTO analiseCentroGastos(Long idCentroGastos) throws ValidacaoException, ServicoException;
}
