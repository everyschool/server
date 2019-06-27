package com.uiseokschool.everyschool.controller;

import com.uiseokschool.everyschool.common.config.slack.SlackSender;
import com.uiseokschool.everyschool.common.model.CommonResponse;
import com.uiseokschool.everyschool.login.repository.MemberRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private SlackSender slackSender;

    @GetMapping
    public ResponseEntity healthCheck() {
        log.info("Everyschool Health-check.");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testGet/hello")
    public String testHello() {
        return "Hello EverySchool!";
    }

    @GetMapping("/testPathParam/{param}")
    public Object testPathParam(@PathVariable long param) {
        return "Here is your pathVariable : " + param;
    }

    @ApiOperation(value = "메세지 포스트 테스트", response = Object.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "param1", value = "post test param1 need", required = true),
        @ApiImplicitParam(name = "param2", value = "post test param2 not-need", required = false)
    })
    @PostMapping(value = "/testPost")
    public Object testPost(
        @RequestParam String param1,
        @RequestParam String param2
    ) {
        return param1 + param2;
    }

    @ApiOperation(value = "에러 슬랙메세지 테스트", response = Object.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "param1", value = "에러메세지", required = true),
    })
    @PostMapping(value = "/testErrorSlackSend")
    public Object testErrorSlackSend(@RequestParam String param1) {
        slackSender.sendMessage(new Throwable(param1));
        return CommonResponse.builder().build();
    }
}
