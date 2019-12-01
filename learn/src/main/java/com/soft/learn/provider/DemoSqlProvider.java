package com.soft.learn.provider;

import org.apache.commons.lang.StringUtils;

import com.soft.learn.bean.Demo;

/**
 * 
 * @descriptionSQL语句
 * @author Administrator
 * 
 */
public class DemoSqlProvider {
	
	/**
	 * @description 插入数据
	 * @author Administrator
	 * @param bean
	 * @return                                                                                                           
	 */
	public String insertSql(Demo bean){
		return "INSERT INTO demo(id,user_name,sex,hobby,remark) VALUES(#{id},#{userName},#{sex},#{hobby},#{remark})";
	}

	/**
	 * @description 根据ID删除数据
	 * @author Administrator
	 * @param id 
	 * @return
	 */
	public String deleteByIdSql(String id){
		return "DELETE FROM demo WHERE id = #{id}";
	}

	/**
	 * @description 根据传入对象的属性条件进行部分字段更新（一般用于业务处理中更改部分字段）
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	public String updateByAttributeConditionSql(Demo bean){
		StringBuffer sb = new StringBuffer("UPDATE demo SET ");
		if(StringUtils.isNotEmpty(bean.getId())){
			sb.append("id = #{id},");
		}
		if(StringUtils.isNotEmpty(bean.getUserName())){
			sb.append("user_name = #{userName},");
		}
			sb.append("sex = #{sex},");
		if(StringUtils.isNotEmpty(bean.getHobby())){
			sb.append("hobby = #{hobby},");
		}
		if(StringUtils.isNotEmpty(bean.getRemark())){
			sb.append("remark = #{remark},");
		}
		if(sb.toString().endsWith(",")){
			sb = sb.deleteCharAt(sb.lastIndexOf(","));
		}
		sb.append(" WHERE id = #{id}");
		return sb.toString();
	}

	
	/**
	 * @description 查询所有数据SQL
	 * @author Administrator
	 * @param bean 传入空对象则查询所有
	 * @return
	 */
	public String findAllSql(Demo bean){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM demo WHERE 1=1 ");
		sb.append(this.whereCondition(bean));
		sb.append("ORDER BY ID DESC");
		return sb.toString();
	}

	/**
	 * @description 根据ID查询数据
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public String findByIdSql(String id){
		return "SELECT * FROM  demo WHERE id = #{id}";
	}

	
	/**
	 * @description 封装查询条件
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	private String whereCondition(Demo bean){
		StringBuffer sb = new StringBuffer();
		if(bean != null){
			if(StringUtils.isNotEmpty(bean.getId())){
				sb.append("AND id = #{id} ");
			}
			if(StringUtils.isNotEmpty(bean.getUserName())){
				sb.append("AND user_name = #{userName} ");
			}
			if(StringUtils.isNotEmpty(bean.getSex())) {
				sb.append("AND sex = #{sex} ");
			}
			if(StringUtils.isNotEmpty(bean.getHobby())){
				sb.append("AND hobby = #{hobby} ");
			}
			if(StringUtils.isNotEmpty(bean.getRemark())){
				sb.append("AND remark = #{remark} ");
			}
		}
		return sb.toString();
	}
}
