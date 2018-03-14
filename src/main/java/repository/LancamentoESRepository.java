package repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import entity.LancamentoES;
import enums.TipoLancamento;

public interface LancamentoESRepository extends ElasticsearchRepository<LancamentoES, String> {
	
	LancamentoES findById(Long id);
	List<LancamentoES> findyByTipoLancamento(TipoLancamento tipoLancamento);

}
