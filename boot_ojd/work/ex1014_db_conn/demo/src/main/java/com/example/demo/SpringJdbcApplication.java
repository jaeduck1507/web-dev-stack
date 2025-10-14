package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/*
*   @Component
*   ㄴ @Controller
*   ㄴ @Repository
*   ㄴ @Service
* */

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository; // @RequiredArgsConstructor로 통해 final이 붙은 객체 생성


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("{}","hello run");

//        // create
//        Member member = Member.builder()
//                .name("오재덕")
//                .email("hgd@a.com")
//                .age(10)
//                .build();
//
//        memberRepository.save(member);
//        member.setAge(11);
//        memberRepository.save(member);

        // 이름으로 조회
        List<Member> members = memberRepository.findByName("홍길동");
        if(members.isEmpty()) {
            log.info("홍길동 이라는 이름의 회원이 없습니다");
        }else{
            for(Member member : members) {
                log.info("조회된 회원 {}",member);
            }
        }

        // 이름에 o가 포함되어 있는 데이터를 조회
        log.info("포함여부{}",memberRepository.findByNameContaining("o"));

        int res = memberRepository.deleteByName("홍길동");



    }
}
