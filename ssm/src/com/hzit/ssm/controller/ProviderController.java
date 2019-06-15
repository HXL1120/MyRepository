package com.hzit.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Provider;
import com.hzit.ssm.service.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	@RequestMapping("/selectinputAll.do")
	public String selectAll(Model model) {
		List<Provider> prolist= providerService.selectAll();
		model.addAttribute("proList",prolist);
		return "input";
	}
	
	@RequestMapping("/selectoutputAll.do")
	public String selectAll1(Model model) {
		List<Provider> prolist= providerService.selectAll();
		model.addAttribute("proList",prolist);
		return "output";
	}
	
	@RequestMapping("/selectproAll.do")
	public String selectproAll(Model model) {
		List<Provider> prolist= providerService.selectAll();
		model.addAttribute("proList",prolist);
		return "forward:/selectBigtype1.do";
	}

}
