package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.discovery.converters.Auto;

import dto.InvestimentoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.InvestimentoRepository;
import service.InvestimentoService;
import validacoes.ValidacoesImpl;

public class InvestimentoServiceImpl implements InvestimentoService {

	@Autowired
	private InvestimentoRepository investimentoRepository;
	
	@Autowired
	private ValidacoesImpl validacao;
	
	@Override
	public Long incluir(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestimentoDTO alterar(InvestimentoDTO investimentoDTO) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestimentoDTO inativar(Long id) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvestimentoDTO> listarInvestimentoUsuario(Long idUsuario) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestimentoDTO detalharInvestimento(Long id) throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestimentoDTO simularInvestimento(InvestimentoDTO investimentoDTO)
			throws ServicoException, ValidacaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
