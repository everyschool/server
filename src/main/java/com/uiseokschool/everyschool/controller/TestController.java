package com.uiseokschool.everyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/hello")
    public String testHello() {
        return "Hello EverySchool!";
    }

    @GetMapping("/test/{param}")
    public Object testPathParam(@PathVariable long param) {
        return "Here is your pathVariable : " + param;
    }
}
