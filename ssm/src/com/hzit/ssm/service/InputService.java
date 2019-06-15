package com.hzit.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.InputMapper;
import com.hzit.ssm.pojo.Input;

@Service
@Transactional
public class InputService {
	
	@Autowired
	private InputMapper im;
	
	public List<Input> selectAll(){
		return im.selectAll();
	}

	public int insert(Input input) {
		return im.insert(input);
	}

	public List<Input> selectByName() {
		return im.selectByName();
	}
	
	

}
