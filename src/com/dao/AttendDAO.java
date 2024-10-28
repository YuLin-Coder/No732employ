package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Attend;

@Repository("attendDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到AttendServiceImpl中
public interface AttendDAO {

	/**
	* AttendDAO 接口 可以按名称直接调用attend.xml配置文件的SQL语句
	*/

	// 插入员工考勤表数据 调用mapper包attend.xml里的insertAttend配置 返回值0(失败),1(成功)
	public int insertAttend(Attend attend);

	// 更新员工考勤表数据 调用mapper包attend.xml里的updateAttend配置 返回值0(失败),1(成功)
	public int updateAttend(Attend attend);

	// 按主键删除员工考勤表数据 调用mapper包attend.xml里的deleteAttend配置 返回值0(失败),1(成功)
	public int deleteAttend(String attendid);

	// 批量删除员工考勤表数据 调用mapper包attend.xml里的deleteAttendByIds配置 返回值0(失败),大于0(成功)
	public int deleteAttendByIds(String[] ids);

	// 查询员工考勤表全部数据 调用mapper包attend.xml里的getAllAttend配置 返回List<Attend>类型的数据
	public List<Attend> getAllAttend();

	// 按照Attend类里面的值精确查询 调用mapper包attend.xml里的getAttendByCond配置 返回List<Attend>类型的数据
	public List<Attend> getAttendByCond(Attend attend);

	// 按照Attend类里面的值模糊查询 调用mapper包attend.xml里的getAttendByLike配置 返回List<Attend>类型的数据
	public List<Attend> getAttendByLike(Attend attend);

	// 按主键查询员工考勤表返回单一的Attend实例 调用mapper包attend.xml里的getAttendById配置
	public Attend getAttendById(String attendid);

}


