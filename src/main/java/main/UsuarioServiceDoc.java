package main;

import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import resource.UsuarioResource;

@ApplicationPath("/v1")
public class UsuarioServiceDoc extends Application {
	
	public UsuarioServiceDoc() {
		BeanConfig conf = new BeanConfig();
		conf.setTitle("Usuário API");
		conf.setDescription("Gerenciamento de usuários");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8080");
		conf.setBasePath("/controleF/v1");
		conf.setSchemes(new String[] { "http" });
		conf.setResourcePackage("src/main/java/resource");
		conf.setScan(true);
	}

	@Override
	public java.util.Set<Class<?>> getClasses() {
		java.util.Set<Class<?>> resources = new HashSet<>();
		resources.add(JacksonJavaTimeConfiguration.class);
		resources.add(UsuarioResource.class);

		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

}
