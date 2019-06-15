package com.hzit.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.ProviderMapper;
import com.hzit.ssm.pojo.Provider;

@Service
@Transactional
public class ProviderService {
	 @Autowired
	private  ProviderMapper pm;
	 public List<Provider> selectAll(){
	    	return pm.selectAll();
	    }
	

}
