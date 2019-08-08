package com.pkfinal.main.products.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pkfinal.main.products.dao.ProductsDao;
import com.pkfinal.main.products.vo.ProductVo;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductVo> selectProducts(HashMap<String, Object> map) {
		sqlSession.selectList("List", map);
		return (List<ProductVo>) map.get("result");
	}

}
