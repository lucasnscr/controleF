package resource;

import org.springframework.beans.factory.annotation.Autowired;
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
import service.UsuarioService;

@Api
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	    @RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	    public CadastroUsuarioDTO insert(@RequestParam("cadUsauarioDTO") CadastroUsuarioDTO cadUsuarioDTO)  throws ValidacaoException, ServicoException {
	    	CadastroUsuarioDTO cadastroUsauarioDTO = usuarioService.incluir(cadUsuarioDTO);
	        return cadastroUsauarioDTO;
	    }

	    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	    public AlteraDadosUsuarioDTO alterar (@RequestParam("alteraDadosUsuarioDTO") AlteraDadosUsuarioDTO alteraDadosUsuarioDTO)  throws ValidacaoException, ServicoException {
	    	AlteraDadosUsuarioDTO alteraUsuarioDTO = usuarioService.alterar(alteraDadosUsuarioDTO);
	        return alteraUsuarioDTO;
	    }

	    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	    public GerenciarUsuarioDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.inativar(id);
	    	return gereUsuarioDTO;
	    }
	    
	    @RequestMapping(value="/alteraEmail", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	    public GerenciarUsuarioDTO alteraEmail(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.alteraEmail(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
	    }
	    
	    @RequestMapping(value="/alteraSenha", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	    public GerenciarUsuarioDTO alteraSenha(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.alteraSenha(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
	    }

		@RequestMapping(value="/gerenciarUsuarioFeign", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	    public GerenciarUsuarioDTO gerenciaDadosUsuarioFeign(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO) throws  ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.gerenciarUsuarioFeign(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
		}
	
}
