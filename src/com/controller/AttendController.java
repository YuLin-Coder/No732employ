package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.entity.Attend;
import com.github.pagehelper.Page;
import com.service.AttendService;
import com.util.VeDate;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/attend", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class AttendController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private AttendService attendService;

	// 预处理 获取基础参数
	@GetMapping(value = "createAttend.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createAttend() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("today", VeDate.getStringDateShort());
		return map;
	}

	// 新增员工考勤
	@PostMapping(value = "insertAttend.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertAttend(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Attend attend = new Attend();
		attend.setEmployid(obj.getString("employid")); // 为员工赋值
		attend.setWork(obj.getString("work")); // 为考勤状态赋值
		attend.setAddtime(VeDate.getStringDateShort()); // 为日期赋值
		attend.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.attendService.insertAttend(attend);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "保存成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "保存失败");
		}
		return map;
	}

	// 按主键删除一个员工考勤
	@GetMapping(value = "deleteAttend.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteAttend(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.attendService.deleteAttend(id);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "删除失败");
		}
		return map;
	}

	// 按主键批量删除员工考勤
	@PostMapping(value = "deleteAttendByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteAttendByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String attendid : ids) {
			num += this.attendService.deleteAttend(attendid);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "删除失败");
		}
		return map;
	}

	// 修改员工考勤
	@PostMapping(value = "updateAttend.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateAttend(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Attend attend = this.attendService.getAttendById(obj.getString("attendid")); // 获取object中attendid字段
		attend.setEmployid(obj.getString("employid")); // 为员工赋值
		attend.setWork(obj.getString("work")); // 为考勤状态赋值
		attend.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.attendService.updateAttend(attend);
		if (num > 0) {
			map.put("success", true);
			map.put("code", num);
			map.put("message", "修改成功");
		} else {
			map.put("success", false);
			map.put("code", num);
			map.put("message", "修改失败");
		}
		return map;
	}

	// 查询全部员工考勤数据 在下拉菜单中显示
	@GetMapping(value = "getAllAttend.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Attend> getAllAttend() {
		return this.attendService.getAllAttend();
	}

	// 通过AJAX在表格中显示员工考勤数据
	@GetMapping(value = "getAttendByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getAttendByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Attend> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Attend> list = this.attendService.getAllAttend();
		// 返回的map中定义数据格式
		map.put("count", pager.getTotal());
		map.put("total", list.size());
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
		map.put("page", page);
		map.put("limit", limit);
		return map;
	}

	// 按主键查询员工考勤数据
	@GetMapping(value = "getAttendById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Attend getAttendById(String id) {
		Attend attend = this.attendService.getAttendById(id);
		return attend;
	}

}
