package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 员工培训表的实体类
public class Trains {
	private String trainsid = "T" + VeDate.getStringId(); // 生成主键编号
	private String employid; // 员工
	private String itemx; // 培训项目
	private String iswork; // 是否脱产
	private String thestart; // 开始日期
	private String theend; // 结束日期
	private String memo; // 备注
	private String realname; // 映射数据
	private Employ employ;// 多对一映射类

	public String getTrainsid() {
		return trainsid;
	}

	public void setTrainsid(String trainsid) {
		this.trainsid = trainsid;
	}

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getItemx() {
		return itemx;
	}

	public void setItemx(String itemx) {
		this.itemx = itemx;
	}

	public String getIswork() {
		return iswork;
	}

	public void setIswork(String iswork) {
		this.iswork = iswork;
	}

	public String getThestart() {
		return thestart;
	}

	public void setThestart(String thestart) {
		this.thestart = thestart;
	}

	public String getTheend() {
		return theend;
	}

	public void setTheend(String theend) {
		this.theend = theend;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Employ getEmploy() {
		return employ;
	}

	public void setEmploy(Employ employ) {
		this.employ = employ;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return this.toJsonString();
	}

	// 直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("trainsid", this.trainsid); // 主键编号
		jsonString.put("employid", this.employid); // 员工
		jsonString.put("itemx", this.itemx); // 培训项目
		jsonString.put("iswork", this.iswork); // 是否脱产
		jsonString.put("thestart", this.thestart); // 开始日期
		jsonString.put("theend", this.theend); // 结束日期
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Employ", this.employ); // 多对一映射类
		jsonString.put("realname", this.realname); // 映射数据
		return jsonString.toString();
	}

}
