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
import com.entity.Trains;
import com.github.pagehelper.Page;
import com.service.TrainsService;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/trains", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class TrainsController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private TrainsService trainsService;

	// 预处理 获取基础参数
	@GetMapping(value = "createTrains.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createTrains() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	// 新增员工培训
	@PostMapping(value = "insertTrains.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertTrains(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Trains trains = new Trains();
		trains.setEmployid(obj.getString("employid")); // 为员工赋值
		trains.setItemx(obj.getString("itemx")); // 为培训项目赋值
		trains.setIswork(obj.getString("iswork")); // 为是否脱产赋值
		trains.setThestart(obj.getString("thestart")); // 为开始日期赋值
		trains.setTheend(obj.getString("theend")); // 为结束日期赋值
		trains.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.trainsService.insertTrains(trains);
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

	// 按主键删除一个员工培训
	@GetMapping(value = "deleteTrains.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteTrains(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.trainsService.deleteTrains(id);
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

	// 按主键批量删除员工培训
	@PostMapping(value = "deleteTrainsByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteTrainsByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String trainsid : ids) {
			num += this.trainsService.deleteTrains(trainsid);
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

	// 修改员工培训
	@PostMapping(value = "updateTrains.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateTrains(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Trains trains = this.trainsService.getTrainsById(obj.getString("trainsid")); // 获取object中trainsid字段
		trains.setEmployid(obj.getString("employid")); // 为员工赋值
		trains.setItemx(obj.getString("itemx")); // 为培训项目赋值
		trains.setIswork(obj.getString("iswork")); // 为是否脱产赋值
		trains.setThestart(obj.getString("thestart")); // 为开始日期赋值
		trains.setTheend(obj.getString("theend")); // 为结束日期赋值
		trains.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.trainsService.updateTrains(trains);
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

	// 查询全部员工培训数据 在下拉菜单中显示
	@GetMapping(value = "getAllTrains.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Trains> getAllTrains() {
		return this.trainsService.getAllTrains();
	}

	// 通过AJAX在表格中显示员工培训数据
	@GetMapping(value = "getTrainsByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getTrainsByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Trains> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Trains> list = this.trainsService.getAllTrains();
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

	// 按主键查询员工培训数据
	@GetMapping(value = "getTrainsById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Trains getTrainsById(String id) {
		Trains trains = this.trainsService.getTrainsById(id);
		return trains;
	}

}
