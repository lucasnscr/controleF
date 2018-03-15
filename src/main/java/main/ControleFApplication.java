package main;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import dto.LancamentoESDTO;
import enums.FlagAtivo;
import enums.TipoLancamento;
import factoryConnection.ConnectionES;
import factoryConnection.S3Connection;
import service.S3Service;
import serviceImpl.LancamentoESServiceImpl;

@SpringBootApplication
public class ControleFApplication implements CommandLineRunner{

	public static final Logger log = LoggerFactory.getLogger(ControleFApplication.class);

	@Autowired
    private ElasticsearchOperations es;

    @Autowired
    private LancamentoESServiceImpl lancamentoService;
    
    @Autowired
	S3Service s3Service;
	
	@Value("${jsa.s3.uploadfile}")
	private String uploadFilePath;
	
	@Value("${jsa.s3.key}")
	private String downloadKey;
	
	public static void main(String[] args) throws Exception {
		ConnectionES elastic =  new ConnectionES();
		elastic.client();
		
		S3Connection s3 = new S3Connection();
		s3.s3client();
		
		SpringApplication.run(ControleFApplication.class, args);
	}

	  @Override
	    public void run(String... args) throws Exception {

	        printElasticSearchInfo();

	        LancamentoESDTO lancamento = new LancamentoESDTO();
	        lancamento.setId(1L);
	        lancamento.setTipoLancamento(TipoLancamento.CREDITO);
	        lancamento.setValor(10.500);
	        lancamento.setDescricao("Salario");
	        lancamento.setCadastro(Date.from(Instant.now()));
	        lancamento.setAtualizacao(Date.from(Instant.now()));
	        lancamento.setTipoRecebimento(null);
	        lancamento.setAtivo(FlagAtivo.ATIVO);
	        
	        lancamentoService.incluir(lancamento);
	        
	        /*
	         * AWS Amazon S3
	         */
	        
			System.out.println("---------------- START UPLOAD FILE ----------------");
			s3Service.uploadFile("lucasApresentacao.pdf", uploadFilePath);
			System.out.println("---------------- START DOWNLOAD FILE ----------------");
			s3Service.downloadFile(downloadKey);
	    }

	    //useful for debug, print elastic search details
	    private void printElasticSearchInfo() {

	        System.out.println("--ElasticSearch--");
	        Client client = es.getClient();
	        Map<String, String> asMap = client.settings().getAsMap();

	        asMap.forEach((k, v) -> {
	            System.out.println(k + " = " + v);
	        });
	        System.out.println("--ElasticSearch--");
	    }

	    
	    
	    
}
