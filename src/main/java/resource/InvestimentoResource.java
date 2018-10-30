package resource;

import java.util.List;

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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "ControleF - Investimentos")
@RestController
@RequestMapping("/investimento")
public interface InvestimentoResource {
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	 
	@ApiOperation(value = "Serviço que insere um investimento")
	@ApiResponse(code= 200, message="insert realizado com sucesso")
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Long insert(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException ;

	@ApiOperation(value = "Serviço que altera um investimento")
	@ApiResponse(code= 200, message="alteração realizada com sucesso")
    @RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO alterar (@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO)  throws ValidacaoException, ServicoException ;

	@ApiOperation(value = "Serviço que inativa um investimeto")
	@ApiResponse(code= 200, message="investimento inativado com sucesso")
    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
	
	@ApiOperation(value = "Serviço que lista os invetimento de um usuario")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/listaInvestimento/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<InvestimentoDTO> listarInvestimentoUsuario(@PathVariable("idUsuario") Long idUsuario)  throws ValidacaoException, ServicoException;
    
	@ApiOperation(value = "Serviço que detalha um investimento especifico")
	@ApiResponse(code= 200, message="pesquisa realizada com sucesso")
    @RequestMapping(value="/detalheInvestimento/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO detalharInvestimento(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException;
    
	@ApiOperation(value = "Serviço que realiza uma projeção do investimento")
	@ApiResponse(code= 200, message="projeção realizada com sucesso")
    @RequestMapping(value="/simularInvestimento", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public InvestimentoDTO simularInvestimento(@RequestParam("investimentoDTO") InvestimentoDTO investimentoDTO) throws ValidacaoException, ServicoException;


}
