package com.pkfinal.main.products.service;

import java.util.HashMap;
import java.util.List;

import com.pkfinal.main.products.vo.ProductVo;

public interface ProductsService {

	List<ProductVo> selectProducts(HashMap<String, Object> map);
	
}
