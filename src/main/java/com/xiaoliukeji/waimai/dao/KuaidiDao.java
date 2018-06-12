package com.xiaoliukeji.waimai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.xiaoliukeji.waimai.entity.Chuangkou;
import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Shanghu;

/**
 * 购物车订单相关Dao层
 * @author fengjie
 * @time 2016-1-16
 */
@MapperScan
public interface KuaidiDao {

	/**
	 *根据用户名查询物品，并把物品归类，方便快递员去购买物品
	 */
	
	public List<Gouwuche> kuaidibuy(@Param("sh_code") String sh_code);
	/**
	 *快递员购买后，更新购物车的状态
	 */
	
	public Integer goumai(@Param("order_id") String gwc_id,@Param("order_status") String gwc_status,@Param("kdy_name") String kdy_name);
	
	public Integer goumaibangding(@Param("gwc_id") String gwc_id,@Param("kdy_name") String kdy_name);
	
	public List<Chuangkou> chuangkouname(@Param("ck_bianma") String sh_code);
	public List<Shanghu> shanghuname(@Param("sh_daima") String sh_code);
}
