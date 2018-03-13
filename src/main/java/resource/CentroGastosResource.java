package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.AnaliseCentroGastosDTO;
import dto.CentroGastosDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import service.CentroGastosService;

@Api
@RestController
@RequestMapping("/centroGastos")
public class CentroGastosResource {
	
	@Autowired
	private CentroGastosService centroGastosService;
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CentroGastosDTO pesquisarCentroGastosUsuario(@PathVariable("idUsuario") Long idUsuario) throws ValidacaoException, ServicoException{
		
		CentroGastosDTO centroGastosDTO =  centroGastosService.pesquisarCentroGastosUsuario(idUsuario);
		return centroGastosDTO;
	}
	
	@RequestMapping(value = "/analise/{idCentroGastos}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnaliseCentroGastosDTO analiseCentroGastos(@PathVariable("idCentroGastos")Long idCentroGastos) throws ValidacaoException, ServicoException{
		AnaliseCentroGastosDTO analiseCentroGastos = centroGastosService.analiseCentroGastos(idCentroGastos);
		return analiseCentroGastos;
	}

}
