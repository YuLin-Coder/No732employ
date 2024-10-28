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
import com.entity.Rewards;
import com.github.pagehelper.Page;
import com.service.RewardsService;

@RestController // 定义为控制器 返回JSON类型数据
@RequestMapping(value = "/rewards", produces = "application/json; charset=utf-8") // 设置请求路径
@CrossOrigin // 允许跨域访问其资源
public class RewardsController extends BaseController {

	@Autowired // @Autowired的作用是自动注入依赖的ServiceBean
	private RewardsService rewardsService;

	// 预处理 获取基础参数
	@GetMapping(value = "createRewards.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> createRewards() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	// 新增员工奖惩
	@PostMapping(value = "insertRewards.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> insertRewards(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Rewards rewards = new Rewards();
		rewards.setEmployid(obj.getString("employid")); // 为员工赋值
		rewards.setCate(obj.getString("cate")); // 为奖惩类型赋值
		rewards.setReason(obj.getString("reason")); // 为奖惩原因赋值
		rewards.setResultx(obj.getString("resultx")); // 为处理意见赋值
		rewards.setAddtime(obj.getString("addtime")); // 为奖惩日期赋值
		rewards.setManager(obj.getString("manager")); // 为经手人赋值
		rewards.setMemo(obj.getString("memo")); // 为备注赋值
		int num = this.rewardsService.insertRewards(rewards);
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

	// 按主键删除一个员工奖惩
	@GetMapping(value = "deleteRewards.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteRewards(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.rewardsService.deleteRewards(id);
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

	// 按主键批量删除员工奖惩
	@PostMapping(value = "deleteRewardsByIds.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> deleteRewardsByIds(@RequestBody String[] ids) {
		int num = 0;
		for (String rewardsid : ids) {
			num += this.rewardsService.deleteRewards(rewardsid);
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

	// 修改员工奖惩
	@PostMapping(value = "updateRewards.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> updateRewards(@RequestBody String jsonStr) {
		JSONObject obj = JSONObject.parseObject(jsonStr); // 将JSON字符串转换成object
		Rewards rewards = this.rewardsService.getRewardsById(obj.getString("rewardsid")); // 获取object中rewardsid字段
		rewards.setEmployid(obj.getString("employid")); // 为员工赋值
		rewards.setCate(obj.getString("cate")); // 为奖惩类型赋值
		rewards.setReason(obj.getString("reason")); // 为奖惩原因赋值
		rewards.setResultx(obj.getString("resultx")); // 为处理意见赋值
		rewards.setAddtime(obj.getString("addtime")); // 为奖惩日期赋值
		rewards.setManager(obj.getString("manager")); // 为经手人赋值
		rewards.setMemo(obj.getString("memo")); // 为备注赋值

		Map<String, Object> map = new HashMap<String, Object>();
		int num = this.rewardsService.updateRewards(rewards);
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

	// 查询全部员工奖惩数据 在下拉菜单中显示
	@GetMapping(value = "getAllRewards.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public List<Rewards> getAllRewards() {
		return this.rewardsService.getAllRewards();
	}

	// 通过AJAX在表格中显示员工奖惩数据
	@GetMapping(value = "getRewardsByPage.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Map<String, Object> getRewardsByPage(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {
		// 定义一个Map对象 用来返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Rewards> pager = com.github.pagehelper.PageHelper.startPage(page, limit);// 定义当前页和分页条数
		List<Rewards> list = this.rewardsService.getAllRewards();
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

	// 按主键查询员工奖惩数据
	@GetMapping(value = "getRewardsById.action")
	@ResponseBody // 将java对象转为json格式的数据返回
	public Rewards getRewardsById(String id) {
		Rewards rewards = this.rewardsService.getRewardsById(id);
		return rewards;
	}

}
