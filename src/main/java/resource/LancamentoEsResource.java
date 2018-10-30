package resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.LancamentoESDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "ControleF -  Lancamento BigData")
@RestController
@RequestMapping("/lancamentoEs")
public interface LancamentoEsResource {
	

	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	 
	@ApiOperation(value = "Serviço que insere um investimento no bigdata")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	Long incluir(@RequestParam("lancamentoDTO") LancamentoESDTO lancamentoDTO)
			throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que inativa um investimento no bigdata")
	@ApiResponse(code= 200, message="inativação realizado com sucesso")
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Boolean inativar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException ;
	
	@ApiOperation(value = "Serviço que detalhe um investimento no bigdata")
	@ApiResponse(code= 200, message="busca realizado com sucesso")
	@RequestMapping(value = "/detalheES/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	LancamentoESDTO detalharLancamento(@PathVariable("id") Long id) throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que lista investimentos um investimento no bigdata")
	@ApiResponse(code= 200, message="busca realizado com sucesso")
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<LancamentoESDTO> listar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException;
	
	
}
