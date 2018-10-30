package resourceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.LancamentoService;

public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	public Long incluir(LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		Long id = lancamentoService.incluir(lancamentoDTO);
		return id;
	}

	public LancamentoDTO alterar(LancamentoDTO lancamentoDTO)
			throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.alterar(lancamentoDTO);
		return lancDTO;
	}

	public LancamentoDTO inativar(Long id) throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.inativar(id);
		return lancDTO;
	}

	public LancamentoDTO detalharLancamento(Long id) throws ServicoException, ValidacaoException {
		LancamentoDTO lancDTO = lancamentoService.detalharLancamento(id);
		return lancDTO;
	}

	public AnaliseLancamentoDTO analiseLancamento(AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		AnaliseLancamentoDTO analiseLancamento = lancamentoService.analiseLancamento(analiseLancamentoDTO);
		return analiseLancamento;
	}
}
