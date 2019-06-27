package com.uiseokschool.everyschool.login.service;

import com.uiseokschool.everyschool.EveryschoolApplicationTest;
import org.junit.Assert;
import org.junit.Test;
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
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void 멤버가져오기테스트() {
        Assert.assertNotNull(memberService.findMember(1L));
    }
}
