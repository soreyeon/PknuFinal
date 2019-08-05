package com.spring.pds.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsService {

	public List<PdsVo> getList(HashMap<String, Object> map);

	public void setWrite(HashMap<String, Object> map, HttpServletRequest request);

	public PdsVo getContent(HashMap<String, Object> map);

	public List<FilesVo> getFileList(HashMap<String, Object> map);

	public void setDelete(HashMap<String, Object> map);

	public void setUpdate(HashMap<String, Object> map); 
	
}
