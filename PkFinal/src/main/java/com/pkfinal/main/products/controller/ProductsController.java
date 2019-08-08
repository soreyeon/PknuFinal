package com.pkfinal.main.products.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pkfinal.main.products.service.ProductsService;
import com.pkfinal.main.products.vo.ProductVo;

@Controller
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	@RequestMapping("/products")
	public ModelAndView home(@RequestParam HashMap<String, Object> map) {
		
		List<ProductVo> list = productsService.selectProducts(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("products", list);
		mv.setViewName("products/pro_main");
		return mv;
	}
}
