package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    //<select id="selectAll">
    List<Member> selectAll();
    int selectAllCount();

    //이메일로 검색한 결과가 한 건도 없다면
    //Optinal.empty()를 반환
    Optional<Member> selectByEmail( String email );
}









