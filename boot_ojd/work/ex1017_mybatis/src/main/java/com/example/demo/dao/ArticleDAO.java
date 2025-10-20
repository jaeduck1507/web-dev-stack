package com.example.demo.dao;

import com.example.demo.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {
    //전체글 조회
    List<ArticleVO> selectAll();

    //게시글 상세보기
    ArticleVO showView( Integer id );

    //새 글 작성
    int newArticle( ArticleVO vo );

    //글 삭제
    int deleteArticle( Integer id );

    int updateFin(ArticleVO vo);

}








