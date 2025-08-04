package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingBoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;

@Mapper
public interface BoardMapper {
	void insert(Board vo);
	List<Board> selectAll(PagingBoardDTO pbd);
	Board select(int no);
	void update(BoardDTO dto);
	void delete(int no);
	int total(String search);
	List<Board> search();
}







