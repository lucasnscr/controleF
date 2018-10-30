package resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.AnaliseCentroGastosDTO;
import dto.CentroGastosDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="ControleF - Centro de Gastos")
public interface CentroGastosResource {
	
	 @ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	 
	@ApiOperation(value = "Serviço que realiza pesquisa o centro de gastos pelo id do usuario")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	CentroGastosDTO pesquisarCentroGastosUsuario(@PathVariable("idUsuario") Long idUsuario) throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que realiza análise do centro de gastos")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
	@RequestMapping(value = "/analise/{idCentroGastos}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	AnaliseCentroGastosDTO analiseCentroGastos(@PathVariable("idCentroGastos")Long idCentroGastos) throws ValidacaoException, ServicoException;

}
