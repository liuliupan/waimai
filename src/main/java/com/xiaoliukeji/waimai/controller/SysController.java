package com.xiaoliukeji.waimai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoliukeji.waimai.common.md5mysql.MD5Util;
import com.xiaoliukeji.waimai.entity.User;
import com.xiaoliukeji.waimai.service.SysService;

@Controller
@RequestMapping("/system")
public class SysController {
	@Autowired
	SysService service;

	//注册用户
	@ResponseBody
	@RequestMapping("/zhuce")
	public String zhuce(HttpServletRequest request, String username, String pwd) {
		try {
			List<User>  num = service.finduserbyname(username);
			if(num.size()==0){
				pwd = MD5Util.md5Hex(pwd);
				Integer addnum = service.zhuce(username, pwd);
				return addnum.toString();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-1";//写null，前面会报错
	}
	//用户登陆
	@ResponseBody
	@RequestMapping("/denglu")
	public String denglu(HttpServletRequest request, String username, String pwd) {
		try {
			List<User>  num = service.finduserbyname(username);
			if(num.size()==1){
				User user = num.iterator().next();
				if(MD5Util.md5Hex(pwd).equals(user.getGk_dlpwd())){//如果密码是一样的，那么就登陆成功了
					//登陆成功了就把user放进session中去，到时候就都可以来取了
					HttpSession session = request.getSession();  
			        session.setAttribute("user", user);  
					return "1";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	@ResponseBody
//	@RequestMapping("/test")
//	public List findallUser() {
//		try {
//			return service.findAllUser();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@RequestMapping("/mainpage")
//	public String mainpage(HttpServletRequest request) {
//		try {
//			List users = service.findAllUser();
//			return "main";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
	
}
