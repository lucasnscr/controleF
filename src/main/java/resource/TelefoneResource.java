package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.TelefoneDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneResource {

	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO insert(@RequestParam("telefoneDTO") TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException {
		TelefoneDTO endDTO = telefoneService.incluir(telefoneDTO);
        return endDTO;
    }

    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO alterar (@RequestParam("telefoneDTO") TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException {
    	TelefoneDTO endDTO = telefoneService.alterar(telefoneDTO);
        return endDTO;
    }

    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	TelefoneDTO endDTO = telefoneService.inativar(id);
    	return endDTO;
    }
	
    @RequestMapping(value="/listaTelefone/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<TelefoneDTO> listarTelefoneUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<TelefoneDTO> endDTOList = telefoneService.listarTelefoneUsuario(idUsuario);
    	return endDTOList;
    }
    
    @RequestMapping(value="/detalheTelefone/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public TelefoneDTO detalharTelefone(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	TelefoneDTO endDTO = telefoneService.detalharTelefone(id);
    	return endDTO;
    }
	
}
