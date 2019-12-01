package com.soft.learn.util;

import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public class ResultUtil {

	/**
	 * 将 pagerinfo 对象转为Layui 表格所需格式
	 * @param pager
	 * @return
	 */
	public static PageGrid ok(PageInfo<?> pager) {
		PageGrid grid = new PageGrid();
		grid.setCode(0);
		grid.setMsg("success");
		grid.setCount(pager.getTotal());
		grid.setData(pager.getList());
		return grid;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <T> Map<String, Object> ok(T t){
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("code", "0");
		r.put("msg", "success");
		r.put("obj", t);
		return r;
	}
	/**
	 * @return
	 */
	public static Map<String, Object> ok(){
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("code", "0");
		r.put("msg", "success");
		return r;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, Object> fail(){
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("code", "1");
		r.put("msg", "fail");
		return r;
	}
}
