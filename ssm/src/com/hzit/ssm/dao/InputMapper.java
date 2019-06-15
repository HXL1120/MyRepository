package com.hzit.ssm.dao;

import java.util.List;

import com.hzit.ssm.pojo.Input;

public interface InputMapper {

	public List<Input> selectAll();
	
	public int insert(Input input);

	public List<Input> selectByName();

}
