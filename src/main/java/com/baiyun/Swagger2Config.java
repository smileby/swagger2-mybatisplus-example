package com.baiyun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@EnableSwaggerBootstrapUI
//@ConditionalOnProperty(prefix="swagger",name="enabled",havingValue="true")
public class Swagger2Config {

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("swagger测试").version("1.0.0").build();
    }

    @Bean
    public Docket commonApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试分组")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baiyun.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
