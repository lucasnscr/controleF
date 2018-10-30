package resourceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dto.MetaDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.MetaService;

public class MetaResource implements resource.MetaResource{

	@Autowired
	private MetaService metaService;
	
	public MetaDTO incluir(MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.incluir(metaDTO);
		return meta;
	}
	
	public MetaDTO alterar(MetaDTO metaDTO) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.alterar(metaDTO);
		return meta;
	}
	
	public MetaDTO inativar(Long id) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.inativar(id);
		return meta;
	}
	
	public List<MetaDTO> pesquisarMeta(Long idUsuario) throws ValidacaoException, ServicoException {
		List<MetaDTO> metas = metaService.pesquisarMeta(idUsuario);
		return metas;
	}
	
	public MetaDTO detalheMeta(Long id) throws ValidacaoException, ServicoException {
		MetaDTO meta = metaService.detalheMeta(id);
		return meta;
	}
	
}
