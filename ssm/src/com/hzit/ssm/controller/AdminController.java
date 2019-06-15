package com.hzit.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Admin;
import com.hzit.ssm.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	
	@RequestMapping("/login.do")
	public String selectOne(Admin admin,Model model) {
		
		System.out.println("admin:"+admin.getName());
		
		Admin admin2=as.selectOne(admin);
		
		//System.out.println(admin2);
		
		if(admin2==null) {//表示找不到登录失败
			model.addAttribute("loginError","用户名或密码错误");
			return "forward:/login.jsp";		
		}
		if(admin2.getState()==0) {//表示账户被冻结
			model.addAttribute("loginError","用户被冻结");
			return "forward:/login.jsp";		
		}
		model.addAttribute("admin",admin2);
		return "forward:/selectAll.do";
	}
	
	@RequestMapping("/selectadminAll.do")
	public String selectadminAll(Model model) {
		List<Admin> list=as.selectadminAll();
		model.addAttribute("alist",list);
		return "showAdmin";
	}
	@RequestMapping("/deleteadmin.do")
	public String deleteadmin(Integer id) {
		as.deleteadmin(id);
		return "forward:/selectadminAll.do";
	}
	
	@RequestMapping("/forwardinsertAdmin.do")
    public String forwardinsertAdmin() {
    	return "addAdmin";
    }
	
	
	@RequestMapping("/findById.do")
    public String findById(Model model,Integer id) {
		Admin admin=as.findById(id);
		model.addAttribute("admin",admin);
		return "updateAdmin";
    }
	
	@RequestMapping("/insertAdmin.do")
	public String insertAdmin(Admin admin) {
		as.insertAdmin(admin);
		return "forward:/selectadminAll.do";
	}
	
	@RequestMapping("/updateAdmin.do")
	public String updateAdmin(Admin admin) {
		as.updateAdmin(admin);
		return "forward:/selectadminAll.do";
	}
	
}
