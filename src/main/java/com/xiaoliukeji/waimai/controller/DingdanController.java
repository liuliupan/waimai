package com.xiaoliukeji.waimai.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoliukeji.waimai.common.alipay.DirectPayService;
import com.xiaoliukeji.waimai.entity.Chuangkou;
import com.xiaoliukeji.waimai.entity.Gouwuche;
import com.xiaoliukeji.waimai.entity.Shanghu;
import com.xiaoliukeji.waimai.entity.User;
import com.xiaoliukeji.waimai.service.DingdanService;
import com.xiaoliukeji.waimai.service.KuaidiService;

@Controller
@RequestMapping("/dingdan")
public class DingdanController {
	@Autowired
	DingdanService service;
	@Autowired
	KuaidiService kdservice;
	
	//添加到购物车
	@ResponseBody
	@RequestMapping("/addgouwuche")
	public String addgouwuche(HttpServletRequest request, String wp_code, String wp_name, String remark) {
		try {
			User user=(User)request.getSession().getAttribute("user");
			String ck_code = wp_code.substring(0, wp_code.length()-2);//窗口编码，你不是同一个窗口的，我不让你加入购物车
			//我应该在这里不让你加入购物车里面去的
			//我用用户名去查询购物车，我的购物车要是同一家商户的，否则我就不让你加入，必须保证窗口的号码是一致的
			List<Gouwuche> gouwuches = service.findGouwucheByName(user.getGk_dlname());
			//购物车里为空的时候，我就直接的加入进去，不为空的时候，我就查是不是和我是一个窗口买的
			if(gouwuches.size()==0){
				Integer addnum = service.addgouwuche(user.getGk_dlname(), wp_code, wp_name, remark);
				return "1";
			}else{
				gouwuches = service.findGouwucheByName(user.getGk_dlname());
				Iterator<Gouwuche> iterator = gouwuches.iterator();
				while(iterator.hasNext()){
					String wp=iterator.next().getWp_code();
					String ck = wp.subSequence(0, wp.length()-2).toString();
					if(ck_code.equals(ck)){
						Integer addnum = service.addgouwuche(user.getGk_dlname(), wp_code, wp_name, remark);
						return addnum.toString();
					}else{
						return "-1";
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据用户名查询购物车
	@ResponseBody
	@RequestMapping("/findGouwucheByName")
	public List<Gouwuche> findGouwucheByName(HttpServletRequest request, String dlname) {
		try {
			User user=(User)request.getSession().getAttribute("user");
			List<Gouwuche> gouwuches = service.findGouwucheByName(user.getGk_dlname());
//			Iterator<Gouwuche> iterator = gouwuches.iterator();
//			String ck_code=null;
//			String ck_codecompare=null;
//			//现在是想办法遍历里面所有的ck_code。但是如果这样写了之后
//			for(int i =0;i<gouwuches.size();i++){
//				if(i==0){
//					ck_code = gouwuches.get(i).getCk_code();
//				}
//				ck_codecompare = gouwuches.get(i).getCk_code();
//				if(!ck_code.equals(ck_codecompare)){
//					List<Gouwuche> list=new ArrayList<Gouwuche>();
//					Gouwuche error=new Gouwuche();
//					error.setCk_code("1");
//					list.add(error);
//					return  list;
//				}
//			}
			
			return  gouwuches;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//减少购物车物品
	@ResponseBody
	@RequestMapping("/jianshaowupin")
	public String jianshaowupin(HttpServletRequest request, String wp_num, String wp_code) {
		Integer addnum = null;
		User user=(User)request.getSession().getAttribute("user");
		
		try {
			if ("0".equals(wp_num)) {
				return "-1";
			} else if("1".equals(wp_num)){
				//删除该记录,因为你购物车里为0了，我当然要删除你的这条记录啊。。。
				
			}else{
				Integer num = Integer.parseInt(wp_num) - 1;
				
				wp_num = num.toString();
				addnum = service.jianshaowupin(user.getGk_dlname(),wp_num, wp_code);
			}
			return addnum.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//增加购物车物品
	@ResponseBody
	@RequestMapping("/zengjiawupin")
	public String zengjiawupin(HttpServletRequest request, String wp_num, String wp_code) {
		try {
			User user=(User)request.getSession().getAttribute("user");
			Integer num = Integer.parseInt(wp_num) + 1;
			wp_num = num.toString();
			Integer addnum = service.jianshaowupin(user.getGk_dlname(),wp_num, wp_code);
			return addnum.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * dizhi:$("shouhuodizhi").val(),
			tel:$("tel").val(),
			xingming:$("xingming").val(),
			shouhuorenliuyan:$("shouhuorenliuyan").val(),
	 */

	
	
	@RequestMapping("/fukuan")
	public ModelAndView fukuan(HttpServletRequest request, String dizhi, String tel, String xingming, String liuyan) throws Exception, IOException {
		//得到用户名
		User user=(User)request.getSession().getAttribute("user");
		dizhi= new String(request.getParameter("dizhi").getBytes("ISO8859-1"),"UTF-8");
		tel= new String(request.getParameter("tel").getBytes("ISO8859-1"),"UTF-8");
		xingming= new String(request.getParameter("xingming").getBytes("ISO8859-1"),"UTF-8");
		liuyan= new String(request.getParameter("liuyan").getBytes("ISO8859-1"),"UTF-8");
		
		//得到购物车的信息，得到总共多少钱,我要查的只是我加入购物车的，并不是我已经付款的，后面会加上未付款的状态是1，顾客付款后是2
		List<Gouwuche> gouwuches = findGouwucheByName(request,user.getGk_dlname());//得到购物车未付款的信息
//		List<Gouwuche> weigoumai=new ArrayList<>();
//		for(Gouwuche gouwuche:gouwuches){
//			int gwc_id = gouwuche.getGwc_id();
//			String gwc_status = gouwuche.getGwc_status();
//			if("1".equals(gwc_status)){
//				weigoumai.add(gouwuche);
//			}
//			
//			service.u
//		}
//		gouwuches=weigoumai;
		String wp_code = gouwuches.get(0).getWp_code();//用物品code，可以得到窗口的所有的信息了
	
	
		
		
		
		
		
		
		Iterator<Gouwuche> goumaiwupins = gouwuches.iterator();
		//总金额，付给支付宝的
		Float total = (float) 0.0;
		//总描述，付给支付宝的，还有上面的一个收货人留言也是传给支付宝的。但是我也要传值给我自己的订单表啊
		StringBuilder miaoshu = new StringBuilder();//StringBuilder miaoshu = null;爆出空指针了，呵呵
		
		
		while (goumaiwupins.hasNext()) {
			Gouwuche wupin = goumaiwupins.next();
			//得到了购物车里的物品，那么我就要计算了，要根据物品的编号得到得到商家和楼层和窗口的号码，这样就方便快递员去拿货了
			//我要对货物分食堂，分楼层，分窗口，很简单我只要穿了一个人的dlname和窗口的编码我就可以作为中间表。那么我去拿货就是人员和物品的归类。就能拿到是哪个窗口
			//的了，
			/**
			 * 我得到物品后就直接的删除了算了
			 */
			Integer delnum = service.deletegwcbyname(user.getGk_dlname());
			
			
			//得到总价
			String wp_name = wupin.getWp_name();//String wp_name = goumaiwupins.next().getWp_name();  //每次都next到下一次去了。这是不对的
			String wp_price = wp_name.split(":")[1];
			String wp_num = wupin.getWp_num();//数量
			//					String total=((Integer.parseInt(wp_price))*(Integer.parseInt(wp_num))).toString();
			Float sigletotal = (Float.parseFloat(wp_price)) * (Float.parseFloat(wp_num));
			total = total + sigletotal;
			//得到物品描述
			miaoshu.append(wp_name + "*" + wp_num + "--");
		}
		
		//描述
		String order_des = miaoshu.toString();
		//我把客户的订单的信息全部都放到购物车的描述字段中去
		String xinxi=order_des+"#"+dizhi+"#"+tel+"#"+liuyan;//信息是不需要加
		//这里应该是把订单的数据全部的插入到订单表中去的，等会再订单表中在加上一个快递员的名字，那么这个订单是哪个快递员来送货的就一目了然了
		service.upgwcxinxi(user.getGk_dlname(),xinxi);//不应该去更新购物车的信息啊，而应该是
		
		//钱
		String totalfee = total.toString();
		//total.toString();
		//生成订单号码  日期+用户名字
		String order_code = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + user.getGk_dlname();//+new Random().nextInt(100);
		
		
		
		
		
		//购物车下单的窗口，我拿到窗口的编码之后，我怎么知道在哪里购买呢//要得到地点，楼层，窗口的名字
		String ck_code = wp_code.substring(0, wp_code.length()-2);
		int length = ck_code.length();
		//楼层
		String louceng = ck_code.substring(length-2,length);
		//商户
		String sh_code = ck_code.substring(0, length-4);//42010603010101 420106030
		//窗口名字
		List<Chuangkou> chuangkouname = kdservice.chuangkouname(ck_code);
		List<Shanghu> shanghuname = kdservice.shanghuname(sh_code);
		//把名字全部都写进窗口中去
		 Iterator<Shanghu> iterator2 = shanghuname.iterator();
		 Iterator<Chuangkou> iterator3 = chuangkouname.iterator();
		 StringBuilder sb = new StringBuilder();
		 Shanghu next=new Shanghu();
		 Chuangkou next1=new Chuangkou();  
		while(iterator2.hasNext()){
			next = iterator2.next();
		}
		String sh_name = next.getSh_name();
		sb.append(sh_name);
		sb.append("#"+louceng);
		while(iterator3.hasNext()){
			next1 = iterator3.next();
		}
		String ck_ckname = next1.getCk_ckname();
		sb.append("#"+ck_ckname);
		String ck_addr=sb.toString();
		// String dizhi, String tel, String xingming, String liuyan

		Integer addordernum = service.addorder(user.getGk_dlname(), order_code, totalfee, ck_addr, order_des,liuyan, xingming, tel, dizhi,sh_code);
		
		//下面就是去支付宝里面去买单的，买单后还要把购物车里的东西删除掉，简单粗暴，我也不需要里面的记录了
		
		
		
		
		
		
		//下面是去支付宝去付款的。。。............................................
		//其实订单的这一块，我还是要得到支付宝的交易的单号，方便今后查找，我手机里面就有支付宝的号码了
		DirectPayService directPayService = new DirectPayService();
		Map<String, String> params = directPayService.getRequestDataByDirectPay(order_code, order_des, totalfee, liuyan);

		request.setAttribute("params", params);
		request.setAttribute("requestUrl", DirectPayService.direct_alipay_gateway);

		//			request.getRequestDispatcher("/waimai/WEB-INF/manager/pay.jsp").forward(request, response);
		//			return "redirect:http://localhost:8080/waimai/WEB-INF/manager/pay.jsp";//这里不能用重定向，会不会暴露数据
		ModelAndView mv = new ModelAndView("pay");//这里就那个能把支付宝传来的值都弄到pay.jsp页面中去
		
		
		return mv;
	}

	/** 接收支付宝返回的参数  */
	@RequestMapping("/redirectPayResult")
	public ModelAndView jieshouzhifubao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** 即时到账同步通知  */
		/** 商户订单号 */
		String out_trade_no = request.getParameter("out_trade_no");
		/** 支付宝交易流水号 */
		String trade_no = request.getParameter("trade_no");
		/** 交易状态 */
		String trade_status = request.getParameter("trade_status");
		/** 买家支付宝账号 */
		String buyer_email = request.getParameter("buyer_email");
		/** 买家PID */
		String buyer_id = request.getParameter("buyer_id");
		/** 通知时间 */
		String notify_time = request.getParameter("notify_time");

		try {
			//把上面的几个值存进数据库中去。insert into alipay

			System.out.println("商户订单号 : " + out_trade_no);
			System.out.println("支付宝交易流水号  : " + trade_no);
			System.out.println("交易状态 : " + trade_status);
			System.out.println("买家支付宝账号: " + buyer_email);
			System.out.println("买家PID : " + buyer_id);
			System.out.println("通知时间 : " + notify_time);

			String tip = "交易失败!";
			/** 
			 * 判断交易是否成功 
			 * TRADE_FINISHED : 普通即时到账的交易成功状态
			 * TRADE_SUCCESS : 开通了高级即时到账或机票分销产品后的交易成功状态
			 */
			if (trade_status.equals("TRADE_SUCCESS") || trade_status.equals("TRADE_FINISHED")) {
				/** 商户的业务逻辑程序代码 */
				//把上面的几个值存进数据库中去。insert into alipay
				tip = "交易成功,半小时之内为您送餐上门!";

			}
			request.setAttribute("tip", tip);
			ModelAndView mv = new ModelAndView("main");
			return mv;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
