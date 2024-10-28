package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 员工奖惩表的实体类
public class Rewards {
	private String rewardsid = "R" + VeDate.getStringId(); // 生成主键编号
	private String employid; // 员工
	private String cate; // 奖惩类型
	private String reason; // 奖惩原因
	private String resultx; // 处理意见
	private String addtime; // 奖惩日期
	private String manager; // 经手人
	private String memo; // 备注
	private String realname; // 映射数据
	private Employ employ;// 多对一映射类

	public String getRewardsid() {
		return rewardsid;
	}

	public void setRewardsid(String rewardsid) {
		this.rewardsid = rewardsid;
	}

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getResultx() {
		return resultx;
	}

	public void setResultx(String resultx) {
		this.resultx = resultx;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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
		jsonString.put("rewardsid", this.rewardsid); // 主键编号
		jsonString.put("employid", this.employid); // 员工
		jsonString.put("cate", this.cate); // 奖惩类型
		jsonString.put("reason", this.reason); // 奖惩原因
		jsonString.put("resultx", this.resultx); // 处理意见
		jsonString.put("addtime", this.addtime); // 奖惩日期
		jsonString.put("manager", this.manager); // 经手人
		jsonString.put("memo", this.memo); // 备注
		jsonString.put("Employ", this.employ); // 多对一映射类
		jsonString.put("realname", this.realname); // 映射数据
		return jsonString.toString();
	}

}
