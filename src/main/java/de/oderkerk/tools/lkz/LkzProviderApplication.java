package de.oderkerk.tools.lkz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class LkzProviderApplication {
	@Autowired
	BuildProperties buildProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(LkzProviderApplication.class, args);
	}

	 @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Länderkennzeichen Datenbank Tool")
	              .description("Diese Anwendung dient zur Ermittlung / Konvertierung von Länderkennzeichen")
	              .version(buildProperties.getVersion())
	              .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Länderkennzeichen Datenbank Tool Dokumentation")
	              .url("https://github.com/moderkerk"));
	  }
}
