package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	//자료실 목록조회
	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		
		//map
		//{ menu_id: 'MENU01' }
		//{ nowpage: 1 } //현재페이지 정보
		//{ pagecount: 10 } //한페이지에 보여줄 data rows
		//{ pagegrpnum: 1 }
		
		//System.out.println("ServiceImpl map menu_id: " + map.get("menu_id"));
		
		int pagetotalcount = 10; //[이전] 1 2 3 4 5 6 7 8 9 10 [다음]
		int pagecount = 2; //한페이지에 보여줄 data라인수(자료수)
		
		map.put("pagecount", pagecount);//db에 전달하기 위해 보관
		
		//db 조회
		List<PdsVo> pdsList = pdsDao.getList(map);
		
		
		//조회된 이후 처리
		//map : 기존 map + Mybatis 에서 넘겨준(out) 정보
		int nowpage = Integer.parseInt((String) map.get("nowpage")); //request
		int pagegrpnum = Integer.parseInt((String) map.get("pagegrpnum")); //request
		
		int totalcount = (int) map.get("totalcount"); //MyBatis에서 넘겨준(out) 정보
		
		//BoardPaging: paging.jspf에 필요한 값을 계산해준다 -->pdsVo
		BoardPaging bp = new BoardPaging(nowpage, pagecount, totalcount, pagetotalcount, pagegrpnum);
		
		//paging.jspf에 필요한 값을 가져온다.
		PdsVo vo = bp.getPdsPagingInfo();
		
		vo.setMenu_id((String) map.get("menu_id")); //map.get(""): Object return
		
		map.put("pagePdsVo", vo);
		
		//System.out.println("service List: " + vo);
		
		return pdsList;
	}

	
	//자료실 글쓰기
	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//1. 넘어온 문자들 처리
		// DaoImpl이 처리 --> db저장
		//writer, title, cont, menu_id, bnum, lvl, step, nref
		
		//2. 넘어온 파일 저장
		//MultipartHttpServletRequest 객체가 담당
		
		//3. 저장된파일정보 db에 저장
		//---------------------------------
		
		//중복파일 처리
		CheckFileName checkFile = new CheckFileName();
		
		String filePath = "c:\\Upload\\"; //저장될 경로 지정
		
		//업로드된 파일의 처리(저장)
		MultipartHttpServletRequest multipartServletRequest = (MultipartHttpServletRequest) request;
		
		Iterator<String> iterator = multipartServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		//저장된 파일 목록 정보
		List<String> filenames = new ArrayList<String>();
		List<String> fileexts = new ArrayList<String>();
		List<String> sfilenames = new ArrayList<String>();
		
		String fileName = null;
		String orgFileName = null;
		String fileExt = null;
		String sFileName = null;
		
		int i = 0;
		while(iterator.hasNext()) {
			multipartFile = multipartServletRequest.getFile(iterator.next());
			
			HashMap<String, String> hashMap = new HashMap<>();
			
			if(!multipartFile.isEmpty()) {
				fileName = multipartFile.getOriginalFilename();
				//upload된 파일명
				
				int dotIdx = fileName.lastIndexOf('.');
				orgFileName = fileName.substring(0, dotIdx);
				fileExt = fileName.substring(dotIdx);
				
				//중복파일이 존재하면 번호추가 후 실제파일명 처리
				sFileName = checkFile.getCheckFileName(filePath, orgFileName, fileExt);
				
				filenames.add(fileName);
				fileexts.add(fileExt);
				sfilenames.add(sFileName);
				
				map.put("filenames", filenames);
				map.put("fileexts", fileexts);
				map.put("sfilenames", sfilenames);
				
				System.out.println(map);
				
				//저장
				File file = new File(filePath + sFileName);
				i += 1;
				
				try {
					multipartFile.transferTo(file); //실제 파일명으로 저장
				} catch (IllegalStateException | IOException e) {
					System.out.println("오류: " + e.getMessage());
					e.printStackTrace();
				} 
				
			}
			
		} //file 저장 끝
		
		// db에 정보저장, 1, 3
		pdsDao.setWrite(map);
		
	}

	//자료실 본문 조회
	@Override
	public PdsVo getContent(HashMap<String, Object> map) {
		PdsVo pdsVo = pdsDao.getContent(map);
		return pdsVo;
	}

	//파일 목록 조회
	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		List<FilesVo> fileList = pdsDao.getFileList(map);
		return fileList;
	}

	//자료실 게시물 삭제
	@Override
	public void setDelete(HashMap<String, Object> map) {
		//Board table과 files table에 relation이 있을때 삭제 순서 중요
		//1. Files table 해당 idx항목 record 삭제
		
		//2. 실제파일 삭제: c:\\Upload\\
		List<FilesVo> fileList = pdsDao.getFileList(map);
		for (FilesVo filesVo : fileList) {
			File file = new File("c:\\Upload\\" + filesVo.getSfilename());
			if(file.exists())
				file.delete();
		}		
		//3. Board table 해당 idx항목 record 삭제
		pdsDao.setDelete(map);
	}

	//자료실 게시물 수정
	@Override
	public void setUpdate(HashMap<String, Object> map) {
		//db수정
		pdsDao.setUpdate(map);
		
		//파일처리
		
	}


}
