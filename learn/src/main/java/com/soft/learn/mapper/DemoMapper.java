package com.soft.learn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.soft.learn.bean.Demo;
import com.soft.learn.provider.DemoSqlProvider;


/**
 *
 *@description mapper层
 *@author Administrator
 *
 */
@Mapper
public interface DemoMapper {
	
	/**
	 * @description 插入数据
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	@InsertProvider(type = DemoSqlProvider.class, method = "insertSql")
	public int insert(Demo bean);

	/**
	 * 
	 * @description 更具ID删除数据
	 * @author Administrator
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = DemoSqlProvider.class, method = "deleteByIdSql")
	public int deleteById(String id);

	/**
	 * @description 根据传入对象的属性条件进行部分字段更新（一般用于业务处理中更改部分字段）
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	@UpdateProvider(type = DemoSqlProvider.class, method = "updateByAttributeConditionSql")
	public int updateWithAttributeCondition(Demo bean);
	
	/**
	 * @description 查询所有数据
	 * @author Administrator
	 * @param bean
	 * @return
	 */
	@SelectProvider(type = DemoSqlProvider.class, method = "findAllSql")
	@Results({
		@Result(column="id", property="id"),
		@Result(column="user_name", property="userName"),
		@Result(column="sex", property="sex"),
		@Result(column="hobby", property="hobby"),
		@Result(column="remark", property="remark"),
	})
	public List<Demo> findAll(Demo bean);


	/**
	 * @description 根据ID查询对象
	 * @author Administrator
	 * @param id
	 * @return
	 */
	@SelectProvider(type = DemoSqlProvider.class, method = "findByIdSql")
	@Results({
		@Result(column="id", property="id"),
		@Result(column="user_name", property="userName"),
		@Result(column="sex", property="sex"),
		@Result(column="hobby", property="hobby"),
		@Result(column="remark", property="remark"),
	})
	public Demo findById(String id);
}
