package com.uiseokschool.everyschool.common.slack;

import com.uiseokschool.everyschool.EveryschoolApplicationTest;
import com.uiseokschool.everyschool.common.config.slack.SlackSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EveryschoolApplicationTest.class)
public class SlackMessageTest {
    @Autowired
    private SlackSender slackSender;


}
