package resourceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dto.InvestimentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.InvestimentoService;

public class InvestimentoResource implements resource.InvestimentoResource {
	
	@Autowired
	private InvestimentoService investimentoService;
	
    public Long insert(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException {
		Long id  = investimentoService.incluir(investimentoDTO);
        return id;
    }

    public InvestimentoDTO alterar (@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException {
    	InvestimentoDTO invDTO = investimentoService.alterar(investimentoDTO);
        return invDTO;
    }

    public InvestimentoDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	InvestimentoDTO investimentoDTO = investimentoService.inativar(id);
    	return investimentoDTO;
    }
	
    public List<InvestimentoDTO> listarInvestimentoUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<InvestimentoDTO> invDTOList = investimentoService.listarInvestimentoUsuario(idUsuario);
    	return invDTOList ;
    }
    
    public InvestimentoDTO detalharInvestimento(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
    	InvestimentoDTO invDTO = investimentoService.detalharInvestimento(id);
    	return invDTO;
    }
    
    public InvestimentoDTO simularInvestimento(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO) throws ValidacaoException, ServicoException{
    	InvestimentoDTO invDTO = investimentoService.simularInvestimento(investimentoDTO);
    	return invDTO;
    }


}
