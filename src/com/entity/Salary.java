package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 员工薪资表的实体类
public class Salary {
	private String salaryid = "S" + VeDate.getStringId(); // 生成主键编号
	private String sno; // 薪资单号
	private String employid; // 员工
	private String basic; // 基本工资
	private String attend; // 考勤工资
	private String reward; // 奖惩工资
	private String others; // 其他工资
	private String total; // 总计
	private String yearx; // 年月
	private String memo; // 备注
	private String realname; // 映射数据
	private Employ employ;// 多对一映射类

	public String getSalaryid() {
		return salaryid;
	}

	public void setSalaryid(String salaryid) {
		this.salaryid = salaryid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getAttend() {
		return attend;
	}

	public void setAttend(String attend) {
		this.attend = attend;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getYearx() {
		return yearx;
	}

	public void setYearx(String yearx) {
		this.yearx = yearx;
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
		jsonString.put("salaryid", this.salaryid); // 主键编号
		jsonString.put("sno", this.sno); // 薪资单号
		jsonString.put("employid", this.employid); // 员工
		jsonString.put("basic", this.basic); // 基本工资
		jsonString.put("attend", this.attend); // 考勤工资
		jsonString.put("reward", this.reward); // 奖惩工资
		jsonString.put("others", this.others); // 其他工资
		jsonString.put("total", this.total); // 总计
		jsonString.put("yearx", this.yearx); // 年月
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Employ", this.employ); // 多对一映射类
		jsonString.put("realname", this.realname); // 映射数据
		return jsonString.toString();
	}

}
