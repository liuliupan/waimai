package com.xiaoliukeji.waimai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.xiaoliukeji.waimai.entity.User;

/**
 * 菜单管理Dao层
 * @author fengjie
 * @time 2016-1-16
 */
@MapperScan
public interface SysDao {

	/**
	 *  根据用户名查找用户
	 * @param operatorAccout
	 */
	public List findAllUser();
	//注册
	public Integer zhuce(@Param("gk_dlname") String name, @Param("gk_dlpwd") String pwd);
	
	public List<User> finduserbyname(@Param("gk_dlname") String name);

}
