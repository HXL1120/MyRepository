package com.hzit.ssm.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.ProductsMapper;
import com.hzit.ssm.pojo.Products;

@Service
@Transactional
public class ProductsService {
    @Autowired
    private ProductsMapper pm;
     
    public List<Products> selectAll(RowBounds rowbounds){
    	return pm.selectAll(rowbounds);
    }
    //查询表中总记录数
    public int selectCount() {
    	return pm.selectCount();
    }
    //根据名称模糊查询
    public List<Products> selectByName(String keyword){
    	return pm.selectByName(keyword);
    }
    
    public Products selectById(Integer id){
    	return pm.selectById(id);
    }
	public int updateCount(Integer count, Integer id) {
		return pm.updateCount(count,id);
		
	}
	public int updateCount1(Integer count, Integer id) {
		return pm.updateCount1(count,id);
		
	}
	public int updatePro(Integer wvalue,String units, Integer pid) {
		return pm.updatePro(wvalue,units,pid);
		
	}
	public int insertpro(Products products) {
		return pm.insertpro(products);
		
	}
}
