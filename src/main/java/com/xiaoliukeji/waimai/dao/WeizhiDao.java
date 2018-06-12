package com.xiaoliukeji.waimai.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.xiaoliukeji.waimai.entity.Dazhidian;

/**
 * 菜单管理Dao层
 * @author fengjie
 * @time 2016-1-16
 */
@MapperScan
public interface WeizhiDao {

	/**
	 * @param operatorAccout
	 */
	public List findAllQuxian(String city_id);

	public List findAllJiedao(String qucode);

	public List findAllDazhidian(String jiedaocode);

	public List findFujinShanghu(BigDecimal jingdu, BigDecimal weidu);

	public List<Dazhidian> findDingweiDetail(String point_code);//因为要在java代码里面转，所以就是这样的

	public List findFujinChuangkou(String loudongcode);

	//根据窗口编号查询菜单
	public List findCaidanByCk(String ckcode);
	//更新顾客的大致位置定位点
	public Integer gukedazhiweizhi(@Param("gk_dlname") String gk_dlname, @Param("gk_wzcode") String gk_wzcode, @Param("gk_dzwz") String gk_dzwz);
	
}
