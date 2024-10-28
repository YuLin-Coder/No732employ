package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Dept;
@Service("deptService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface DeptService {
	// 插入部门表数据 调用deptDAO里的insertDept配置
	public int insertDept(Dept dept);

	// 更新部门表数据 调用deptDAO里的updateDept配置
	public int updateDept(Dept dept);

	// 按主键删除部门表数据 调用deptDAO里的deleteDept配置
	public int deleteDept(String deptid);

	// 批量删除部门表数据 调用mapper包dept.xml里的deleteDeptByIds配置 返回值0(失败),大于0(成功)
	public int deleteDeptByIds(String[] ids);

	// 查询全部数据 调用deptDAO里的getAllDept配置
	public List<Dept> getAllDept();

	// 按照Dept类里面的字段名称精确查询 调用deptDAO里的getDeptByCond配置
	public List<Dept> getDeptByCond(Dept dept);

	// 按照Dept类里面的字段名称模糊查询 调用deptDAO里的getDeptByLike配置
	public List<Dept> getDeptByLike(Dept dept);

	// 按主键查询表返回单一的Dept实例 调用deptDAO里的getDeptById配置
	public Dept getDeptById(String deptid);

}

