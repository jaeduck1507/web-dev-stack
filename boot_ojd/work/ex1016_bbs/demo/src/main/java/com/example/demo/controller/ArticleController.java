package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = {"", "/list"})
    public String getArticleList(Model model) {
        List<ArticleDto> articles = articleService.findAll();

        model.addAttribute("articles",articles);

        return "article-list";

    }

    // 게시글 상세보기
    @GetMapping("/content")
    public String getArticle(Long id,Model model) {
        model.addAttribute("article",articleService.findById(id));

        return "article-content";

    }

    // 새글 작성 페이지
    @GetMapping("/add")
    public String articleAdd(Integer member_id,Model model) {
        model.addAttribute("member_id",member_id);

        return "article-add";
    }

    // 새 글 작성
    @PostMapping("/add")
    public String postAdd(Integer member_id, String title, String description) {
        articleService.addNewArticle(member_id, title, description);
        return "redirect:/article/list";
    }

    // 수정을 원하는 게시글 검색
    @GetMapping("/edit")
    public String articleEdit(Long id,Model model) {

        ArticleDto dto = articleService.findById(id);

        model.addAttribute("dto",dto);

        return "article-edit";
    }

    // 게시글 변경사항 적용(수정)
    @PostMapping("/update")
    public String postUpdate(ArticleDto dto) {

        // 수정할 게시글의 id에 해당하는 dto조회
        ArticleDto articleDto = articleService.findById(dto.getId());

        articleDto.setTitle(dto.getTitle());
        articleDto.setDescription(dto.getDescription());
        articleService.update(articleDto);

        return "redirect:/article/list";

    }

    // 게시글 삭제
    @GetMapping("/delete")
    public String articleDelete(Long id) {
        articleService.delete(id);
        return "redirect:/article/list";
    }


}
