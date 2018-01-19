package serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import entity.Lancamento;
import enums.TipoLancamento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.LancamentoRepository;
import service.LancamentoService;
import validacoes.ValidacoesImpl;

public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ValidacoesImpl validacao;

	@Override
	public Long incluir(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.validaLancamento(lancamentoDTO);
			Lancamento lancamento = new Lancamento();
			BeanUtils.copyProperties(lancamentoDTO, lancamento);
			if (lancamentoDTO.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
				String valor = lancamentoDTO.getTipoRecebimento().getValor();
				switch (valor) {
				case "Salário":

					break;

				case "Investimento":

					break;

				case "Freelancer":

					break;
					
				case "Herança":

					break;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

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
