package com.soft.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @description 兼容war包部署方式 
 * @author HCN
 */

@SpringBootApplication
@MapperScan("com.soft.learn.mapper") 
public class AppStarter extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppStarter.class);
    }
	
	public static void main(String[] args) {
		 SpringApplication.run(AppStarter.class, args);
	}

}
