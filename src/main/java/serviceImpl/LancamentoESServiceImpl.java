package serviceImpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import Constantes.MensagemErro;
import dto.LancamentoESDTO;
import entity.CentroGastos;
import entity.LancamentoES;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import repository.LancamentoESRepository;
import service.LancamentoESService;

public class LancamentoESServiceImpl implements LancamentoESService {

	@Autowired
	private LancamentoESRepository lancamentoESRepository;

	@Autowired
	private CentroGastosRepository centroGastosRepository;

	@Override
	public Long incluir(LancamentoESDTO lancamentoESDTO) throws ServicoException, ValidacaoException {

		try {
			Long id = lancamentoESDTO.getId();

			CentroGastos centroGastos = centroGastosRepository.findById(lancamentoESDTO.getCentroGastosDTO().getId());
			if (centroGastos == null) {
				throw new ValidacaoException(MensagemErro.CENTRO_GASTOS_INVALIDO);
			}

			if (id != null) {
				LancamentoESDTO lancDTO = new LancamentoESDTO();
				LancamentoES lancamento = new LancamentoES();
				lancamento.setId(id);
				lancamento.setValor(lancamentoESDTO.getValor());
				lancamento.setTipoRecebimento(lancamentoESDTO.getTipoRecebimento().getValor());
				lancamento.setTipoLancamento(lancamentoESDTO.getTipoLancamento().getValor());
				lancamento.setTipoGasto(lancamentoESDTO.getTipoGastos().getValor());
				lancamento.setIdCentroGastos(centroGastos.getId());
				lancamento.setDescricao(lancamentoESDTO.getDescricao());
				lancamento.setCadastro(Date.from(Instant.now()));
				lancamento.setAtualizacao(Date.from(Instant.now()));
				lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
				LancamentoES elastic = lancamentoESRepository.save(lancamento);
				if (elastic == null) {
					throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.LANCAMENTO));
				} else {
					BeanUtils.copyProperties(elastic, lancDTO);
				}
				return lancDTO.getId();
			} else {
				throw new ValidacaoException(MensagemErro.LANCAMENTO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public Boolean excluir(Long id) throws ServicoException, ValidacaoException {
		try {
			LancamentoES lancamentoES = lancamentoESRepository.findById(id);
			if (lancamentoES != null) {
				lancamentoESRepository.delete(lancamentoES);
				return true;
			} else {
				throw new ServicoException(MensagemErro.ERRO_INATIVAR.concat(MensagemErro.LANCAMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public LancamentoESDTO buscaPorId(Long id) throws ServicoException, ValidacaoException {
		try {
			LancamentoES lancamentoES = lancamentoESRepository.findById(id);
			LancamentoESDTO lancDTO = null;
			if (lancamentoES != null) {
				BeanUtils.copyProperties(lancamentoES, lancDTO);
			}
			return lancDTO;
		} catch (Exception e) {
			e.getMessage();
		}

		return null;

	}

	@Override
	public List<LancamentoESDTO> buscarTodos() throws ServicoException, ValidacaoException {
		try {
			Iterable<LancamentoES> findAll = lancamentoESRepository.findAll();
			if (CollectionUtils.isNotEmpty((Collection<LancamentoES>) findAll)) {
				List<LancamentoESDTO> lancamentoList = new ArrayList<LancamentoESDTO>();
				for (LancamentoES lancamentoES : findAll) {
					LancamentoESDTO lancDTO =  new LancamentoESDTO();
					lancDTO.setId(lancamentoES.getId());
					lancDTO.setValor(lancamentoES.getValor());
					lancDTO.setDescricao(lancamentoES.getDescricao());
					lancDTO.setCadastro(Date.from(Instant.now()));
					lancDTO.setAtualizacao(Date.from(Instant.now()));
					lancamentoList.add(lancDTO);
				}
				return lancamentoList;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
