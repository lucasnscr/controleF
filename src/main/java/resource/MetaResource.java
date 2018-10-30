package resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.MetaDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="ControleF - Meta")
@RestController
@RequestMapping("/meta")
public interface MetaResource {
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	
	@ApiOperation(value = "Serviço que insere uma meta")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	MetaDTO incluir(@RequestParam("metaDTO") MetaDTO metaDTO) throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que altera uma meta")
	@ApiResponse(code= 200, message="update realizado com sucesso")
	@RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	MetaDTO alterar(@RequestParam("metaDTO") MetaDTO metaDTO) throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que inativa uma meta")
	@ApiResponse(code= 200, message="inativacao realizado com sucesso")
	@RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	MetaDTO inativar(@PathVariable("id") Long id) throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que pequisa metas de um usuario")
	@ApiResponse(code= 200, message="pesquisa realizado com sucesso")
	@RequestMapping(value="/pesquisaMeta/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	List<MetaDTO> pesquisarMeta(@PathVariable("idUsuario")  Long idUsuario) throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que detalha uma meta")
	@ApiResponse(code= 200, message="pesquisa realizado com sucesso")
	@RequestMapping(value="/pesquisaMeta/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	MetaDTO detalheMeta(@PathVariable("id") Long id) throws ValidacaoException, ServicoException;
	
}
