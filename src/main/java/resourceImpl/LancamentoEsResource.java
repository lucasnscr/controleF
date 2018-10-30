package resourceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dto.LancamentoESDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.LancamentoESService;

public class LancamentoEsResource implements resource.LancamentoEsResource {

	@Autowired
	private LancamentoESService lancamentoESService;

	public Long incluir(LancamentoESDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		Long id = lancamentoESService.incluir(lancamentoDTO);
		return id;
	}

	public Boolean inativar(Long id) throws ServicoException, ValidacaoException {
		Boolean excluir = lancamentoESService.excluir(id);
		return excluir;
	}

	public LancamentoESDTO detalharLancamento(Long id) throws ServicoException, ValidacaoException {
		LancamentoESDTO lancDTO = lancamentoESService.buscaPorId(id);
		return lancDTO;
	}

	public List<LancamentoESDTO> listar(Long id) throws ServicoException, ValidacaoException {
		List<LancamentoESDTO> lancDTOList = lancamentoESService.buscarTodos();
		return lancDTOList;
	}
}
