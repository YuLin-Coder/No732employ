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
import com.entity.Duty;
import com.github.pagehelper.Page;
import com.service.DutyService;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/duty", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class DutyController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private DutyService dutyService;

	// 预处理 获取基础参数
	@GetMapping(value = "createDuty.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createDuty() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	// 新增职务
	@PostMapping(value = "insertDuty.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertDuty(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Duty duty = new Duty();
		duty.setDutyname(obj.getString("dutyname")); // 为职务名称赋值
		duty.setAddtime(obj.getString("addtime")); // 为创建日期赋值
		duty.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.dutyService.insertDuty(duty);
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

	// 按主键删除一个职务
	@GetMapping(value = "deleteDuty.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteDuty(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.dutyService.deleteDuty(id);
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

	// 按主键批量删除职务
	@PostMapping(value = "deleteDutyByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteDutyByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String dutyid : ids) {
			num += this.dutyService.deleteDuty(dutyid);
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

	// 修改职务
	@PostMapping(value = "updateDuty.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateDuty(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Duty duty = this.dutyService.getDutyById(obj.getString("dutyid")); // 获取object中dutyid字段
		duty.setDutyname(obj.getString("dutyname")); // 为职务名称赋值
		duty.setAddtime(obj.getString("addtime")); // 为创建日期赋值
		duty.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.dutyService.updateDuty(duty);
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

	// 查询全部职务数据 在下拉菜单中显示
	@GetMapping(value = "getAllDuty.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Duty> getAllDuty() {
		return this.dutyService.getAllDuty();
	}

	// 通过AJAX在表格中显示职务数据
	@GetMapping(value = "getDutyByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getDutyByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Duty> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Duty> list = this.dutyService.getAllDuty();
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

	// 按主键查询职务数据
	@GetMapping(value = "getDutyById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Duty getDutyById(String id) {
		Duty duty = this.dutyService.getDutyById(id);
		return duty;
	}

}
