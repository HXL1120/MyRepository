package com.hzit.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class mybatistest {

	public static void main(String[] args) throws IOException {
		//测试mybatis
		String resource = "mybatis-config.xml";
		//读取MyBatis配置文件以及加载映射文件
		InputStream is = Resources.getResourceAsStream(resource);
		//构造会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建会话对象
		SqlSession session = sessionFactory.openSession();
		//System.out.println(session);
/*		List list=session.selectList("com.hzit.ssm.AdminMapper.findAll");
		System.out.println(list);
		
		Admin admin=session.selectOne("com.hzit.ssm.AdminMapper.findById",4);
		System.out.println(admin);
		
		List list2=session.selectList("com.hzit.ssm.AdminMapper.findAllByLike","强");
		//System.out.println(list2);
		
		int pageSize=3;//每页显示的记录数（可由用户输入）
		int currentPage=2;//当前页（用户选择的 默认第一页）
		//分页查询
		List list3=session.selectList("com.hzit.ssm.AdminMapper.findAll",null,new RowBounds((currentPage-1)*pageSize,pageSize));
		//System.out.println(list3);
		
		
		Admin admin=new Admin();
		admin.setName("张良");
		admin.setPwd("2222");
		admin.setState(1);
		
		int r =session.insert("com.hzit.ssm.AdminMapper.insertAdmin",admin);
		//如果是增删改就必须提交事务
		System.out.println(r);
		
		int r = session.delete("com.hzit.ssm.AdminMapper.deleteAdmin",2);	
		System.out.println(r);*/
		
		
		
		/*Admin admin=session.selectOne("com.hzit.ssm.AdminMapper.findById",4);
		
		admin.setPwd("2222");
		admin.setState(1);
		
		int r=session.update("com.hzit.ssm.AdminMapper.updateAdmin",admin);
		System.out.println(r);*/
		
		List bigtype =session.selectList("com.hzit.ssm.AdminMapper.findAll");
		System.out.println(bigtype);
		
		session.commit();
		session.close();
	}

}
