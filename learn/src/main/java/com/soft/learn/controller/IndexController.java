package com.soft.learn.controller;

import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页、框架页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	
	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		 Properties props = System.getProperties();
		 String jdkVersion = props.getProperty("java.version");
		 String vmName = props.getProperty("java.vm.name");
		 String osName = props.getProperty("os.name");
		 
		 int kb = 1024;
	     long totalMemory = Runtime.getRuntime().totalMemory() / kb;
	     long freeMemory = Runtime.getRuntime().freeMemory() / kb;
	     long maxMemory = Runtime.getRuntime().maxMemory() / kb;
		 
		 model.put("jdkVersion", jdkVersion);
		 model.put("vmName", vmName);
		 model.put("osName", osName);
		 
		 model.put("totalMemory", totalMemory);
		 model.put("freeMemory", freeMemory);
		 model.put("maxMemory", maxMemory);
		return "index";
	}
}
