package com.hzit.ssm.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hzit.ssm.pojo.Admin;

public class AdminDao extends SqlSessionDaoSupport{
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminDao [admin=" + admin + "]";
	}

	public void insert(Admin admin){
		this.getSqlSession().insert("com.hzit.ssm.AdminMapper.insertAdmin", admin);
		//int n=10/0;
		//System.out.println("dao insert：" + admin);
	}
	
}
