package com.spring.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	//게시물목록조회
	@Override
	public List<BoardVo> getList(HashMap<String, Object> map) {
		List<BoardVo> list = boardDao.getList(map);
		return list;
	}
	
	//게시물작성
	@Override
	public void insertBoard(BoardVo boardVo) {
		boardDao.insertBoard(boardVo);
		
	}

	//게시물 본문조회
	@Override
	public BoardVo boardView(BoardVo boardVo) {
		BoardVo vo = boardDao.boardView(boardVo);
		return vo;
	}

	//게시물 수정
	@Override
	public void boardUpdate(BoardVo boardVo) {
		boardDao.boardUpdate(boardVo);
		
	}

	//게시물 삭제
	@Override
	public void boardDelete(BoardVo boardVo) {
		boardDao.boardDelete(boardVo);
		
	}
	
}
