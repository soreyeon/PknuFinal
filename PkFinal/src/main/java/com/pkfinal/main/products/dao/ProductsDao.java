package com.pkfinal.main.products.dao;

import java.util.HashMap;
import java.util.List;

import com.pkfinal.main.products.vo.ProductVo;

public interface ProductsDao {

	List<ProductVo> selectProducts(HashMap<String, Object> map);

}
