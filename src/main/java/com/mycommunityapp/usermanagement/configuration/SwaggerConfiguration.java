package com.mycommunityapp.usermanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            Arrays.asList("application/json"));

    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
               // .apiInfo(getApiInfo()).produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mycommunityapp.usermanagement.controller"))
                .paths(PathSelectors.any()).build();

    }


    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder().title("Login Api").description("Enhanced login security based on roles API")
                .contact(new Contact("vinoth", "www.apibucket.in", "vinoth.vsv95@gmail.com")).license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
    }
}
