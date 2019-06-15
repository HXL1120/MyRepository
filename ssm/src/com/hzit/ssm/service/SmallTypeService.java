package com.hzit.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.SmallTypeMapper;
import com.hzit.ssm.pojo.Smalltype;

@Service
@Transactional
public class SmallTypeService {
	
	@Autowired
	private SmallTypeMapper sm;
	public List<Smalltype> selectByBid(Integer bid) {
		return sm.selectByBid(bid);
	}

}
