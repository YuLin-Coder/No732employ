package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 员工考勤表的实体类
public class Attend {
	private String attendid = "A" + VeDate.getStringId(); // 生成主键编号
	private String employid; // 员工
	private String work; // 考勤状态
	private String addtime; // 日期
	private String memo; // 备注
	private String realname; // 映射数据
	private Employ employ;// 多对一映射类

	public String getAttendid() {
		return attendid;
	}

	public void setAttendid(String attendid) {
		this.attendid = attendid;
	}

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
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
		jsonString.put("attendid", this.attendid); // 主键编号
		jsonString.put("employid", this.employid); // 员工
		jsonString.put("work", this.work); // 考勤状态
		jsonString.put("addtime", this.addtime); // 日期
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Employ", this.employ); // 多对一映射类
		jsonString.put("realname", this.realname); // 映射数据
		return jsonString.toString();
	}

}
