package com.hzit.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Bigtype;
import com.hzit.ssm.service.BigTypeService;

@Controller
public class BigTypeController {	
		@Autowired
		private BigTypeService typeService;
		@RequestMapping("/selectBigtype.do")
		public String selectBigtype(Model model) {
			List<Bigtype> bigList= typeService.selectBigtype();
			model.addAttribute("bigList",bigList);
			return "index";
		}
		
		@RequestMapping("/selectBigtype1.do")
		public String selectBigtype1(Model model) {
			List<Bigtype> bigList= typeService.selectBigtype();
			model.addAttribute("bigList",bigList);
			return "showPro";
		}
		
		@RequestMapping("/selectBigtype2.do")
		public String selectBigtype2(Model model) {
			List<Bigtype> bigList= typeService.selectBigtype();
			model.addAttribute("bigList",bigList);
			return "searchResult";
		}
		
		@RequestMapping("/selectBigtype3.do")
		public String selectBigtype3(Model model) {
			List<Bigtype> bigList= typeService.selectBigtype();
			model.addAttribute("bigList",bigList);
			return "newInput";
		}
}
