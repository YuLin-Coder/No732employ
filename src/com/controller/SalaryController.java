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
import com.entity.Salary;
import com.github.pagehelper.Page;
import com.service.SalaryService;
import com.util.VeDate;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/salary", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class SalaryController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private SalaryService salaryService;

	// 预处理 获取基础参数
	@GetMapping(value = "createSalary.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createSalary() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sno", "S" + VeDate.getStringDatex());
		return map;
	}

	// 新增员工薪资
	@PostMapping(value = "insertSalary.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertSalary(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Salary salary = new Salary();
		salary.setSno(obj.getString("sno")); // 为薪资单号赋值
		salary.setEmployid(obj.getString("employid")); // 为员工赋值
		salary.setBasic(obj.getString("basic")); // 为基本工资赋值
		salary.setAttend(obj.getString("attend")); // 为考勤工资赋值
		salary.setReward(obj.getString("reward")); // 为奖惩工资赋值
		salary.setOthers(obj.getString("others")); // 为其他工资赋值
		salary.setTotal(obj.getString("total")); // 为总计赋值
		salary.setYearx(obj.getString("yearx")); // 为年月赋值
		salary.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.salaryService.insertSalary(salary);
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

	// 按主键删除一个员工薪资
	@GetMapping(value = "deleteSalary.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteSalary(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.salaryService.deleteSalary(id);
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

	// 按主键批量删除员工薪资
	@PostMapping(value = "deleteSalaryByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteSalaryByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String salaryid : ids) {
			num += this.salaryService.deleteSalary(salaryid);
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

	// 修改员工薪资
	@PostMapping(value = "updateSalary.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateSalary(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Salary salary = this.salaryService.getSalaryById(obj.getString("salaryid")); // 获取object中salaryid字段
		salary.setSno(obj.getString("sno")); // 为薪资单号赋值
		salary.setEmployid(obj.getString("employid")); // 为员工赋值
		salary.setBasic(obj.getString("basic")); // 为基本工资赋值
		salary.setAttend(obj.getString("attend")); // 为考勤工资赋值
		salary.setReward(obj.getString("reward")); // 为奖惩工资赋值
		salary.setOthers(obj.getString("others")); // 为其他工资赋值
		salary.setTotal(obj.getString("total")); // 为总计赋值
		salary.setYearx(obj.getString("yearx")); // 为年月赋值
		salary.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.salaryService.updateSalary(salary);
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

	// 查询全部员工薪资数据 在下拉菜单中显示
	@GetMapping(value = "getAllSalary.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Salary> getAllSalary() {
		return this.salaryService.getAllSalary();
	}

	// 通过AJAX在表格中显示员工薪资数据
	@GetMapping(value = "getSalaryByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getSalaryByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Salary> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Salary> list = this.salaryService.getAllSalary();
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

	// 按主键查询员工薪资数据
	@GetMapping(value = "getSalaryById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Salary getSalaryById(String id) {
		Salary salary = this.salaryService.getSalaryById(id);
		return salary;
	}

}
