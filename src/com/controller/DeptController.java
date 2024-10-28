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
import com.entity.Dept;
import com.github.pagehelper.Page;
import com.service.DeptService;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/dept", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class DeptController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private DeptService deptService;

	// 预处理 获取基础参数
	@GetMapping(value = "createDept.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createDept() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	// 新增部门
	@PostMapping(value = "insertDept.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertDept(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Dept dept = new Dept();
		dept.setDeptname(obj.getString("deptname")); // 为部门名称赋值
		dept.setManager(obj.getString("manager")); // 为负责人赋值
		dept.setAddtime(obj.getString("addtime")); // 为创建日期赋值
		dept.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.deptService.insertDept(dept);
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

	// 按主键删除一个部门
	@GetMapping(value = "deleteDept.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteDept(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.deptService.deleteDept(id);
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

	// 按主键批量删除部门
	@PostMapping(value = "deleteDeptByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteDeptByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String deptid : ids) {
			num += this.deptService.deleteDept(deptid);
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

	// 修改部门
	@PostMapping(value = "updateDept.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateDept(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Dept dept = this.deptService.getDeptById(obj.getString("deptid")); // 获取object中deptid字段
		dept.setDeptname(obj.getString("deptname")); // 为部门名称赋值
		dept.setManager(obj.getString("manager")); // 为负责人赋值
		dept.setAddtime(obj.getString("addtime")); // 为创建日期赋值
		dept.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.deptService.updateDept(dept);
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

	// 查询全部部门数据 在下拉菜单中显示
	@GetMapping(value = "getAllDept.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Dept> getAllDept() {
		return this.deptService.getAllDept();
	}

	// 通过AJAX在表格中显示部门数据
	@GetMapping(value = "getDeptByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getDeptByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Dept> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Dept> list = this.deptService.getAllDept();
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

	// 按主键查询部门数据
	@GetMapping(value = "getDeptById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Dept getDeptById(String id) {
		Dept dept = this.deptService.getDeptById(id);
		return dept;
	}

}
