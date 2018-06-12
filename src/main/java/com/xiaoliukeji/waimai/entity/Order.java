package com.xiaoliukeji.waimai.entity;

public class Order {
	
	/*
	 * `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号，不能自己生成要用下单时间和顾客id来生成在加上随机数',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单流水号,唯一，时间+1000随机数',
  `sh_code` varchar(16) DEFAULT NULL COMMENT '商户的code，方便快递员去拿货',
  `order_total` decimal(5,1) DEFAULT NULL COMMENT '订单金额',
  `order_chuangkou` varchar(64) DEFAULT NULL COMMENT '订单在哪个窗口购买',
  `order_des` varchar(64) DEFAULT NULL COMMENT '总价是怎么算出来的',
  `created` date DEFAULT NULL COMMENT '订单创建时间',
  `order_status` varchar(10) DEFAULT '1' COMMENT '订单状态,1未付款，2已付款，3配送中',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '订单支付类型，1支付宝，2微信，3，货到付款',
  `guke_dlname` varchar(16) DEFAULT NULL COMMENT '买家登陆名',
  `order_mjliuyan` varchar(150) DEFAULT NULL COMMENT '买家留言，比如多加点饭',
  `order_mjphone` varchar(50) DEFAULT NULL COMMENT '买家电话',
  `order_mjname` varchar(50) DEFAULT NULL COMMENT '买家称呼',
  `order_mjdz` varchar(100) DEFAULT NULL COMMENT '买家详细地址',
  `remark` varchar(150) DEFAULT NULL COMMENT '备注',
	 */
	private int order_id;
	private String order_code;
	private String sh_code;
	private String order_total;
	private String order_chuangkou;
	private String order_des;
	private String created;
	private String order_status;
	private String pay_type;
	private String guke_dlname;
	private String order_mjliuyan;
	private String order_mjphone;
	private String order_mjname;
	private String order_mjdz;
	private String remark;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getSh_code() {
		return sh_code;
	}
	public void setSh_code(String sh_code) {
		this.sh_code = sh_code;
	}
	public String getOrder_total() {
		return order_total;
	}
	public void setOrder_total(String order_total) {
		this.order_total = order_total;
	}
	public String getOrder_chuangkou() {
		return order_chuangkou;
	}
	public void setOrder_chuangkou(String order_chuangkou) {
		this.order_chuangkou = order_chuangkou;
	}
	public String getOrder_des() {
		return order_des;
	}
	public void setOrder_des(String order_des) {
		this.order_des = order_des;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getGuke_dlname() {
		return guke_dlname;
	}
	public void setGuke_dlname(String guke_dlname) {
		this.guke_dlname = guke_dlname;
	}
	public String getOrder_mjliuyan() {
		return order_mjliuyan;
	}
	public void setOrder_mjliuyan(String order_mjliuyan) {
		this.order_mjliuyan = order_mjliuyan;
	}
	public String getOrder_mjphone() {
		return order_mjphone;
	}
	public void setOrder_mjphone(String order_mjphone) {
		this.order_mjphone = order_mjphone;
	}
	public String getOrder_mjname() {
		return order_mjname;
	}
	public void setOrder_mjname(String order_mjname) {
		this.order_mjname = order_mjname;
	}
	public String getOrder_mjdz() {
		return order_mjdz;
	}
	public void setOrder_mjdz(String order_mjdz) {
		this.order_mjdz = order_mjdz;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
