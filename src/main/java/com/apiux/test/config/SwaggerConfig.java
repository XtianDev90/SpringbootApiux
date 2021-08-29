package com.apiux.test.config;
//http://localhost:8010/swagger-ui.html
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apiux.test"))
                .paths(regex("/tareas.*"))
                .build()
                .apiInfo(swaggerInfo());
    }

    private ApiInfo swaggerInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "COOPEUCH",
                "Desafío técnico Mantenedor N°1",
                "1.0",
                "Terms of Service",
                new Contact("Christian", "https://localhost:8080/tareas",
                        "chr.mondaca@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }
}
