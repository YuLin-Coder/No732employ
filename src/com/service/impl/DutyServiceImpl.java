package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DutyDAO;
import com.entity.Duty;
import com.service.DutyService;

@Service("dutyService") //
public class DutyServiceImpl implements DutyService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private DutyDAO dutyDAO;
	@Override // 继承接口的新增职务表数据 返回值0(失败),1(成功)
	public int insertDuty(Duty duty) {
		return this.dutyDAO.insertDuty(duty);
	}

	@Override // 继承接口的更新职务表数据 返回值0(失败),1(成功)
	public int updateDuty(Duty duty) {
		return this.dutyDAO.updateDuty(duty);
	}

	@Override // 继承接口的按主键删除职务表数据 返回值0(失败),1(成功)
	public int deleteDuty(String dutyid) {
		return this.dutyDAO.deleteDuty(dutyid);
	}

	@Override // 继承接口的批量删除职务表数据 返回值0(失败),大于0(成功)
	public int deleteDutyByIds(String[] ids) {
		return this.dutyDAO.deleteDutyByIds(ids);
	}

	@Override // 继承接口的查询职务表全部数据
	public List<Duty> getAllDuty() {
		return this.dutyDAO.getAllDuty();
	}

	@Override // 继承接口的按条件精确查询职务表数据
	public List<Duty> getDutyByCond(Duty duty) {
		return this.dutyDAO.getDutyByCond(duty);
	}

	@Override // 继承接口的按条件模糊查询职务表数据
	public List<Duty> getDutyByLike(Duty duty) {
		return this.dutyDAO.getDutyByLike(duty);
	}

	@Override // 继承接口的按主键查询职务表数据 返回Entity实例
	public Duty getDutyById(String dutyid) {
		return this.dutyDAO.getDutyById(dutyid);
	}

}

