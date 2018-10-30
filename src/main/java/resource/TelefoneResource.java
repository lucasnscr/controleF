package resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.TelefoneDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value= "")
@RestController
@RequestMapping("/telefone")
public interface TelefoneResource {

	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	
	@ApiOperation(value = "Serviço que insere um telefone")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO insert(@RequestParam("telefoneDTO") TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que altera um telefone")
	@ApiResponse(code= 200, message="update realizado com sucesso")
    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO alterar (@RequestParam("telefoneDTO") TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que inativa um telefone")
	@ApiResponse(code= 200, message="inativacao realizado com sucesso")
    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que lista telefones de um usuario")
	@ApiResponse(code= 200, message="pesquisa realizado com sucesso")
    @RequestMapping(value="/listaTelefone/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<TelefoneDTO> listarTelefoneUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException;
    
	@ApiOperation(value = "Serviço que detalhe telefone")
	@ApiResponse(code= 200, message="pesquisa realizado com sucesso")
    @RequestMapping(value="/detalheTelefone/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO detalharTelefone(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
	
}
