package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired
	private SqlSession sqlSession;
	
	//자료실 목록조회
	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.PdsList", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		return pdsList;
	}

	//자료실 글쓰기
	@Override
	public void setWrite(HashMap<String, Object> map) {
		sqlSession.insert("Pds.PdsInsert", map);
		//System.out.println("pdsDaoimpl cont: " + map.get("cont"));
		//System.out.println("pdsDaoimpl writer: " + map.get("writer"));
		
	}

	//자료실 본문 조회
	@Override
	public PdsVo getContent(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.PdsContent", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		PdsVo pdsVo = pdsList.get(0);
		return pdsVo;
	}

	//자료실 파일목록 조회
	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		sqlSession.selectList("Pds.FileList", map);
		List<FilesVo> fileList = (List<FilesVo>) map.get("result");
		return fileList;
	}

	//자료실 게시물 삭제
	@Override
	public void setDelete(HashMap<String, Object> map) {
		sqlSession.delete("Pds.PdsDelete", map);
		
	}

	//자료실 게시물 수정
	@Override
	public void setUpdate(HashMap<String, Object> map) {
		sqlSession.update("Pds.PdsUpdate", map);
		
	}

}
