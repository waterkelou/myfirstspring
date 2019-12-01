package com.soft.learn.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBootContextUtil implements ApplicationContextAware{

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		context = arg0;
	}
	
	/**
	 * 根据类获取容器中对象
	 * @param t
	 * @return
	 */
	public static <T> T getBean(Class<T> t) {
		return context.getBean(t);
	}
	
	/**
	 * 
	 * @param name
	 * @param t
	 * @return
	 */
	public static <T> T getBean(String name,Class<T> t) {
		return context.getBean(name, t);
	}
	
	/**
	 * 根据名称获取容器中对象
	 * @param name
	 * @return
	 */
	public static Object getBean(String name){
        return context.getBean(name);
    }
	
}
