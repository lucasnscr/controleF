package ServiceImplTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.print.Book;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import entity.LancamentoES;
import enums.FlagAtivo;
import enums.TipoLancamento;
import repository.LancamentoESRepository;
import service.LancamentoESService;
import service.LancamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestElasticSearch {

    @Autowired
    private LancamentoESRepository lancamentoESRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Book.class);
        esTemplate.createIndex(Book.class);
        esTemplate.putMapping(Book.class);
        esTemplate.refresh(Book.class);
    }

    @Test
    public void testSave() {

        LancamentoES lancamento = new LancamentoES();
        lancamento.setId(1L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
        LancamentoES lancamentoTest = lancamentoESRepository.save(lancamento);

        assertNotNull(lancamentoTest.getId());
        assertEquals(lancamentoTest.getValor(), lancamento.getValor());
        assertEquals(lancamentoTest.getTipoGasto(), lancamento.getTipoGasto());

    }

    @Test
    public void testFindOne() {

    	LancamentoES lancamento = new LancamentoES();
        lancamento.setId(1L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
        LancamentoES lancamentoTest = lancamentoESRepository.save(lancamento);

        
        Long id = lancamentoTest.getId();
        String idParse = String.valueOf(id);
        LancamentoES lancamentoTest2 = lancamentoESRepository.findOne(idParse);

        assertNotNull(lancamentoTest2.getId());
        assertEquals(lancamentoTest2.getValor(), lancamento.getValor());
        assertEquals(lancamentoTest2.getTipoGasto(), lancamento.getTipoGasto());

    }

    @Test
    public void testFindById() {

    	LancamentoES lancamento = lancamentoESRepository.findById(1L);
    	assertEquals(1L, lancamento);
    }

    @Test
    public void testFindByAll() {

        List<LancamentoES> lancamentoList = new ArrayList<>();

        LancamentoES lancamento = new LancamentoES();
        lancamento.setId(1L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
        
        LancamentoES lancamento2 = new LancamentoES();
        lancamento.setId(2L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
        
        LancamentoES lancamento3 = new LancamentoES();
        lancamento.setId(3L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
        
        
        lancamentoList.add(lancamento);
        lancamentoList.add(lancamento2);
        lancamentoList.add(lancamento3);

        
        for (LancamentoES lanc : lancamentoList) {
            lancamentoESRepository.save(lanc);
        }

        assertNotNull(lancamentoList);
    }

    @Test
    public void testDelete() {

        LancamentoES lancamento = new LancamentoES();
        lancamento.setId(1L);
        lancamento.setIdCentroGastos(1L);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO.getValor());
        lancamento.setValor(10.500);
        lancamento.setDescricao("Salario");
        lancamento.setCadastro(Date.from(Instant.now()));
        lancamento.setAtualizacao(Date.from(Instant.EPOCH.now()));
        lancamento.setTipoGasto(null);
        lancamento.setTipoRecebimento(null);
        lancamento.setAtivo(FlagAtivo.ATIVO.getValor());
    	
        lancamentoESRepository.save(lancamento);
        lancamentoESRepository.delete(lancamento);
        Long id = lancamento.getId();
        String idParse = String.valueOf(id);
        LancamentoES tesLanc = lancamentoESRepository.findOne(idParse);
        assertNull(tesLanc);
    }

}