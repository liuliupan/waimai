package com.xiaoliukeji.waimai.entity;

public class Chuangkou {
	/*
	 * `ck_id` int(11) NOT NULL COMMENT '窗口编号',
  `lc_id` int(11) DEFAULT NULL COMMENT '楼层编号',
  `ck_bianma` varchar(32) DEFAULT NULL COMMENT '窗口代码',
  `ck_ckname` varchar(50) DEFAULT NULL COMMENT '窗口名称',
  `ck_bossname` varchar(50) DEFAULT NULL COMMENT '窗口老板姓名',
  `ck_bossphone` varchar(32) DEFAULT NULL COMMENT '窗口老板电话',
  `ck_bosssex` varchar(2) DEFAULT NULL COMMENT '窗口老板性别',
  `ck_bossage` varchar(6) DEFAULT NULL COMMENT '窗口老板年龄',
  `ck_remark` varchar(128) DEFAULT NULL COMMENT '窗口备注',
	 */
	private int ck_id;
	private String lc_id;
	private String ck_bianma;
	private String ck_ckname;
	private String ck_bossname;
	private String ck_bossphone;
	private String ck_bosssex;
	private String ck_bossage;
	private String ck_remark;
	public int getCk_id() {
		return ck_id;
	}
	public void setCk_id(int ck_id) {
		this.ck_id = ck_id;
	}
	public String getLc_id() {
		return lc_id;
	}
	public void setLc_id(String lc_id) {
		this.lc_id = lc_id;
	}
	public String getCk_bianma() {
		return ck_bianma;
	}
	public void setCk_bianma(String ck_bianma) {
		this.ck_bianma = ck_bianma;
	}
	public String getCk_ckname() {
		return ck_ckname;
	}
	public void setCk_ckname(String ck_ckname) {
		this.ck_ckname = ck_ckname;
	}
	public String getCk_bossname() {
		return ck_bossname;
	}
	public void setCk_bossname(String ck_bossname) {
		this.ck_bossname = ck_bossname;
	}
	public String getCk_bossphone() {
		return ck_bossphone;
	}
	public void setCk_bossphone(String ck_bossphone) {
		this.ck_bossphone = ck_bossphone;
	}
	public String getCk_bosssex() {
		return ck_bosssex;
	}
	public void setCk_bosssex(String ck_bosssex) {
		this.ck_bosssex = ck_bosssex;
	}
	public String getCk_bossage() {
		return ck_bossage;
	}
	public void setCk_bossage(String ck_bossage) {
		this.ck_bossage = ck_bossage;
	}
	public String getCk_remark() {
		return ck_remark;
	}
	public void setCk_remark(String ck_remark) {
		this.ck_remark = ck_remark;
	}
	
	
}
