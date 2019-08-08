package com.pkfinal.main.products.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkfinal.main.products.dao.ProductsDao;
import com.pkfinal.main.products.vo.ProductVo;

@Service
public class ProductsService implements com.pkfinal.main.products.service.ProductsService {

	@Autowired
	private ProductsDao productsDao;
	
	@Override
	public List<ProductVo> selectProducts(HashMap<String, Object> map) {
		return productsDao.selectProducts(map);
	}

}
