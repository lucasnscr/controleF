package factoryConnection;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "repository")
public class ConnectionES {

	@Value("${elasticsearch.host}")
	private String esHost;
	
	@Value("${elasticsearch.port}")
	private int esPort;
	
	@Value("${elasticsearch.clustername}")
	private String cluster;
	
	@Bean
	public Client client() throws Exception{
		
		Settings esSetting = Settings.settingsBuilder()
				.put("cluster.name", cluster)
				.build();
		return  TransportClient.builder()
				.settings(esSetting)
				.build()
				.addTransportAddress((TransportAddress) new InetSocketAddress(InetAddress.getByName(esHost), esPort));
		
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception{
		return new ElasticsearchTemplate(client());
	}
	
}
