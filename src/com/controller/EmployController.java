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
import com.entity.Employ;
import com.github.pagehelper.Page;
import com.service.EmployService;
import com.util.VeDate;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/employ", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class EmployController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private EmployService employService;

	// 预处理 获取基础参数
	@GetMapping(value = "createEmploy.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createEmploy() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eno", "E" + VeDate.getStringDatex());
		return map;
	}

	// 新增员工
	@PostMapping(value = "insertEmploy.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertEmploy(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Employ employ = new Employ();
		employ.setEno(obj.getString("eno")); // 为员工号赋值
		employ.setRealname(obj.getString("realname")); // 为姓名赋值
		employ.setSex(obj.getString("sex")); // 为性别赋值
		employ.setDeptid(obj.getString("deptid")); // 为部门赋值
		employ.setDutyid(obj.getString("dutyid")); // 为职务赋值
		employ.setXueli(obj.getString("xueli")); // 为学历赋值
		employ.setGraduate(obj.getString("graduate")); // 为毕业院校赋值
		employ.setWorkdate(obj.getString("workdate")); // 为入职日期赋值
		employ.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.employService.insertEmploy(employ);
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

	// 按主键删除一个员工
	@GetMapping(value = "deleteEmploy.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteEmploy(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.employService.deleteEmploy(id);
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

	// 按主键批量删除员工
	@PostMapping(value = "deleteEmployByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteEmployByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String employid : ids) {
			num += this.employService.deleteEmploy(employid);
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

	// 修改员工
	@PostMapping(value = "updateEmploy.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateEmploy(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Employ employ = this.employService.getEmployById(obj.getString("employid")); // 获取object中employid字段
		employ.setEno(obj.getString("eno")); // 为员工号赋值
		employ.setRealname(obj.getString("realname")); // 为姓名赋值
		employ.setSex(obj.getString("sex")); // 为性别赋值
		employ.setDeptid(obj.getString("deptid")); // 为部门赋值
		employ.setDutyid(obj.getString("dutyid")); // 为职务赋值
		employ.setXueli(obj.getString("xueli")); // 为学历赋值
		employ.setGraduate(obj.getString("graduate")); // 为毕业院校赋值
		employ.setWorkdate(obj.getString("workdate")); // 为入职日期赋值
		employ.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.employService.updateEmploy(employ);
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

	// 查询全部员工数据 在下拉菜单中显示
	@GetMapping(value = "getAllEmploy.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Employ> getAllEmploy() {
		return this.employService.getAllEmploy();
	}

	// 通过AJAX在表格中显示员工数据
	@GetMapping(value = "getEmployByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getEmployByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Employ> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Employ> list = this.employService.getAllEmploy();
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

	// 按主键查询员工数据
	@GetMapping(value = "getEmployById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Employ getEmployById(String id) {
		Employ employ = this.employService.getEmployById(id);
		return employ;
	}

}
