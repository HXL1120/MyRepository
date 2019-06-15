package com.hzit.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.BigTypeMapper;
import com.hzit.ssm.pojo.Bigtype;

@Service
@Transactional
public class BigTypeService {
	@Autowired
	private  BigTypeMapper btm;
	public List<Bigtype> selectBigtype(){
	    	return btm.selectBigtype();
	   	}
}
