package com.xiaoliukeji.waimai.entity;

public class Gouwuche {
	/*
	 * 	`gwc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
	  `gk_dlname` varchar(16) DEFAULT NULL COMMENT '顾客登陆名',
	  `wp_name` varchar(16) DEFAULT NULL,
	  `wp_code` varchar(16) DEFAULT NULL COMMENT '物品代码',
	  `wp_num` varchar(10) DEFAULT '1' COMMENT '购物车物品数量',
	  `gwc_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '购物车创建时间,4小时后删除该购物车',
	  `gwc_status` varchar(2) DEFAULT '1' COMMENT '购物车状态',
	  `remark` varchar(200) DEFAULT NULL COMMENT '购物车备注',
	 */
	private int gwc_id;
	private String gk_dlname;
	private String wp_name;
	private String ck_code;
	private String wp_code;
	private String wp_num;
	private String gwc_created;
	private String gwc_status;
	private String remark;
	private String gk_xinxi;
	
	
	

	public String getGk_xinxi() {
		return gk_xinxi;
	}

	public void setGk_xinxi(String gk_xinxi) {
		this.gk_xinxi = gk_xinxi;
	}

	public String getCk_code() {
		return ck_code;
	}

	public void setCk_code(String ck_code) {
		this.ck_code = ck_code;
	}

	public int getGwc_id() {
		return gwc_id;
	}

	public void setGwc_id(int gwc_id) {
		this.gwc_id = gwc_id;
	}

	public String getGk_dlname() {
		return gk_dlname;
	}

	public void setGk_dlname(String gk_dlname) {
		this.gk_dlname = gk_dlname;
	}

	public String getWp_name() {
		return wp_name;
	}

	public void setWp_name(String wp_name) {
		this.wp_name = wp_name;
	}

	public String getWp_code() {
		return wp_code;
	}

	public void setWp_code(String wp_code) {
		this.wp_code = wp_code;
	}

	public String getWp_num() {
		return wp_num;
	}

	public void setWp_num(String wp_num) {
		this.wp_num = wp_num;
	}

	public String getGwc_created() {
		return gwc_created;
	}

	public void setGwc_created(String gwc_created) {
		this.gwc_created = gwc_created;
	}

	public String getGwc_status() {
		return gwc_status;
	}

	public void setGwc_status(String gwc_status) {
		this.gwc_status = gwc_status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
