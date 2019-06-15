package com.hzit.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.OutputMapper;
import com.hzit.ssm.pojo.Output;

@Service
@Transactional
public class OutputService {
	
	@Autowired
	private OutputMapper om;

	public List<Output> selectAll() {
		return om.selectAll();
	}

	public int insert(Output output) {
		return om.insert(output);
	}

	public List<Output> selectByName() {
		return om.selectByName();
	}

}
