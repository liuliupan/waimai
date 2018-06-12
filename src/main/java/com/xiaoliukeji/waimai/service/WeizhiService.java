package com.xiaoliukeji.waimai.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoliukeji.waimai.common.BaseService;
import com.xiaoliukeji.waimai.dao.WeizhiDao;
import com.xiaoliukeji.waimai.entity.Dazhidian;
import com.xiaoliukeji.waimai.entity.ShanghuLoudong;

/**
 * 菜单管理Service层
 * @author fengjie
 * @time 2016-1-16
 */
@Service
public class WeizhiService extends BaseService {

	@Autowired
	WeizhiDao dao;

	/**
	 * 查看区
	 */
	public List findAllQuxian(String city_id) throws Exception {
		// TODO Auto-generated method stub
		List resultList = dao.findAllQuxian(city_id);
		//System.out.println(resultList);
		return resultList;
	}

	/**
	 * 查看街道
	 */
	public List findAllJiedao(String id) throws Exception {
		// TODO Auto-generated method stub
		List resultList = dao.findAllJiedao(id);
		//System.out.println(resultList);
		return resultList;
	}

	/**
	 * 查看大致点
	 */
	public List findAllDazhidian(String id) throws Exception {
		// TODO Auto-generated method stub
		List resultList = dao.findAllDazhidian(id);
		//System.out.println(resultList);
		return resultList;
	}

	/**
	 * 查看定位点的详细信息
	 */
	public List<Dazhidian> findDingweiDetail(String id) throws Exception {
		List<Dazhidian> resultList = dao.findDingweiDetail(id);
		//System.out.println(resultList);
		return resultList;
	}

	/**
	 * 查看附近商家(楼栋)
	 */
	public List<ShanghuLoudong> findFujinsj(String jd, String wd) throws Exception {
		BigDecimal jingdu = new BigDecimal(jd);
		BigDecimal weidu = new BigDecimal(wd);
		//设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)   
		//bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);   
		List<ShanghuLoudong> resultList = dao.findFujinShanghu(jingdu, weidu);
		//System.out.println(resultList);
		return resultList;
	}

	/**
	 * 查看附近商家(窗口)
	 */
	public List findFujinChuangkou(String loudongcode) throws Exception {
		List resultList = dao.findFujinChuangkou(loudongcode);
		return resultList;
	}

	/**
	 * find菜单by窗口
	 */
	public List findCaidanByCk(String ckcode) throws Exception {
		List resultList = dao.findCaidanByCk(ckcode);
		return resultList;
	}
	
	/**
	 * 更新顾客的大致位置
	 */
	public Integer gukedazhiweizhi(String dlname, String gk_wzcode, String gk_dzwz) throws Exception {
		return dao.gukedazhiweizhi(dlname, gk_wzcode, gk_dzwz);
	}
	
}
