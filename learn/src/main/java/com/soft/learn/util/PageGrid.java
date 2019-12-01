package com.soft.learn.util;

import java.util.List;

/**
 * 
 * @author HCN Layui table 表格数据格式
 *
 */
public class PageGrid {
	
	private int code = 0; //0 ：成功、 非0 失败
	
	private String msg;
	
	private long count;
	
	private List<?> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
