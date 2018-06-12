package com.xiaoliukeji.waimai.entity;

/**
 * 
* @ClassName: Dazhidian 
* @Description: 商户楼栋实体
* @author  liupan 
* @date 2017年6月28日 上午10:19:13 
* @version V1.0
 */
public class ShanghuLoudong {
	/*
	 `sh_id` int(11) NOT NULL COMMENT '商户编号',
	`sh_name` varchar(32) DEFAULT NULL COMMENT '商户名称',
	`sh_daima` varchar(16) DEFAULT NULL COMMENT '商户代码，参照sys_zhenjie表得到编码',
	`sh_location` varchar(64) DEFAULT NULL COMMENT '商户地址',
	`sh_jingdu` varchar(64) DEFAULT NULL COMMENT '经度',
	`sh_weidu` varchar(64) DEFAULT NULL COMMENT '纬度',
	`sh_jingwei` varchar(64) DEFAULT NULL COMMENT '商户精度',
	`sh_remark` varchar(64) DEFAULT NULL COMMENT '商户备注',
	 */

	private int sh_id;
	private String sh_name;
	private String sh_daima;
	private String sh_location;
	private String sh_jingdu;
	private String sh_weidu;
	private String sh_jingwei;
	private String sh_remark;

	public int getSh_id() {
		return sh_id;
	}

	public void setSh_id(int sh_id) {
		this.sh_id = sh_id;
	}

	public String getSh_name() {
		return sh_name;
	}

	public void setSh_name(String sh_name) {
		this.sh_name = sh_name;
	}

	public String getSh_daima() {
		return sh_daima;
	}

	public void setSh_daima(String sh_daima) {
		this.sh_daima = sh_daima;
	}

	public String getSh_location() {
		return sh_location;
	}

	public void setSh_location(String sh_location) {
		this.sh_location = sh_location;
	}

	public String getSh_jingdu() {
		return sh_jingdu;
	}

	public void setSh_jingdu(String sh_jingdu) {
		this.sh_jingdu = sh_jingdu;
	}

	public String getSh_weidu() {
		return sh_weidu;
	}

	public void setSh_weidu(String sh_weidu) {
		this.sh_weidu = sh_weidu;
	}

	public String getSh_jingwei() {
		return sh_jingwei;
	}

	public void setSh_jingwei(String sh_jingwei) {
		this.sh_jingwei = sh_jingwei;
	}

	public String getSh_remark() {
		return sh_remark;
	}

	public void setSh_remark(String sh_remark) {
		this.sh_remark = sh_remark;
	}

}
