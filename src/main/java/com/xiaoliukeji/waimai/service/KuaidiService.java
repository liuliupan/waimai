package com.xiaoliukeji.waimai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoliukeji.waimai.common.BaseService;
import com.xiaoliukeji.waimai.dao.KuaidiDao;
import com.xiaoliukeji.waimai.entity.Chuangkou;
import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Shanghu;

/**
 * 菜单管理Service层
 * @author fengjie
 * @time 2016-1-16
 */
@Service
public class KuaidiService extends BaseService {

	@Autowired
	KuaidiDao dao;
	/**
	 * chaungkou name
	 */
	public List<Chuangkou> chuangkouname(String ck_code) throws Exception {
		return dao.chuangkouname(ck_code);
	}
	/**
	 * shanghu name
	 */
	public List<Shanghu> shanghuname(String sh_code) throws Exception {
		return dao.shanghuname(sh_code);
	}

	/**
	 * 查询购物车
	 */
	public List<Gouwuche> kuaidibuy(String sh_code) throws Exception {
		return dao.kuaidibuy(sh_code);
	}

	/**
	 * 购买
	 */
	public Integer goumai(String id,String status,String name) throws Exception {
		return dao.goumai(id,status,name);
	}
	/**
	 * 购买绑定快递员
	 */
	public Integer goumaibangding(String id,String kdy) throws Exception {
		return dao.goumaibangding(id,kdy);
	}
}
