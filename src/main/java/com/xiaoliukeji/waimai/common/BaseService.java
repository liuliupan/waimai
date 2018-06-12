package com.xiaoliukeji.waimai.common;

import org.apache.commons.logging.Log;

/**
 * Service基类
 */
public class BaseService {

	/**
	 * 日志对象.<br>
	 * 此对象在构建所有service的时候会自动被注入数据<br>
	 * see：{@link com.ruiyun.webmanager.common.listener.SpringBeanLoadListener}
	 */
	protected Log log;

	public void setLog(Log log) {
		this.log = log;
	}

}
