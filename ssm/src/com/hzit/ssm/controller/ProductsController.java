package com.hzit.ssm.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzit.ssm.pojo.Products;
import com.hzit.ssm.service.ProductsService;
import com.hzit.ssm.util.PageUtils;

@Controller
public class ProductsController {
	
	private PageUtils pageUtils=new PageUtils();
    @Autowired
    private ProductsService productsService;
    
    @RequestMapping("/selectAll.do")
    public String selectAll(Model model,Integer cp) {
    	
    	pageUtils.setPageSize(20);
    	if(cp==null) {
    		pageUtils.setCurrentPage(1);
    	}else {
    		pageUtils.setCurrentPage(cp);
    	}
    	
    	pageUtils.setTotal(productsService.selectCount());
    	
    	int pageTotal=pageUtils.getTotal()%pageUtils.getPageSize()==0?
    			pageUtils.getTotal()/pageUtils.getPageSize():
    				pageUtils.getTotal()/pageUtils.getPageSize()+1;
    	pageUtils.setPageTotal(pageTotal);
    	
    	List<Products> list=productsService.selectAll(new RowBounds((pageUtils.getCurrentPage()-1)*pageUtils.getPageSize(),pageUtils.getPageSize()));
    	if(list==null) {
    		model.addAttribute("msg", "数据加载不到请重试");
    		
    	}else {
    		
    		model.addAttribute("p",pageUtils);
    		model.addAttribute("pList",list);
    		model.addAttribute("URL","selectAll.do");
    	}
    	return "forward:/selectBigtype.do";
    }
    
    @RequestMapping("/selectByName.do")
    public String selectByName(String keyword,Model model) {
    	List<Products> list=productsService.selectByName(keyword);
    	if(list==null) {
    		model.addAttribute("msg", "数据加载不到请重试");
    	}else {
    		model.addAttribute("pList",list);
    	}
    	return "forward:/selectBigtype2.do";
    }
    
    //根据ID来检索物料信息
    @RequestMapping("/selectinputById.do")
    public String selectinputById(Integer id,Model model) {
    	//得到pid来查询详细信息
    	Products produts=productsService.selectById(id);
    	model.addAttribute("p",produts);
    	return "forward:/provider/selectinputAll.do";
    }
    
    @RequestMapping("/selectoutputById.do")
    public String selectoutputById(Integer id,Model model) {
    	//得到pid来查询详细信息
    	Products produts=productsService.selectById(id);
    	model.addAttribute("p",produts);
    	return "forward:/provider/selectoutputAll.do";
    }
    
    @RequestMapping("/selectProById.do")
    public String selectProById(Integer id,Model model) {
    	//得到pid来查询详细信息
    	Products produts=productsService.selectById(id);
    	model.addAttribute("p",produts);
    	return "forward:/provider/selectproAll.do";
    }

    
    @RequestMapping("/updateCount.do")
    public String updateCount(Integer id,Integer count) {
    	System.out.println("id:"+id+"count:"+count);
    	productsService.updateCount(count,id);
    	return "forward:/input/selectAll.do";
    }
    
    @RequestMapping("/updateCount1.do")
    public String updateCount1(Integer pid,Integer pcount) {
    	System.out.println("id:"+pid+"count:"+pcount);
    	productsService.updateCount1(pcount,pid);
    	return "forward:/output/selectAll.do";
    }
    
    @RequestMapping("/updatePro.do")
    public String updatePro(Integer id,String units,Integer wvalue) {
    	//System.out.println("id:"+pid+"count:"+wvalue);
    	productsService.updatePro(wvalue,units,id);
    	return "success";//forward:/selectAll.do
    }
    
    @RequestMapping("/forward.do")
    public String forward() {
    	return "forward:/selectBigtype3.do";
    	//return "newInput";
    }
    
    @RequestMapping("/insertpro.do")
    public String insertpro(Products products) {
    	productsService.insertpro(products);
    	return "forward:/selectAll.do";
    }
}
