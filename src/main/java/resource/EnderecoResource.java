package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import service.EnderecoService;

@Api
@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO insert(@RequestParam("enderecoDTO") EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException {
		EnderecoDTO endDTO = enderecoService.incluir(enderecoDTO);
        return endDTO;
    }

    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO alterar (@RequestParam("enderecoDTO") EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException {
    	EnderecoDTO endDTO = enderecoService.alterar(enderecoDTO);
        return endDTO;
    }

    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	EnderecoDTO endDTO = enderecoService.inativar(id);
    	return endDTO;
    }
	
    @RequestMapping(value="/listaEndereco/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<EnderecoDTO> listarEnderecoUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<EnderecoDTO> endDTOList = enderecoService.listarEnderecoUsuario(idUsuario);
    	return endDTOList;
    }
    
    @RequestMapping(value="/detalheEndereco/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public EnderecoDTO detalharEndereco(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	EnderecoDTO endDTO = enderecoService.detalharEndereco(id);
    	return endDTO;
    }
}
