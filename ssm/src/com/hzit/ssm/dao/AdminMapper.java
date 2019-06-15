package com.hzit.ssm.dao;

import java.util.List;

import com.hzit.ssm.pojo.Admin;

public interface AdminMapper {
	
	public int insertAdmin(Admin admin);
	
	public Admin selectOne(Admin admin);

	public List<Admin> selectadminAll();

	public int deleteadmin(Integer id);

	public int updateAdmin(Admin admin);

	public int forwardupdateAdmin(Integer id);

	public Admin findById(Integer id);

}
