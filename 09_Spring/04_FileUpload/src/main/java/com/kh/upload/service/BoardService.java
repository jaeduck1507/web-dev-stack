package com.kh.upload.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingBoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;

	public void insert(Board vo) {
		mapper.insert(vo);
	}

	public List<BoardDTO> selectAll(PagingBoardDTO pbd) {
		
		pbd.getPagingDTO().setOffset(pbd.getPagingDTO().getLimit() * (pbd.getPagingDTO().getPage() - 1));
		List<Board> list = mapper.selectAll(pbd);
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board b : list) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(b.getNo());
			dto.setTitle(b.getTitle());
			Date formatDate = Date.from(b.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formatDate);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public Board select(int no) {
		return mapper.select(no);
	}

	public void update(BoardDTO dto) {
		mapper.update(dto);
	}

	public void delete(int no) {
		mapper.delete(no);
	}
	
	public int total(String search) {
		return mapper.total(search);
	}
}
