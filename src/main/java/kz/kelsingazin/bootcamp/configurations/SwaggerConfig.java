package kz.kelsingazin.bootcamp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    Contact contact = new Contact(
            "Yerassyl",
            "Kelsingazin",
            "kelsingaziny@gmail.com"
    );

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kz.kelsingazin.bootcamp"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "Bootcamp",
                "Test task",
                "VERSION 1.0",
                "no terms",
                new Contact("Tz","no url","kelsingaziny@gmail.com"),
                "APACHE 2.0",
                "",
                Collections.emptyList()
        );
    }
}
