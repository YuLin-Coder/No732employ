package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 职务表的实体类
public class Duty {
	private String dutyid = "D" + VeDate.getStringId(); // 生成主键编号
	private String dutyname; // 职务名称
	private String addtime; // 创建日期
	private String memo; // 备注

	

	public String getDutyid() {
		return dutyid;
	}

	public void setDutyid(String dutyid) {
		this.dutyid = dutyid;
	}

	public String getDutyname() {
		return dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
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
		jsonString.put("dutyid", this.dutyid); // 主键编号
		jsonString.put("dutyname", this.dutyname); // 职务名称
		jsonString.put("addtime", this.addtime); // 创建日期
		jsonString.put("memo", this.memo); // 备注
		return jsonString.toString();
	}

}
