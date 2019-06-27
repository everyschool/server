package com.uiseokschool.everyschool.login.service;

import com.uiseokschool.everyschool.login.model.entity.Member;
import com.uiseokschool.everyschool.login.repository.MemberRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member findMember(long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) return member.get();
        else return null;
    }
}
