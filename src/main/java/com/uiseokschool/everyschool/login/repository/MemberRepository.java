package com.uiseokschool.everyschool.login.repository;

import com.uiseokschool.everyschool.login.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
