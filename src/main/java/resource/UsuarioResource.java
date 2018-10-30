package resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.AlteraDadosUsuarioDTO;
import dto.CadastroUsuarioDTO;
import dto.GerenciarUsuarioDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/usuario")
public interface UsuarioResource {

	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	
	@ApiOperation(value = "Serviço que insere um usuario")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	CadastroUsuarioDTO insert(@RequestParam("cadUsauarioDTO") CadastroUsuarioDTO cadUsuarioDTO)
			throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que altera um usuario")
	@ApiResponse(code= 200, message="update realizado com sucesso")
	@RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	AlteraDadosUsuarioDTO alterar (@RequestParam("alteraDadosUsuarioDTO") AlteraDadosUsuarioDTO alteraDadosUsuarioDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que inativa uma planilha")
	@ApiResponse(code= 200, message="inativacao realizado com sucesso")
	@RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	GerenciarUsuarioDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que altera o email do usuario")
	@ApiResponse(code= 200, message="update realizado com sucesso")
	@RequestMapping(value="/alteraEmail", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	GerenciarUsuarioDTO alteraEmail(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que altera senha do usuario")
	@ApiResponse(code= 200, message="upload realizado com sucesso")
	@RequestMapping(value="/alteraSenha", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	GerenciarUsuarioDTO alteraSenha(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException;

	@ApiOperation(value = "Serviço que gerencia um usuario de outro microservico")
	@ApiResponse(code= 200, message="acao realizado com sucesso")
	@RequestMapping(value="/gerenciarUsuarioFeign", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	GerenciarUsuarioDTO gerenciaDadosUsuarioFeign(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO) throws  ValidacaoException, ServicoException;

}
