package serviceImpl;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import MensagensErro.MensagemErro;
import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;
import entity.CentroGastos;
import entity.Lancamento;
import enums.FlagAtivo;
import enums.TipoGastos;
import enums.TipoLancamento;
import enums.TipoRecebimento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import repository.LancamentoRepository;
import service.LancamentoService;
import validacoes.ValidacoesImpl;

public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ValidacoesImpl validacao;
	
	@Autowired
	private CentroGastosRepository centroGastosRepository;

	@Override
	public Long incluir(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.validaLancamento(lancamentoDTO);
			Lancamento lancamento = new Lancamento();
			BeanUtils.copyProperties(lancamentoDTO, lancamento);
			CentroGastos centroGastos = centroGastosRepository.findById(lancamentoDTO.getCentroGastosDTO().getId());
			if(centroGastos != null) {
				lancamento.setIdCentroGastos(centroGastos.getId());
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.CENTRO_GASTOS));
			}
			if (lancamentoDTO.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
				String valor = lancamentoDTO.getTipoRecebimento().getValor();
				switch (valor) {
				case "Salário":
					lancamento.setTipoRecebimento(TipoRecebimento.SALARIO.getValor());
					break;
				case "Investimento":
					lancamento.setTipoRecebimento(TipoRecebimento.INVESTIMENTO.getValor());
					break;
				case "Freelancer":
					lancamento.setTipoRecebimento(TipoRecebimento.FREELANCER.getValor());
					break;
				case "Herança":
					lancamento.setTipoRecebimento(TipoRecebimento.HERANCA.getValor());
					break;
				}
			}else{
				String valor = lancamentoDTO.getTipoGastos().getValor();
				switch (valor) {
				case "Moradia":
					lancamento.setTipoGasto(TipoGastos.MORADIA.getValor());
					break;
				case "Bares e Restaurantes":
					lancamento.setTipoGasto(TipoGastos.BARES_RESTAURANTES.getValor());
					break;
				case "Mercado":
					lancamento.setTipoGasto(TipoGastos.MERCADO.getValor());
					break;
				case "Lazer":
					lancamento.setTipoGasto(TipoGastos.LAZER.getValor());
					break;
				case "Compras":
					lancamento.setTipoGasto(TipoGastos.COMPRAS.getValor());
					break;
				case "Outros":
					lancamento.setTipoGasto(TipoGastos.OUTROS.getValor());
					break;
				}
			}
			
			lancamento.setCadastro(Date.from(Instant.now()));	
			lancamento.setAtualizacao(Date.from(Instant.now()));
			lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
			
			Lancamento lancamentoSave = lancamentoRepository.save(lancamento);
			if(lancamentoSave != null) {
				return lancamentoSave.getId();
			}else {
				throw new ServicoException(MensagemErro.ERRO_INSERIR.concat(MensagemErro.LANCAMENTO));
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	@Override
	public LancamentoDTO alterar(LancamentoDTO lancamentoDTO) throws ServicoException, ValidacaoException {
		try {
			validacao.validaLancamento(lancamentoDTO);
			Lancamento lancamento = lancamentoRepository.findByIdAndAtivo(lancamentoDTO.getId(), FlagAtivo.ATIVO.getValor());
			if(lancamento != null) {
				if (lancamentoDTO.getTipoLancamento().equals(TipoLancamento.CREDITO)) {
					String valor = lancamentoDTO.getTipoRecebimento().getValor();
					switch (valor) {
					case "Salário":
						lancamento.setTipoRecebimento(TipoRecebimento.SALARIO.getValor());
						break;
					case "Investimento":
						lancamento.setTipoRecebimento(TipoRecebimento.INVESTIMENTO.getValor());
						break;
					case "Freelancer":
						lancamento.setTipoRecebimento(TipoRecebimento.FREELANCER.getValor());
						break;
					case "Herança":
						lancamento.setTipoRecebimento(TipoRecebimento.HERANCA.getValor());
						break;
					}
				}else{
					String valor = lancamentoDTO.getTipoGastos().getValor();
					switch (valor) {
					case "Moradia":
						lancamento.setTipoGasto(TipoGastos.MORADIA.getValor());
						break;
					case "Bares e Restaurantes":
						lancamento.setTipoGasto(TipoGastos.BARES_RESTAURANTES.getValor());
						break;
					case "Mercado":
						lancamento.setTipoGasto(TipoGastos.MERCADO.getValor());
						break;
					case "Lazer":
						lancamento.setTipoGasto(TipoGastos.LAZER.getValor());
						break;
					case "Compras":
						lancamento.setTipoGasto(TipoGastos.COMPRAS.getValor());
						break;
					case "Outros":
						lancamento.setTipoGasto(TipoGastos.OUTROS.getValor());
						break;
					}
				}
			}else {
				throw new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO.concat(MensagemErro.LANCAMENTO));
			}
			
			Lancamento lancamentoSave = lancamentoRepository.save(lancamento);
			if(lancamentoSave != null) {
				BeanUtils.copyProperties(lancamentoSave, lancamentoDTO);
				return lancamentoDTO;
			}else {
				throw new ValidacaoException(MensagemErro.ERRO_ATUALIZAR.concat(MensagemErro.LANCAMENTO));
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
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
