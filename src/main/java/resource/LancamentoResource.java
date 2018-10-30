package resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value= "ControleF - lancamentos de entradas e saidas")
@RestController
@RequestMapping("/lancamento")
public interface LancamentoResource {

	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	
	@ApiOperation(value = "Serviço que insere um lancamento")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long incluir(@RequestParam("lancamentoDTO") LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que altera um lancamento")
	@ApiResponse(code= 200, message="update realizado com sucesso")
	@RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO alterar(@RequestParam("lancamentoDTO") LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que inativa um lancamento")
	@ApiResponse(code= 200, message="inativacao realizado com sucesso")
	@RequestMapping(value = "/inativar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO inativar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que pesquisa um lancamento")
	@ApiResponse(code= 200, message="busca realizado com sucesso")
	@RequestMapping(value = "/detalheLancamento/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO detalharLancamento(@PathVariable("id") Long id) throws ServicoException, ValidacaoException;

	@ApiOperation(value = "Serviço que analisa seus lancamentos um lancamento")
	@ApiResponse(code= 200, message="analise realizado com sucesso")
	@RequestMapping(value = "/analiseLancamento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnaliseLancamentoDTO analiseLancamento(
			@RequestParam("analiseLancamentoDTO") AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException;
}
