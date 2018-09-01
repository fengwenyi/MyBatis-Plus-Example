package com.fengwenyi.mp3demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * @author Wenyi Feng
 * @since 2018-08-31
 */
@EnableSwagger2
@Configuration
public class SwaggerConfigure {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fengwenyi.mp3demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MyBatis-Plus 3.x Demo")
                .description("Spring Boot基础MyBatis-Plus 3.0.1 实现 student-city-idCard 示例")
                .termsOfServiceUrl("http://fengwenyi.com")
                .contact(new Contact("Wenyi Feng", "http://fengwenyi.com", "xfsy2014@gmail.com"))
                .version("1.0")
                .license("license")
                .licenseUrl("http://fengwenyi.com/license")
                .build();
    }

}