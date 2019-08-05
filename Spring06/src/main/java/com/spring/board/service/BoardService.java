package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import com.spring.board.vo.BoardVo;

public interface BoardService {

	public List<BoardVo> getList(HashMap<String, Object> map);

	public void insertBoard(BoardVo boardVo);

	public BoardVo boardView(BoardVo boardVo);

	public void boardUpdate(BoardVo boardVo);

	public void boardDelete(BoardVo boardVo);
	
}
