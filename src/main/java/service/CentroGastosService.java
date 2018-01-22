package service;

import dto.CentroGastosDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface CentroGastosService {

	CentroGastosDTO pesquisarCentroGastosUsuario(Long idUsuario) throws ValidacaoException, ServicoException;

}
