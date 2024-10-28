package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Dept;

@Repository("deptDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到DeptServiceImpl中
public interface DeptDAO {

	/**
	* DeptDAO 接口 可以按名称直接调用dept.xml配置文件的SQL语句
	*/

	// 插入部门表数据 调用mapper包dept.xml里的insertDept配置 返回值0(失败),1(成功)
	public int insertDept(Dept dept);

	// 更新部门表数据 调用mapper包dept.xml里的updateDept配置 返回值0(失败),1(成功)
	public int updateDept(Dept dept);

	// 按主键删除部门表数据 调用mapper包dept.xml里的deleteDept配置 返回值0(失败),1(成功)
	public int deleteDept(String deptid);

	// 批量删除部门表数据 调用mapper包dept.xml里的deleteDeptByIds配置 返回值0(失败),大于0(成功)
	public int deleteDeptByIds(String[] ids);

	// 查询部门表全部数据 调用mapper包dept.xml里的getAllDept配置 返回List<Dept>类型的数据
	public List<Dept> getAllDept();

	// 按照Dept类里面的值精确查询 调用mapper包dept.xml里的getDeptByCond配置 返回List<Dept>类型的数据
	public List<Dept> getDeptByCond(Dept dept);

	// 按照Dept类里面的值模糊查询 调用mapper包dept.xml里的getDeptByLike配置 返回List<Dept>类型的数据
	public List<Dept> getDeptByLike(Dept dept);

	// 按主键查询部门表返回单一的Dept实例 调用mapper包dept.xml里的getDeptById配置
	public Dept getDeptById(String deptid);

}


