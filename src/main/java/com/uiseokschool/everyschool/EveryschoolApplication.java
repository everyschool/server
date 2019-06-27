package com.uiseokschool.everyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@EntityScan(basePackages = {"com.uiseokschool.everyschool"})
@PropertySource({
    "classpath:application.properties",
    "classpath:application.yml"
})
@SpringBootApplication
public class EveryschoolApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EveryschoolApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EveryschoolApplication.class, args);
    }

}
