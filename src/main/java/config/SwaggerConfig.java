package config;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("$spring.application.name")
	private String applicationName;
	
	@Value("$spring.application.version")
	private String applicationVersion;
	
	@Value("$spring.application.description")
	private String applicationDescription;
	
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.directModelSubstitute(LocalDate.class, Date.class)
				.select()
				.apis(RequestHandlerSelectors.basePackage("resource"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(applicationName)
				.description(applicationDescription)
				.version(applicationVersion)
				.contact(new Contact("Lucas do Nascimento Silva","", "lucas.nascimento.scr@hotmail.com")).build();
		
	}

}
