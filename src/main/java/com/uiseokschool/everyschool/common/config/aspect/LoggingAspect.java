package com.uiseokschool.everyschool.common.config.aspect;

import com.uiseokschool.everyschool.common.config.slack.SlackSender;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class LoggingAspect {

    @Autowired
    private SlackSender slackSender;

    @AfterThrowing(pointcut = "execution(* com.uiseokschool.everyschool.*.controller.*Controller.*(..))", throwing = "e")
    public void logException(JoinPoint jp, Throwable e) {
//        slackSender.sendMessage(e);
        log.info("###################################################");
        log.error("{}, {}", e.getMessage(), e);
    }

    @Before("execution(* com.uiseokschool.everyschool.*.controller.*Controller.*(..))")
    public void logRequest(JoinPoint jp) {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (Object object : jp.getArgs()) {
            log.info("<<< {} ", object.toString());
        }
    }

    @AfterReturning(pointcut = "execution(* com.uiseokschool.everyschool.*.controller.*Controller.*(..))", returning = "response")
    public void logResponse(JoinPoint jp, Object response) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(">>> {} ", response);
    }

}
