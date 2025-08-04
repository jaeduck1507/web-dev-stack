package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.Application;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingBoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    private final Application application;

	@Autowired
	private BoardService service;

    BoardController(Application application) {
        this.application = application;
    }
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	public String fileUpload(MultipartFile file) {
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		System.out.println(fileName);
		File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);

		try {
			file.transferTo(copyFile);
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());

		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}

	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		for (MultipartFile file : files) {
			String fileName = fileUpload(file);
		}

		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model,PagingDTO paging, String search) {
		System.out.println(search);
		PagingBoardDTO pbd = new PagingBoardDTO(search, paging);
		List<BoardDTO> list = service.selectAll(pbd);
		model.addAttribute("list", list);
		model.addAttribute("search", search);
		model.addAttribute("paging", new PagingDTO(paging.getPage(),service.total(search)));
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println(dto.getFile());
		
		String fileName = fileUpload(dto.getFile());
		
		Board vo = new Board();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setUrl(fileName);
		service.insert(vo);
		
		System.out.println(vo);
		return "redirect:/view?no=" + vo.getNo();
	}
	
	@GetMapping("/view")
	public String view(int no, Model model) {
		model.addAttribute("content", service.select(no));
		
		return "view";
	}
	
	@PostMapping("/delete")
	public String delete(BoardDTO dto) {
		File file = new File("\\\\192.168.0.35\\upload\\" + dto.getUrl());
		System.out.println(file.getPath());
		file.delete();
		service.delete(dto.getNo());
		return "redirect:/list";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO dto) {
		if(!dto.getFile().getOriginalFilename().isBlank()) {
			File delFile = new File("\\\\192.168.0.35\\upload\\" + dto.getUrl());
			delFile.delete();
			dto.setUrl(fileUpload(dto.getFile()));
		}
		service.update(dto);
		return "redirect:/view?no="+dto.getNo();
	}
	
	
	
	
	
	
	
	
}
