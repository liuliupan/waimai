package com.xiaoliukeji.waimai.entity;

/*
 * `gk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾客编号',
  `gk_dlname` varchar(100) NOT NULL COMMENT '顾客登陆名',
  `gk_dlpwd` varchar(100) NOT NULL COMMENT '顾客登陆密码',
  `gk_dzwz` varchar(200) DEFAULT NULL COMMENT '大致位置枚举值（预计一个区安排十个枚举值）',
  `guke_xingbie` varchar(2) DEFAULT NULL COMMENT '顾客性别',
  `guke_nianling` varchar(6) DEFAULT NULL COMMENT '顾客年龄',
  `gk_phone` varchar(100) DEFAULT NULL COMMENT '顾客手机号码',
  `gk_shnc` varchar(16) DEFAULT NULL COMMENT '顾客送货昵称',
  `gk_zsxm` varchar(16) DEFAULT NULL COMMENT '顾客真实姓名',
  `gk_remark` varchar(200) DEFAULT NULL COMMENT '顾客备注',
  `gk_status` varchar(2) DEFAULT '1' COMMENT '顾客状态，1是可用，2是禁止',
 */
public class User {
	private Integer gk_id;
	private String gk_dlname;
	private String gk_dlpwd;
	private String gk_dzwz;
	private String guke_xingbie;
	private String guke_nianling;
	private String gk_phone;
	private String gk_shnc;
	private String gk_zsxm;
	private String gk_remark;
	private String gk_status;
	private String gk_wzcode;
	private String kdy_name;
	
	public String getKdy_name() {
		return kdy_name;
	}
	public void setKdy_name(String kdy_name) {
		this.kdy_name = kdy_name;
	}
	public String getGk_wzcode() {
		return gk_wzcode;
	}
	public void setGk_wzcode(String gk_wzcode) {
		this.gk_wzcode = gk_wzcode;
	}
	public Integer getGk_id() {
		return gk_id;
	}
	public void setGk_id(Integer gk_id) {
		this.gk_id = gk_id;
	}
	public String getGk_dlname() {
		return gk_dlname;
	}
	public void setGk_dlname(String gk_dlname) {
		this.gk_dlname = gk_dlname;
	}
	public String getGk_dlpwd() {
		return gk_dlpwd;
	}
	public void setGk_dlpwd(String gk_dlpwd) {
		this.gk_dlpwd = gk_dlpwd;
	}
	public String getGk_dzwz() {
		return gk_dzwz;
	}
	public void setGk_dzwz(String gk_dzwz) {
		this.gk_dzwz = gk_dzwz;
	}
	public String getGuke_xingbie() {
		return guke_xingbie;
	}
	public void setGuke_xingbie(String guke_xingbie) {
		this.guke_xingbie = guke_xingbie;
	}
	public String getGuke_nianling() {
		return guke_nianling;
	}
	public void setGuke_nianling(String guke_nianling) {
		this.guke_nianling = guke_nianling;
	}
	public String getGk_phone() {
		return gk_phone;
	}
	public void setGk_phone(String gk_phone) {
		this.gk_phone = gk_phone;
	}
	public String getGk_shnc() {
		return gk_shnc;
	}
	public void setGk_shnc(String gk_shnc) {
		this.gk_shnc = gk_shnc;
	}
	public String getGk_zsxm() {
		return gk_zsxm;
	}
	public void setGk_zsxm(String gk_zsxm) {
		this.gk_zsxm = gk_zsxm;
	}
	public String getGk_remark() {
		return gk_remark;
	}
	public void setGk_remark(String gk_remark) {
		this.gk_remark = gk_remark;
	}
	public String getGk_status() {
		return gk_status;
	}
	public void setGk_status(String gk_status) {
		this.gk_status = gk_status;
	}
	
		

}
