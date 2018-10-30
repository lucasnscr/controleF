package resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.EnderecoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="ControleF - Endereço")
@RestController
@RequestMapping("/endereco")
public interface EnderecoResource {
	
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message="Ok"),
				@ApiResponse(code = 400, message="Bad Request"),
				@ApiResponse(code = 404, message="Not Found"),
				@ApiResponse(code = 500, message="Internal Server Error")
		})
		 
	@ApiOperation(value = "Serviço que realiza cadastro de endereço")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    EnderecoDTO insert(@RequestParam("enderecoDTO") EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "erviço que realiza alteração de endereço")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    EnderecoDTO alterar (@RequestParam("enderecoDTO") EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException; 

	@ApiOperation(value = "erviço que inativa endereço")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    EnderecoDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que lista endereços de um usuário")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/listaEndereco/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    List<EnderecoDTO> listarEnderecoUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException;
    
	@ApiOperation(value = "Serviço que realiza busca do endereço por id")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/detalheEndereco/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    EnderecoDTO detalharEndereco(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
    
}
