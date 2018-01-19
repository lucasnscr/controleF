package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.LancamentoRepository;
import service.LancamentoService;
import validacoes.ValidacoesImpl;

public class LancamentoServiceImpl implements LancamentoService{
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ValidacoesImpl validacao;
	
	@Override
	public Long incluir(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		
		
		return null;
	}

	@Override
	public LancamentoDTO alterar(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LancamentoDTO inativar(Long id) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LancamentoDTO detalharLancamento(Long id) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnaliseLancamentoDTO analiseLancamento(AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
