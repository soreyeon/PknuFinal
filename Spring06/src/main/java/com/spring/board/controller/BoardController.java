package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;
import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class BoardController {

   protected static Logger logger = Logger.getLogger(Main.class.getName());
   
   @Autowired
   private BoardService boardService;
   
   @Autowired
   private MenuService menuService;
	  
   @RequestMapping("/")
   public String home() {
	   logger.info("인터셉터 테스트");
	   return "home";
   }
   
   //게시물목록조회
   @RequestMapping("/Board/List")
   public ModelAndView list(@RequestParam HashMap<String, Object> map) {
	   System.out.println("menu_id: " + map.get("menu_id"));
	   
	   ModelAndView mv = new ModelAndView();

	   //메뉴목록조회
	   List<MenuVo> menuList = menuService.getList();
	   mv.addObject("menuList", menuList);
	   
	   //게시물 목록조회
	   List<BoardVo> list = boardService.getList(map);
	  
	   mv.setViewName("list");
	   mv.addObject("boardList", list);
	   mv.addObject("menu_id", map.get("menu_id"));
	   
	   return mv;
   }
   
   //게시물 작성form
   //@RequestParam : 모든 정보가 존재하에 400발생하지 않음
   @RequestMapping("/Board/WriteForm")
   public ModelAndView writeForm(BoardVo boardVo) {
	   System.out.println("writeForm:" + boardVo);
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("write");
	   mv.addObject("boardVo", boardVo);
	   mv.addObject("menu_id", boardVo.getMenu_id());
	   return mv;
   }
   
   //게시물 작성
   @RequestMapping("/Board/Write")
   public ModelAndView write(BoardVo boardVo) {
	   System.out.println("write boardVo: " + boardVo.toString());
	   
	   boardService.insertBoard(boardVo);
	   
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("redirect:/Board/List?menu_id=" + boardVo.getMenu_id());
	   mv.addObject("boardVo", boardVo);
	   mv.addObject("menu_id", boardVo.getMenu_id());
	   return mv;
   }
   
   //게시물 본문조회
   @RequestMapping("/Board/Content")
   public ModelAndView view(BoardVo boardVo) {
	   BoardVo vo = boardService.boardView(boardVo);
	   
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("view");
	   mv.addObject("brd", vo);
	   mv.addObject("menu_id", boardVo.getMenu_id());
	   return mv;
   }
   
   //게시물 수정form
   @RequestMapping("/Board/UpdateForm")
   public ModelAndView UpdateForm(BoardVo boardVo) {
	  System.out.println("updateform boardVo: " + boardVo);
	  BoardVo vo = boardService.boardView(boardVo);
	  
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("update");
	  mv.addObject("boardVo", vo);
	  mv.addObject("menu_id", boardVo.getMenu_id());
	  return mv;
   }
   
   //게시물 수정
   @RequestMapping("/Board/Update")
   public ModelAndView Update(BoardVo boardVo) {
	   System.out.println("update boardVo: " + boardVo.toString());
	   boardService.boardUpdate(boardVo);
	   
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("redirect:/Board/List?menu_id=" + boardVo.getMenu_id());
	   mv.addObject("menu_id", boardVo.getMenu_id());
	   return mv;
   }
   
   //게시물 삭제
   @RequestMapping("/Board/Delete")
   public ModelAndView Delete(BoardVo boardVo) {
	   boardService.boardDelete(boardVo);
	   
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("redirect:/Board/List?menu_id=" + boardVo.getMenu_id());
	   return mv;
   }
      
}
