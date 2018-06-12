package com.xiaoliukeji.waimai.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoliukeji.waimai.entity.Dazhidian;
import com.xiaoliukeji.waimai.entity.ShanghuLoudong;
import com.xiaoliukeji.waimai.entity.User;
import com.xiaoliukeji.waimai.service.WeizhiService;

@Controller
@RequestMapping("/weizhi")
public class WeizhiController {
	@Autowired
	WeizhiService weizhiService;

	@ResponseBody
	@RequestMapping("/quxian")
	public Object quxian(HttpServletRequest request, String cityid) {
		try {
			List quxians = weizhiService.findAllQuxian("191");
			return quxians;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 2街道
	 */
	@ResponseBody
	@RequestMapping("/jiedao")
	public Object jiedao(HttpServletRequest request, String quid) {
		try {
			List jiedaos = weizhiService.findAllJiedao(quid);
			return jiedaos;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 3大致点
	 */
	@ResponseBody
	@RequestMapping("/dazhidian")
	public Object dazhidian(HttpServletRequest request, String jiedaocode) {
		try {
			List jiedaos = weizhiService.findAllDazhidian(jiedaocode);
			return jiedaos;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 4定位详细信息
	 */
	@ResponseBody
	@RequestMapping("/dingweiDetail")
	public Object dingweiDetail(HttpServletRequest request, String pointcode) {
		try {
			List<Dazhidian> dazhidians = weizhiService.findDingweiDetail(pointcode);
			return dazhidians;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *5. 附近商家
	 */
	@ResponseBody
	@RequestMapping("/fujinsj")
	public Object fujinsj(HttpServletRequest request, String pointcode) {//传进来的是code码，可以有code得到经纬度的
		try {
			//查看定位的详情
			List<Dazhidian> dazhidians = weizhiService.findDingweiDetail(pointcode);
			String jingwei = dazhidians.get(0).getPoint_jingwei();
			//根据大致点经纬度去查询附近的商户，正负两公里范围内的商户，满足这个条件才能去查找附近的商户
			String[] jingweidu = jingwei.split(",");
			String jingdu = jingweidu[0];
			String weidu = jingweidu[1];

			List<ShanghuLoudong> shanghuloudongs = weizhiService.findFujinsj(jingdu, weidu);
			//我要用楼栋去得到每一层的窗口，把结果全部展示给客户去看，
			Iterator<ShanghuLoudong> iterator = shanghuloudongs.iterator();
			List chuangkouTotal = new ArrayList();
			while (iterator.hasNext()) {//直接写shanghuloudongs.iterator().hasNext()居然会报错，看来以后就这么来写了，呵呵
				//得到一栋楼的窗口列表
				List chuangkous = weizhiService.findFujinChuangkou(iterator.next().getSh_daima());
				chuangkouTotal.addAll(chuangkous);
			}

			return chuangkouTotal;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 4定位详细信息
	 */
	@ResponseBody
	@RequestMapping("/caidan")
	public Object findCaidanByCk(HttpServletRequest request, String ckcode) {
		try {
			List caidan = weizhiService.findCaidanByCk(ckcode);
			return caidan;
			//			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//更新顾客的大致位置
	@ResponseBody
	@RequestMapping("/gukedazhiweizhi")
	public String gukedazhiweizhi(HttpServletRequest request, String gk_wzcode, String gk_wzname) {
		try {
			User user=(User)request.getSession().getAttribute("user");
			Integer num = weizhiService.gukedazhiweizhi(user.getGk_dlname(), gk_wzcode, gk_wzname);
			return num.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
