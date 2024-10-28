package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Duty;

@Repository("dutyDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到DutyServiceImpl中
public interface DutyDAO {

	/**
	* DutyDAO 接口 可以按名称直接调用duty.xml配置文件的SQL语句
	*/

	// 插入职务表数据 调用mapper包duty.xml里的insertDuty配置 返回值0(失败),1(成功)
	public int insertDuty(Duty duty);

	// 更新职务表数据 调用mapper包duty.xml里的updateDuty配置 返回值0(失败),1(成功)
	public int updateDuty(Duty duty);

	// 按主键删除职务表数据 调用mapper包duty.xml里的deleteDuty配置 返回值0(失败),1(成功)
	public int deleteDuty(String dutyid);

	// 批量删除职务表数据 调用mapper包duty.xml里的deleteDutyByIds配置 返回值0(失败),大于0(成功)
	public int deleteDutyByIds(String[] ids);

	// 查询职务表全部数据 调用mapper包duty.xml里的getAllDuty配置 返回List<Duty>类型的数据
	public List<Duty> getAllDuty();

	// 按照Duty类里面的值精确查询 调用mapper包duty.xml里的getDutyByCond配置 返回List<Duty>类型的数据
	public List<Duty> getDutyByCond(Duty duty);

	// 按照Duty类里面的值模糊查询 调用mapper包duty.xml里的getDutyByLike配置 返回List<Duty>类型的数据
	public List<Duty> getDutyByLike(Duty duty);

	// 按主键查询职务表返回单一的Duty实例 调用mapper包duty.xml里的getDutyById配置
	public Duty getDutyById(String dutyid);

}


