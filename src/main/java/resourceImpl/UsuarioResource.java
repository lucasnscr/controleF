package resourceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import dto.AlteraDadosUsuarioDTO;
import dto.CadastroUsuarioDTO;
import dto.GerenciarUsuarioDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.UsuarioService;

public class UsuarioResource implements resource.UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	    public CadastroUsuarioDTO insert(CadastroUsuarioDTO cadUsuarioDTO)  throws ValidacaoException, ServicoException {
	    	CadastroUsuarioDTO cadastroUsauarioDTO = usuarioService.incluir(cadUsuarioDTO);
	        return cadastroUsauarioDTO;
	    }

	    public AlteraDadosUsuarioDTO alterar (AlteraDadosUsuarioDTO alteraDadosUsuarioDTO)  throws ValidacaoException, ServicoException {
	    	AlteraDadosUsuarioDTO alteraUsuarioDTO = usuarioService.alterar(alteraDadosUsuarioDTO);
	        return alteraUsuarioDTO;
	    }

	    public GerenciarUsuarioDTO inativar(Long id)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.inativar(id);
	    	return gereUsuarioDTO;
	    }
	    
	    public GerenciarUsuarioDTO alteraEmail(GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.alteraEmail(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
	    }
	    
	    public GerenciarUsuarioDTO alteraSenha(GerenciarUsuarioDTO gerenciarUsuarioDTO)  throws ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.alteraSenha(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
	    }

	    public GerenciarUsuarioDTO gerenciaDadosUsuarioFeign(GerenciarUsuarioDTO gerenciarUsuarioDTO) throws  ValidacaoException, ServicoException{
	    	GerenciarUsuarioDTO gereUsuarioDTO = usuarioService.gerenciarUsuarioFeign(gerenciarUsuarioDTO);
	    	return gereUsuarioDTO;
		}
	
}
