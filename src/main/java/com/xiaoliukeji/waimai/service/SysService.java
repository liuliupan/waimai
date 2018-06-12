package com.xiaoliukeji.waimai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoliukeji.waimai.common.BaseService;
import com.xiaoliukeji.waimai.dao.SysDao;
import com.xiaoliukeji.waimai.entity.User;

/**
 * 菜单管理Service层
 * @author fengjie
 * @time 2016-1-16
 */
@Service
public class SysService extends BaseService {

	@Autowired
	SysDao dao;

	/**
	 * 查询用户名是否重复
	 */
	public  List<User>  finduserbyname(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.finduserbyname(name);
		//System.out.println(resultList);
		
	}
	/**
	 * 顾客注册
	 */
	public Integer zhuce(String dlname, String dlpwd) throws Exception {
		return dao.zhuce(dlname, dlpwd);
	}

}
