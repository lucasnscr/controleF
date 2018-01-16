package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.MetaDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.MetaService;

@RestController
@RequestMapping("/meta")
public class MetaResource {

	@Autowired
	private MetaService metaService;
	
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public MetaDTO incluir(@RequestParam("metaDTO") MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.incluir(metaDTO);
		return meta;
	}
	
	@RequestMapping(value="/alterar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public MetaDTO alterar(@RequestParam("metaDTO") MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.alterar(metaDTO);
		return meta;
	}
	
	@RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MetaDTO inativar(@PathVariable("id") Long id) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.inativar(id);
		return meta;
	}
	
	@RequestMapping(value="/pesquisaMeta/{idUsuario}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MetaDTO> pesquisarMeta(@PathVariable("idUsuario")  Long idUsuario) throws ValidacaoException, ServicoException {
		List<MetaDTO> metas = metaService.pesquisarMeta(idUsuario);
		return metas;
	}
	
	@RequestMapping(value="/pesquisaMeta/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MetaDTO detalheMeta(@PathVariable("id") Long id) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.detalheMeta(id);
		return meta;
	}
	
}
