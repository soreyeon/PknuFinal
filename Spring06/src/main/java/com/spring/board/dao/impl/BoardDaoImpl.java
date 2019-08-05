package com.spring.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	//게시물목록조회
	@Override
	public List<BoardVo> getList(HashMap<String, Object> map) {
		sqlSession.selectList("Board.BoardList", map);
		List<BoardVo> list = (List<BoardVo>) map.get("result");
		return list; 
	}
	
	//게시물작성
	@Override
	public void insertBoard(BoardVo boardVo) {
		sqlSession.insert("Board.BoardWrite", boardVo);
		
	}

	//게시물 본문조회
	@Override
	public BoardVo boardView(BoardVo boardVo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("idx", boardVo.getIdx());
		sqlSession.selectList("Board.BoardView", map);
		
		List<BoardVo> list = (List<BoardVo>) map.get("result");
		BoardVo vo = list.get(0);
		return vo;
	}
	
	//게시물 수정
	@Override
	public void boardUpdate(BoardVo boardVo) {
		sqlSession.update("Board.BoardUpdate", boardVo);
		
	}

	//게시물 삭제
	@Override
	public void boardDelete(BoardVo boardVo) {
		sqlSession.delete("Board.BoardDelete", boardVo);
		
	}

}
