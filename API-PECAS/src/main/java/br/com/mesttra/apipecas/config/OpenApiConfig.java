package br.com.mesttra.apipecas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Peças")
                        .version("2.0")
                        .description("Projeto final do programa 1000DEVs da Johnson & Johnson e Mesttra")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Mesttra").url("https://www.mesttra.com/")));



    }

}
