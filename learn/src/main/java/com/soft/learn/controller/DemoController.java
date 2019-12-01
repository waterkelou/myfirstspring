package com.soft.learn.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.learn.bean.Demo;
import com.soft.learn.service.DemoService;
import com.soft.learn.util.PageGrid;
import com.soft.learn.util.ResultUtil;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService service;
	
	/**
	 * 表格列表界面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/demo/index";
	}
	
	/**
	 * 查看详情界面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/toView")
	public String toView(Map<String, Object> model, String id) {
		Demo demo = this.service.findById(id);
		model.put("demo", demo);
		return "/demo/view";
	}
	/**
	 * 新增或者编辑页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/toAddOrUpdate")
	public String toAddOrUpdate(Map<String, Object> model, String id) {
		if(StringUtils.isNotEmpty(id)) {
			Demo demo = this.service.findById(id);
			model.put("demo", demo);
		}
		return "/demo/add";
	}
	/**
	 * 新增或者修改
	 * @param demo
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Map<String, Object> addOrUpdate(Demo demo) {
		if(StringUtils.isEmpty(demo.getId())) {
			return this.service.insert(demo)  > 0 ? ResultUtil.ok() : ResultUtil.fail();
		}else {
			return this.service.updateWithAttributeCondition(demo)  > 0 ? ResultUtil.ok() : ResultUtil.fail();
		}
	}
	/**
	 * 根据ID 删除行
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> del(String id){
		return this.service.deleteById(id) > 0 ? ResultUtil.ok() : ResultUtil.fail();
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public PageGrid findByPage(Demo condition ,int page, int limit) {
		return this.service.findByPage(condition, page, limit);
	}
	
}
