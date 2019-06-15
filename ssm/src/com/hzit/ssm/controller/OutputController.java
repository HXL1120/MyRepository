package com.hzit.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Output;
import com.hzit.ssm.service.OutputService;

@Controller
@RequestMapping("/output")
public class OutputController {
	
	@Autowired
	private OutputService outputService;
	
	@RequestMapping("/insert.do")
	public String insert(Output output,Integer pid) {
		outputService.insert(output);
		System.out.println(pid);
		return "forward:/updateCount1.do?id="+pid+"&pcount="+output.getPcount();
	}
	
	
	@RequestMapping("/selectAll.do")
	public String selectAll(Model model) {
		List<Output> list=outputService.selectAll();
		model.addAttribute("olist",list);
		return "searchOutput";
	}

	@RequestMapping("/selectByName.do")
	public String selectByName(Model model) {
		List<Output> list=outputService.selectByName();
		if(list==null) {
    		model.addAttribute("msg", "数据加载不到请重试");
    	}else {
    		model.addAttribute("olist",list);
    	}
    	return "searchOutputResult";
	}
}
