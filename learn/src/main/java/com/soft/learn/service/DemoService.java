package com.soft.learn.service;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soft.learn.bean.Demo;
import com.soft.learn.mapper.DemoMapper;
import com.soft.learn.util.PageGrid;
import com.soft.learn.util.ResultUtil;


/**
 * @description service层
 * @author Administrator
 */
@Service
public class DemoService {
	
	@Autowired
	private DemoMapper mapper;


	
	/**
	 * @description 新增对象
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	public int insert(Demo bean) {
		if (bean != null) {
			bean.setId(null); //ID 自增情况下设置为null
			return mapper.insert(bean);
		}
		return 0;
	}
	
	/**
	 * @description 根据ID删除对象
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public int deleteById(String id){
		
		System.err.println("--->"+id);
		if(StringUtils.isNotEmpty(id)){
			String[] ids = id.split(",");
			int i = 0;
			for (String string : ids) {
				i += mapper.deleteById(string);
			}
			return i;
		}
		return 0;
	}
	
	/**
	 * @description 根据传入对象的属性条件进行部分字段更新（一般用于业务处理中更改部分字段）
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	public int updateWithAttributeCondition(Demo bean){
		if(bean != null){
			return mapper.updateWithAttributeCondition(bean);
		}
		return 0;
	}
	
	/**
	 * @description 分页查询
	 * @author Administrator
	 * @param bean 查询对象
	 * @return pager 分页对象
	 */
	public PageGrid findByPage(Demo condition,int page, int limit){
		PageHelper.startPage(page, limit);
		PageInfo<Demo> pager = new PageInfo<Demo>(this.mapper.findAll(condition));
		return ResultUtil.ok(pager);
	}
	
	/**
	 * @description 根据ID查询对象
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public Demo findById(String id){
		if(StringUtils.isNotEmpty(id)){
			return mapper.findById(id);
		}
		return null;
	}
	
}
