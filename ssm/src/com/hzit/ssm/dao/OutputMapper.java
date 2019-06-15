package com.hzit.ssm.dao;

import java.util.List;

import com.hzit.ssm.pojo.Output;

public interface OutputMapper {

	public List<Output> selectAll();

	public int insert(Output output);

	public List<Output> selectByName();

}
