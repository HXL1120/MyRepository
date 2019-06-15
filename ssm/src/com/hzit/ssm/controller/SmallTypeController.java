package com.hzit.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.hzit.ssm.pojo.Smalltype;

import com.hzit.ssm.service.SmallTypeService;

@Controller
@RequestMapping("/smalltype")
public class SmallTypeController {

	@Autowired
	private SmallTypeService service;
	@RequestMapping("/selectByBid.do")
	public void selectByBid(Integer bid,HttpServletResponse response){
		List<Smalltype> small_list = service.selectByBid(bid);
		//System.out.println("sssss:" + small_list.size());
		JSONArray array = new JSONArray(); //创建json数组
		for(Smalltype small : small_list){
			JSONObject jobj = new JSONObject();//json对象
			try {
				jobj.put("sid", small.getId());
				jobj.put("sname", small.getName());
				array.add(jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println("fff:" + array.toString());
			//向页面返回内容
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
