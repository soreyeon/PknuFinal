package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.board.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getList(HashMap<String, Object> map);

	public void insertBoard(BoardVo boardVo);

	public BoardVo boardView(BoardVo boardVo);

	public void boardUpdate(BoardVo boardVo);

	public void boardDelete(BoardVo boardVo);

}
