package com.baiyun;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 使用swagger-ui则访问 http://127.0.0.1:8089/swagger-ui.html
 * 使用swagger-bootstrap-ui则访问 http://127.0.0.1:8089/doc.html
 */
@SpringBootApplication
@MapperScan("com.baiyun.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationRun.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = springApplication.run(args);
    }
}
