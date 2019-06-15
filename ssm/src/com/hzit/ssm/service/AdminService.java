package com.hzit.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hzit.ssm.dao.AdminMapper;
import com.hzit.ssm.pojo.Admin;

@Component("as")
@Transactional
public class AdminService {

	@Resource
	//AdminDao admindao;
	AdminMapper am;
	public void insert(Admin admin) {

		System.out.println("service insert");
		am.insertAdmin(admin);
		System.out.println("ssssssssssssss");

	}
	
	public int deleteadmin(Integer id) {
		return am.deleteadmin(id);
	}
	
	public Admin selectOne(Admin admin){
		return am.selectOne(admin);
	}

	public List<Admin> selectadminAll() {
		return am.selectadminAll();
	}

	public int insertAdmin(Admin admin) {
		return am.insertAdmin(admin);
	}

	public int updateAdmin(Admin admin) {
		return am.updateAdmin(admin);
		
	}

	public int forwardupdateAdmin(Integer id) {
		return am.forwardupdateAdmin(id);
		
	}

	public Admin findById(Integer id) {
		return am.findById(id);
	}
}
