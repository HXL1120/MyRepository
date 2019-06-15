package com.hzit.ssm.dao;

import java.util.List;

import com.hzit.ssm.pojo.Smalltype;

public interface SmallTypeMapper {

	List<Smalltype> selectByBid(Integer bid);

}
