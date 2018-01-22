package repositoryCustomImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import MensagensErro.MensagemErro;
import dto.AnaliseLancamentoDTO;
import entity.Lancamento;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repositoryCustom.AnaliseLancamentoRepositoryCustom;
import validacoes.ValidacoesImpl;

public class AnaliseLancamentoRepositoryImpl  implements AnaliseLancamentoRepositoryCustom{

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ValidacoesImpl validacao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> analisarLancamentosFiltro(AnaliseLancamentoDTO analiseLancamentoDTO)
			throws ServicoException, ValidacaoException {
		
		StringBuilder sql = new StringBuilder();
        int count = 0;
        Map<Integer, Object> parametros =  new HashMap<>();
        
        sql.append(" SELECT lancamento FROM LANCAMENTO ")
           .append(" WHERE  ");
        
        if(analiseLancamentoDTO.getTipoLancamento() != null) {
        	sql.append(" tipoLancamento = :tipoLancamento ");
        	parametros.put(count++, analiseLancamentoDTO.getTipoLancamento());
        }
        
        if(analiseLancamentoDTO.getTipoGastos() != null) {
        	sql.append(" AND ")
        	   .append(" tipoGastos = :tipoGastos ");
        	parametros.put(count++, analiseLancamentoDTO.getTipoGastos());
        }
        
        if(analiseLancamentoDTO.getTipoRecebimento() != null) {
        	sql.append(" AND ")
        	   .append(" tipoRecebimento = :tipoRecebimento ");
        	parametros.put(count++, analiseLancamentoDTO.getTipoRecebimento());
        }
        
        if(analiseLancamentoDTO.getValorInicial() != null && analiseLancamentoDTO.getValorFinal() != null) {
        	sql.append(" AND ")
        	   .append(" BETWEEN :valorInicial AND :valorFinal ");
        	parametros.put(count++, analiseLancamentoDTO.getValorInicial());
        	parametros.put(count++, analiseLancamentoDTO.getValorFinal());
        }else if(analiseLancamentoDTO.getValorInicial() != null && analiseLancamentoDTO.getValorFinal() == null ) {
        	sql.append(" AND ")
     	       .append(" valor >= :valorInicial ");
        	parametros.put(count++, analiseLancamentoDTO.getValorInicial());
        }else {
        	sql.append(" AND ")
  	       		.append(" valor >= :valorFinal ");
        	parametros.put(count++, analiseLancamentoDTO.getValorFinal());
        }
        
        if(analiseLancamentoDTO.getInicio() != null && analiseLancamentoDTO.getFim() != null) {
        	LocalDate inicio = toLocalDate(analiseLancamentoDTO.getInicio());
        	LocalDate fim = toLocalDate(analiseLancamentoDTO.getFim());
        	Boolean validaData = validacao.validaData(inicio, fim);
        	if(validaData) {
        		sql.append(" AND ")
        		   .append(" cadastro BETWEEN :inicio and :fim");
        	}else {
        		throw new ValidacaoException(MensagemErro.ANALISE_LANCAMENTO_DATA_FIM);
        	}
        }
        
        if(analiseLancamentoDTO.getAtivo() != null) {
        	sql.append(" AND ")
        	   .append(" ativo = :ativo ");
        	parametros.put(count++, analiseLancamentoDTO.getAtivo());
        }
        
        Query query = entityManager.createQuery(sql.toString());
        for (int i = 0; i < parametros.size(); i++) {
        	query.setParameter(i, parametros.get(i));
		}
        
        List<Lancamento> lancamentos = query.getResultList();
        if(CollectionUtils.isNotEmpty(lancamentos)) {
        	return lancamentos;
        }
        return null;
		
	}
	
	private LocalDate toLocalDate(Date d) {
		Instant instant = Instant.ofEpochMilli(d.getTime());
		LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

}
