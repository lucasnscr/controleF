package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import io.swagger.annotations.Api;
import service.LancamentoService;

@Api
@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Long incluir(@RequestParam("lancamentoDTO") LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		Long id = lancamentoService.incluir(lancamentoDTO);
		return id;
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO alterar(@RequestParam("lancamentoDTO") LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.alterar(lancamentoDTO);
		return lancDTO;
	}

	@RequestMapping(value = "/inativar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO inativar(@PathVariable("id") Long id) throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.inativar(id);
		return lancDTO;
	}

	@RequestMapping(value = "/detalheLancamento/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LancamentoDTO detalharLancamento(@PathVariable("id") Long id) throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.detalharLancamento(id);
		return lancDTO;
	}

	@RequestMapping(value = "/analiseLancamento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnaliseLancamentoDTO analiseLancamento(
			@RequestParam("analiseLancamentoDTO") AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		AnaliseLancamentoDTO analiseLancamento = lancamentoService.analiseLancamento(analiseLancamentoDTO);
		return analiseLancamento;
	}
}
