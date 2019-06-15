package com.hzit.ssm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzit.ssm.pojo.Admin;
import com.hzit.ssm.service.AdminService;
import com.hzit.ssm.util.MD5Code;


public class Test {

	public static void main(String[] args) {
		/*Admin a = new Admin();
		a.setName("刘邦");
		a.setPwd("123");
		System.out.println(a);
		a=null;
		//运行垃圾回收器
		System.gc();*/
		//加载spring的配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*Admin admin = (Admin)context.getBean("admin");
		admin.setName("萧何");
		admin.setPwd("123");*/
		//System.out.println(admin);
		
		/*Admin admin2 = (Admin) context.getBean("admin");
		admin2.setName("曹参");
		admin2.setPwd("123456");*/
		//System.out.println(admin==admin2);
		
		//AdminDao dao=(AdminDao) context.getBean("admindao");
		//dao.insert();
		
		Admin admin=new Admin();
		admin.setName("项羽");
		MD5Code md5code=new MD5Code();
		admin.setPwd(md5code.getMD5ofStr("444444"));
		admin.setState(1);
		
		
		Admin admin2 = new Admin();
		admin2.setName("范增2");
		admin2.setPwd(md5code.getMD5ofStr("888888"));
		admin2.setState(1);
		
		
		AdminService adminservice = (AdminService)context.getBean("as");
		adminservice.insert(admin);
		//adminservice.delete();
	}

}
