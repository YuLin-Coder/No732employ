package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 部门表的实体类
public class Dept {
	private String deptid = "D" + VeDate.getStringId(); // 生成主键编号
	private String deptname; // 部门名称
	private String manager; // 负责人
	private String addtime; // 创建日期
	private String memo; // 备注

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return this.toJsonString();
	}

	// 直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("deptid", this.deptid); // 主键编号
		jsonString.put("deptname", this.deptname); // 部门名称
		jsonString.put("manager", this.manager); // 负责人
		jsonString.put("addtime", this.addtime); // 创建日期
		jsonString.put("memo", this.memo); // 备注
		return jsonString.toString();
	}

}
