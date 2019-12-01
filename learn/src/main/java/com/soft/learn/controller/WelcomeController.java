package com.soft.learn.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.learn.util.SpringBootContextUtil;

/**
 * 首页： 输入地址： http://127.0.0.1:8080/learn 访问即可
 * @author HCN
 *
 */
@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return  SpringBootContextUtil.getBean(IndexController.class).index(model);
	}
}
