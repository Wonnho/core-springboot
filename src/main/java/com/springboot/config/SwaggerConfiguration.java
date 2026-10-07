package com.springboot.config;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                 .apis(RequestHandlerSelectors.basePackage("com.springboot"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Spring Boot Open API Test with Swagger")
                .description("describe")
                .version("1.0.0")
                .build();
    }

    @ApiOperation(value="GET method example", notes="GET Method using @RequestParam")
    @GetMapping(value="/request")
    public String getRequestParam1(
        @ApiParam(value="name",required = true) @RequestParam String name,
        @ApiParam(value="email",required = true) @RequestParam String email,
        @ApiParam(value="organization",required = true) @RequestParam String organization){
        return name + " " + email + " " + organization;

        }
    }

