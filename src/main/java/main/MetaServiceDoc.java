package main;

import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import resource.MetaResource;

@ApplicationPath("/v1")
public class MetaServiceDoc extends Application {

	public MetaServiceDoc() {
		BeanConfig conf = new BeanConfig();
		conf.setTitle("Meta API");
		conf.setDescription("Gerenciamento de Metas");
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
		resources.add(MetaResource.class);

		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

}
