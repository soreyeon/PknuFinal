package com.spring.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Controller
public class PdsController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PdsService pdsService;
	
	//자료실 목록 조회
	@RequestMapping("/Pds/List")  // @RequestMapping("/Pds/List")
	public ModelAndView pdsList(@RequestParam HashMap<String, Object> map) {
		
		List<MenuVo> menuList = menuService.getList(); //메뉴목록조회
		List<PdsVo> pdsList = pdsService.getList(map); //data조회
		PdsVo pagePdsVo = (PdsVo) map.get("pagePdsVo");
		
		//System.out.println("pdsList map cont: " + map.get("cont"));
		//System.out.println("pdsList map writer: " + map.get("writer"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("pdsList", pdsList);
		mv.addObject("pagePdsVo", pagePdsVo);

		//System.out.println("pdsList pagePdsVo: " + pagePdsVo);
		
		mv.addObject("menu_id", map.get("menu_id"));
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("/pds/list");
		return mv;
	}
	
	//자료실 글쓰기form
	@RequestMapping("/Pds/WriteForm")
	public ModelAndView pdsWriteForm(@RequestParam HashMap<String, Object> map) {
		//System.out.println("WriteForm map1: " + map);
		
		List<MenuVo> menuList = menuService.getList();
		
		//map.put("user_id", "sky");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("map", map);
		mv.setViewName("pds/write");
		
		//System.out.println("WriteForm map2: " + map);
		return mv;
	}
	
	//자료실 글쓰기(파일 업로드)
	@RequestMapping("/Pds/Write")
	public ModelAndView pdsWrite(@RequestParam HashMap<String, Object> map, HttpServletRequest request) {
		
		//넘어온 자료를 저장
		pdsService.setWrite(map, request);
		
		//System.out.println("pdsWirte cont: " + map.get("cont"));
		//System.out.println("pdsWirte writer: " + map.get("writer"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menu_id", map.get("menu_id"));
		
		//페이징정보를 가지고 가야한다.
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("redirect:/Pds/List");
		
		
		return mv;
	}
	
	//자료실 본문조회
	@RequestMapping("/Pds/Content")
	public ModelAndView pdsContent(@RequestParam HashMap<String, Object> map) {
		//idx, menu_id, nowpage, pagegrpnum
		
		//조회필요(idx로 조회)
		
		
		List<MenuVo> menuList = menuService.getList(); //메뉴목록조회
		PdsVo pdsVo = pdsService.getContent(map); //본문정보
		List<FilesVo> fileList = pdsService.getFileList(map);
		
		System.out.println("fileList: " + fileList );
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("menu_id", map.get("menu_id"));
		mv.addObject("map", map);
		
		//mv.addObject("writer", pdsVo.getWriter());
		//mv.addObject("regdate", pdsVo.getRegdate());
		mv.addObject("pdsVo", pdsVo);
		
		mv.addObject("fileList", fileList);
		mv.setViewName("pds/content");
		
		return mv;
	}
	
	//파일다운로드
	//@PathVariable
	//{type} : 첫번째 인자 internal(프로젝트 내부에 파일이 존재)/external(프로젝트 외부(d:\\Upload)에 파일이 존재)
	//{sfile:.+} : 두번째 인자(파일명)
	
	///download/external/aaa.jpg
	// type = external
	// sfile = aaa.jpg
	
	//{:.+} .+ : 정규식 +(글자한개 이상)  
	//{sfile} : dot(.)이하 글자 무시됨
	//{sfile:.+} : dot(.)이하 글자를 무시하지 않음
	@RequestMapping(value = "/download/{type}/{sfile:.+}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type, @PathVariable("sfile") String sfile) throws IOException {
		
		String INTERNAL_FILE = sfile;
		String EXTERNAL_FILE_PATH = "c:\\Upload\\" + sfile;
		System.out.println(EXTERNAL_FILE_PATH);
		
		File file = null;
		if(type.equalsIgnoreCase("internal")) {
			//현재 실행중인 웹서버 파일의 경로
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
		} else {
			file = new File(EXTERNAL_FILE_PATH);
		}
		
		//파일이 없을때 처리
		if(!file.exists()) {
			String errorMessage = "Sorry. this file are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		
		/*String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}*/
		
		String mimeType = "application/octet-stream"; //강제 다운로드 인코딩
		System.out.println("mimeType: " + mimeType);
		
		response.setContentType(mimeType); //브라우저가 처리할 파일 형식 지정
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\"")); //response값에 header지정
		response.setContentLength( (int) (file.length()) ); //다운로드할 파일용량
		
		//다운로드
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	//자료실 게시물 삭제
	@RequestMapping("/Pds/Delete")
	public ModelAndView pdsDelete(@RequestParam HashMap<String, Object> map) {
		
		pdsService.setDelete(map);
		
		String fmt = "?menu_id={0}&nowpage={1}&pagegrpnum={2}";
		String param = MessageFormat.format(fmt, map.get("menu_id"), map.get("nowpage"), map.get("pagegrpnum"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Pds/List" + param);
		
		return mv;
	}
	
	//자료실 게시물 수정 form
	@RequestMapping("/Pds/UpdateForm")
	public ModelAndView pdsUpdateForm(@RequestParam HashMap<String, Object> map) {
		//idx, menu_id, nowpage, pagegrpnum
		
		//메뉴목록 출력
		List<MenuVo> menuList = menuService.getList();
		
		//파일목록 출력
		List<FilesVo> fileList = pdsService.getFileList(map);
		
		//수정할 data필요
		PdsVo pdsVo = pdsService.getContent(map);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.addObject("menuList", menuList);		
		mv.addObject("fileList", fileList);		
		mv.addObject("pdsVo", pdsVo);
		System.out.println("pdsUpdateForm pdsVo: " + pdsVo);
		String viewName = "pds/update";
		mv.setViewName(viewName);
		
		return mv;
	}
	
	//자료실 게시물 수정
	@RequestMapping("/Pds/Update")
	public ModelAndView pdsUpdate(@RequestParam HashMap<String, Object> map) {
		//idx, menu_id, nowpage, pagegrpnum
		
		pdsService.setUpdate(map);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("map", map);
		String fmt = "redirect:/Pds/List?menu_id={0}&nowpage={1}&pagegrpnum={2}";
		String viewName = MessageFormat.format(fmt, map.get("menu_id"), map.get("nowpage"), map.get("pagegrpnum"));
		mv.setViewName(viewName);
		
		return mv;
	}
	
}
