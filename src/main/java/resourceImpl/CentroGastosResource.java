package resourceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import dto.AnaliseCentroGastosDTO;
import dto.CentroGastosDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.CentroGastosService;

public class CentroGastosResource implements resource.CentroGastosResource{
	
	@Autowired
	private CentroGastosService centroGastosService;
	
	public CentroGastosDTO pesquisarCentroGastosUsuario(Long idUsuario) throws ValidacaoException, ServicoException{
		
		CentroGastosDTO centroGastosDTO =  centroGastosService.pesquisarCentroGastosUsuario(idUsuario);
		return centroGastosDTO;
	}
	
	public AnaliseCentroGastosDTO analiseCentroGastos(Long idCentroGastos) throws ValidacaoException, ServicoException{
		AnaliseCentroGastosDTO analiseCentroGastos = centroGastosService.analiseCentroGastos(idCentroGastos);
		return analiseCentroGastos;
	}

}
