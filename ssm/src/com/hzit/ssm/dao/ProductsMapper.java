package com.hzit.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hzit.ssm.pojo.Products;

public interface ProductsMapper {
	
    public List<Products> selectAll(RowBounds rowbounds);
    public int selectCount();
    public List<Products> selectByName(String keyword);
    public Products selectById(int id);
	public int updateCount(Integer count, Integer id);
	public int updateCount1(Integer count, Integer id);
	public int updateCount2(Integer count, Integer id);
	
	public int updatePro(Integer wvalue,String units, Integer pid);
	public int insertpro(Products products);
    
}
