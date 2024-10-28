package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 员工表的实体类
public class Employ {
	private String employid = "E" + VeDate.getStringId(); // 生成主键编号
	private String eno; // 员工号
	private String realname; // 姓名
	private String sex; // 性别
	private String deptid; // 部门
	private String dutyid; // 职务
	private String xueli; // 学历
	private String graduate; // 毕业院校
	private String workdate; // 入职日期
	private String memo; // 备注
	private String deptname; // 映射数据
	private String dutyname; // 映射数据
	private Dept dept;// 多对一映射类
	private Duty duty;// 多对一映射类

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDutyid() {
		return dutyid;
	}

	public void setDutyid(String dutyid) {
		this.dutyid = dutyid;
	}

	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDutyname() {
		return dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return this.toJsonString();
	}

	// 直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("employid", this.employid); // 主键编号
		jsonString.put("eno", this.eno); // 员工号
		jsonString.put("realname", this.realname); // 姓名
		jsonString.put("sex", this.sex); // 性别
		jsonString.put("deptid", this.deptid); // 部门
		jsonString.put("dutyid", this.dutyid); // 职务
		jsonString.put("xueli", this.xueli); // 学历
		jsonString.put("graduate", this.graduate); // 毕业院校
		jsonString.put("workdate", this.workdate); // 入职日期
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Dept", this.dept); // 多对一映射类
		jsonString.put("Duty", this.duty); // 多对一映射类
		jsonString.put("deptname", this.deptname); // 映射数据
		jsonString.put("dutyname", this.dutyname); // 映射数据
		return jsonString.toString();
	}

}
