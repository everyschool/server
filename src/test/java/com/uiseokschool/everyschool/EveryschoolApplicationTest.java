package com.uiseokschool.everyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@EntityScan(basePackages = {"com.uiseokschool.everyschool"})
@SpringBootTest
@SpringBootConfiguration
@PropertySource({"classpath:application.properties", "classpath:application.yml"})
@SpringBootApplication
public class EveryschoolApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(EveryschoolApplicationTest.class, args);
    }
}
