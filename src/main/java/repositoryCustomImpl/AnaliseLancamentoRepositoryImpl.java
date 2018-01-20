package repositoryCustomImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import dto.AnaliseLancamentoDTO;
import entity.Lancamento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repositoryCustom.AnaliseLancamentoRepositoryCustom;

public class AnaliseLancamentoRepositoryImpl  implements AnaliseLancamentoRepositoryCustom{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Lancamento> analisarLancamentosFiltro(AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		return null;
	}

}
