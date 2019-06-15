package com.hzit.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Input;
import com.hzit.ssm.service.InputService;

@Controller
@RequestMapping("/input")
public class InputController {

	@Autowired
	private InputService inputService;
	
	@RequestMapping("/insert.do")
	public String insert(Input input,Integer pid) {
		inputService.insert(input);
		return"forward:/updateCount.do?id="+pid+"&count="+input.getPcount();
	}
	
	@RequestMapping("/selectAll.do")
	public String selectAll(Model model) {
		List<Input> list=inputService.selectAll();
		model.addAttribute("ilist",list);
		return "searchInput";
	}
	
	@RequestMapping("/selectByName.do")
	public String selectByName(Model model) {
		List<Input> list=inputService.selectByName();
		if(list==null) {
    		model.addAttribute("msg", "数据加载不到请重试");
    	}else {
    		model.addAttribute("ilist",list);
    	}
    	return "searchInputResult";
	}
}
