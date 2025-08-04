package com.kh.upload.model.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data 
public class BoardDTO {

	private int no;
	private String title;
	private String content;
	private String url;
	private Date formatDate;
	private MultipartFile file;
}
