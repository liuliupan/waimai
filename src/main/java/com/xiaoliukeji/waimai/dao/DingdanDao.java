package com.xiaoliukeji.waimai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Order;

/**
 * 购物车订单相关Dao层
 * @author fengjie
 * @time 2016-1-16
 */
@MapperScan
public interface DingdanDao {

	/**
	 *添加到购物车
	 */
	public Integer addgouwuche(@Param("gk_dlname") String gk_dlname, @Param("wp_code") String wp_code, @Param("wp_name") String wp_name, @Param("remark") String remark);

	public List<Gouwuche> findGouwucheByName(@Param("gk_dlname") String gk_dlname);

	public Integer jianshaowupin(@Param("gk_dlname") String gk_dlname,@Param("wp_num") String wp_num, @Param("wp_code") String wp_code);

	public Integer zengjiawupin(@Param("gk_dlname") String gk_dlname,@Param("wp_num") String wp_num, @Param("wp_code") String wp_code);

	public Integer xiadanxinxi(@Param("guke_dlname") String guke_dlname, @Param("order_mjdz") String order_mjdz, @Param("order_mjphone") String order_mjphone,
			@Param("order_mjname") String order_mjname, @Param("order_mjliuyan") String order_mjliuyan);
	
	public Integer gukeWupin(@Param("gk_dlname") String gk_dlname, @Param("wp_code") String wp_code);
	
	public Integer upgwcxinxi(@Param("gk_dlname") String gk_dlname, @Param("gk_xinxi") String gk_xinxi);
	
	public Integer addorder(@Param("guke_dlname") String guke_dlname, @Param("order_code") String order_code
			, @Param("order_total") String order_total, @Param("order_chuangkou") String order_chuangkou
			, @Param("order_des") String order_des, @Param("order_mjliuyan") String order_mjliuyan
			, @Param("order_mjname") String order_mjname, @Param("order_mjphone") String order_mjphone
			, @Param("order_mjdz") String order_mjdz, @Param("sh_code") String sh_code
			);
	public Integer deletegwcbyname(@Param("gk_dlname") String gk_dlname);
	
	//快递员根据自己所属的商户来查询自己的订单，因为快递员的地址和商户的地址，我的订单中有商户的地址，这样就全部的可以搞定了
	public List<Order> selectorder(@Param("sh_code") String sh_code);
	
	
}
