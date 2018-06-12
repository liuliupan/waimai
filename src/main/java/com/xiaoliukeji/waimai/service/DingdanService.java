package com.xiaoliukeji.waimai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoliukeji.waimai.common.BaseService;
import com.xiaoliukeji.waimai.dao.DingdanDao;
import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Order;

/**
 * 菜单管理Service层
 * @author fengjie
 * @time 2016-1-16
 */
@Service
public class DingdanService extends BaseService {

	@Autowired
	DingdanDao dao;
	
	/**
	 * 添加购物车
	 */
	public Integer upgwcxinxi(String dlname, String xinxi) throws Exception {
		return dao.upgwcxinxi(dlname, xinxi);
	}
	/**
	 * 添加购物车
	 */
	public Integer addgouwuche(String dlname, String wp_code, String wp_name, String remark) throws Exception {
		return dao.addgouwuche(dlname, wp_code, wp_name, remark);
	}

	/**
	 * 查询订单
	 */
	public List<Order> selectorder(String sh_code) throws Exception {
		return dao.selectorder(sh_code);
	}
	/**
	 * 查询购物车
	 */
	public List<Gouwuche> findGouwucheByName(String dlname) throws Exception {
		return dao.findGouwucheByName(dlname);
	}

	/**
	 * 购物车减少物品 
	 */
	public Integer jianshaowupin(String gk_dlname,String wp_num, String wp_code) throws Exception {
		return dao.jianshaowupin(gk_dlname,wp_num, wp_code);
	}

	/**
	 * 购物车增加物品 
	 */
	public Integer zengjiawupin(String gk_dlname,String wp_num, String wp_code) throws Exception {
		return dao.zengjiawupin(gk_dlname,wp_num, wp_code);
	}

	/**
	 *插入下单信息 
	 */
	public Integer addorder(String gk_dlname,String order_code,  String order_total,  String order_chuangkou
			, String order_des, String order_mjliuyan,  String order_mjname, String order_mjphone
			,  String order_mjdz,String sh_code) throws Exception {
		return dao.addorder(gk_dlname, order_code, order_total, order_chuangkou, order_des, order_mjliuyan
				, order_mjname, order_mjphone, order_mjdz,sh_code);
	}
	
	public Integer deletegwcbyname( String gk_dlname){
		return dao.deletegwcbyname(gk_dlname);
	}
}
