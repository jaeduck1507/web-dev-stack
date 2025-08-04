package com.kh.upload.model.dto;

import com.kh.upload.model.vo.Board;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class PagingBoardDTO {
	private String search;
	private PagingDTO pagingDTO;
}
