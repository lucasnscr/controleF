package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.LancamentoESDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import service.LancamentoESService;

@Api
@RestController
@RequestMapping("/lancamentoEs")
public class LancamentoEsResource {

	@Autowired
	private LancamentoESService lancamentoESService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long incluir(@RequestParam("lancamentoDTO") LancamentoESDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		Long id = lancamentoESService.incluir(lancamentoDTO);
		return id;
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean inativar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException {
		Boolean excluir = lancamentoESService.excluir(id);
		return excluir;
	}

	@RequestMapping(value = "/detalheES/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoESDTO detalharLancamento(@PathVariable("id") Long id) throws ServicoException, ValidacaoException {
		LancamentoESDTO lancDTO = lancamentoESService.buscaPorId(id);
		return lancDTO;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LancamentoESDTO> listar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException {
		List<LancamentoESDTO> lancDTOList = lancamentoESService.buscarTodos();
		return lancDTOList;
	}
}
