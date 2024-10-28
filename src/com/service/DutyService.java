package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Duty;
@Service("dutyService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface DutyService {
	// 插入职务表数据 调用dutyDAO里的insertDuty配置
	public int insertDuty(Duty duty);

	// 更新职务表数据 调用dutyDAO里的updateDuty配置
	public int updateDuty(Duty duty);

	// 按主键删除职务表数据 调用dutyDAO里的deleteDuty配置
	public int deleteDuty(String dutyid);

	// 批量删除职务表数据 调用mapper包duty.xml里的deleteDutyByIds配置 返回值0(失败),大于0(成功)
	public int deleteDutyByIds(String[] ids);

	// 查询全部数据 调用dutyDAO里的getAllDuty配置
	public List<Duty> getAllDuty();

	// 按照Duty类里面的字段名称精确查询 调用dutyDAO里的getDutyByCond配置
	public List<Duty> getDutyByCond(Duty duty);

	// 按照Duty类里面的字段名称模糊查询 调用dutyDAO里的getDutyByLike配置
	public List<Duty> getDutyByLike(Duty duty);

	// 按主键查询表返回单一的Duty实例 调用dutyDAO里的getDutyById配置
	public Duty getDutyById(String dutyid);

}

