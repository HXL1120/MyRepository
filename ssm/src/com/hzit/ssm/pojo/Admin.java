package com.hzit.ssm.pojo;

import org.springframework.stereotype.Component;

@Component("admin")
public class Admin {

	private int id;
	private String name;
	private String pwd;
	private int state;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Admin() {
	}

	public Admin(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("被回收了");
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", state=" + state + "]";
	}
	
}
