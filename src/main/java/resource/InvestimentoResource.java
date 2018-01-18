package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.InvestimentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import service.InvestimentoService;

@Api
@RestController
@RequestMapping("/investimento")
public class InvestimentoResource {
	
	@Autowired
	private InvestimentoService investimentoService;
	
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Long insert(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException {
		Long id  = investimentoService.incluir(investimentoDTO);
        return id;
    }

    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO alterar (@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException {
    	InvestimentoDTO invDTO = investimentoService.alterar(investimentoDTO);
        return invDTO;
    }

    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	InvestimentoDTO investimentoDTO = investimentoService.inativar(id);
    	return investimentoDTO;
    }
	
    @RequestMapping(value="/listaInvestimento/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<InvestimentoDTO> listarInvestimentoUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<InvestimentoDTO> invDTOList = investimentoService.listarInvestimentoUsuario(idUsuario);
    	return invDTOList ;
    }
    
    @RequestMapping(value="/detalheInvestimento/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO detalharInvestimento(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	InvestimentoDTO invDTO = investimentoService.detalharInvestimento(id);
    	return invDTO;
    }
    
    @RequestMapping(value="/simularInvestimento", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO simularInvestimento(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO) throws ValidacaoException, ServicoException{
    	InvestimentoDTO invDTO = investimentoService.simularInvestimento(investimentoDTO);
    	return invDTO;
    }


}
