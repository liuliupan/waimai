package com.xiaoliukeji.waimai.entity;

/**
 * 
* @ClassName: Dazhidian 
* @Description: 顾客的大致定位点实体
* @author  liupan 
* @date 2017年6月28日 上午10:19:13 
* @version V1.0
 */
public class Dazhidian {
	/*
	 *  `point_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标记点编号',
	`zhenjie_id` int(11) DEFAULT NULL COMMENT '镇街编号',
	`point_name` varchar(16) DEFAULT NULL COMMENT '标记点名称',
	`point_code` varchar(16) DEFAULT NULL COMMENT '标记点代码',
	`point_jingwei` varchar(64) DEFAULT NULL COMMENT '标记点经纬度,以，分隔',
	`point_status` varchar(64) DEFAULT NULL COMMENT '状态，1是商户，2是顾客',
	`point_dizhi` varchar(64) DEFAULT NULL COMMENT '地址',
	`point_beizhu` varchar(64) DEFAULT NULL COMMENT '标记点备注',
	 */

	private int zhenjie_id;
	private String point_name;
	private String point_code;
	private String point_jingwei;
	private String point_status;
	private String point_dizhi;
	private String point_beizhu;

	public int getZhenjie_id() {
		return zhenjie_id;
	}

	public void setZhenjie_id(int zhenjie_id) {
		this.zhenjie_id = zhenjie_id;
	}

	public String getPoint_name() {
		return point_name;
	}

	public void setPoint_name(String point_name) {
		this.point_name = point_name;
	}

	public String getPoint_code() {
		return point_code;
	}

	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}

	public String getPoint_jingwei() {
		return point_jingwei;
	}

	public void setPoint_jingwei(String point_jingwei) {
		this.point_jingwei = point_jingwei;
	}

	public String getPoint_status() {
		return point_status;
	}

	public void setPoint_status(String point_status) {
		this.point_status = point_status;
	}

	public String getPoint_dizhi() {
		return point_dizhi;
	}

	public void setPoint_dizhi(String point_dizhi) {
		this.point_dizhi = point_dizhi;
	}

	public String getPoint_beizhu() {
		return point_beizhu;
	}

	public void setPoint_beizhu(String point_beizhu) {
		this.point_beizhu = point_beizhu;
	}

}
