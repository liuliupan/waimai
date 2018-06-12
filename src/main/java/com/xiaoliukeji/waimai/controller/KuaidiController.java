package com.xiaoliukeji.waimai.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Order;
import com.xiaoliukeji.waimai.entity.User;
import com.xiaoliukeji.waimai.service.DingdanService;
import com.xiaoliukeji.waimai.service.KuaidiService;

@Controller
@RequestMapping("/kuaidi")
public class KuaidiController {
	@Autowired
	KuaidiService service;
	@Autowired
	DingdanService ddservice;
	
	//快递员查询商品是哪个窗口的
	@ResponseBody
	@RequestMapping("/weichuli")
	public List<Order> kuandibuy(HttpServletRequest request, String dizhi, String tel, String xingming, String shouhuorenliuyan) throws Exception, IOException {
		//快递员登陆之后，就有他负责的食堂，那么他就可以拿到商户的code。
		User user=(User)request.getSession().getAttribute("user");
		//只有当用户的状态是3的时候才是快递员
		List<Order> selectorder=new ArrayList<>();
		if("3".equals(user.getGk_status())){
			selectorder = ddservice.selectorder(user.getGk_wzcode());
			Iterator<Order> iterator = selectorder.iterator();
			while(iterator.hasNext()){
				Order order = iterator.next();
				String order_status = order.getOrder_status();
				if("1".equals(order_status)){
					order.setOrder_status("顾客已经付款");
				}else if("2".equals(order_status)){
					order.setOrder_status("快递员已经购买");
				}else if("3".equals(order_status)){
					order.setOrder_status("顾客已经签收");
				}
			}
		}
		return selectorder;
	}
	
	
	//快递员去窗口去下单
	@ResponseBody
	@RequestMapping("/goumai")
	public Integer goumai(HttpServletRequest request, String order_id, String order_status) throws Exception, IOException {
		//快递员登陆之后，就有他负责的食堂，那么他就可以拿到商户的code。
		User user=(User)request.getSession().getAttribute("user");
		Integer num =0;
		if("顾客已经付款".equals(order_status)){
			num = service.goumai(order_id,"2",user.getGk_dlname());//我快递员就盯着这个食堂了，我就专门来做这个食堂的,快递员只要一买单之后，就绑定了订单了
		}else if("快递员已经购买".equals(order_status)){
			num = service.goumai(order_id,"3",user.getGk_dlname());
		}
		//快递员下了单之后，在购物车里绑定了顾客和快递员了
		//Integer num1 = service.goumaibangding(order_id,user.getGk_dlname());//我快递员就绑定这个下单的了
		//我可以根据用户名去订单表中的地址
		
		return num;
	}
	
}
