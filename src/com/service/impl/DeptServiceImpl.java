package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DeptDAO;
import com.entity.Dept;
import com.service.DeptService;

@Service("deptService") //
public class DeptServiceImpl implements DeptService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private DeptDAO deptDAO;
	@Override // 继承接口的新增部门表数据 返回值0(失败),1(成功)
	public int insertDept(Dept dept) {
		return this.deptDAO.insertDept(dept);
	}

	@Override // 继承接口的更新部门表数据 返回值0(失败),1(成功)
	public int updateDept(Dept dept) {
		return this.deptDAO.updateDept(dept);
	}

	@Override // 继承接口的按主键删除部门表数据 返回值0(失败),1(成功)
	public int deleteDept(String deptid) {
		return this.deptDAO.deleteDept(deptid);
	}

	@Override // 继承接口的批量删除部门表数据 返回值0(失败),大于0(成功)
	public int deleteDeptByIds(String[] ids) {
		return this.deptDAO.deleteDeptByIds(ids);
	}

	@Override // 继承接口的查询部门表全部数据
	public List<Dept> getAllDept() {
		return this.deptDAO.getAllDept();
	}

	@Override // 继承接口的按条件精确查询部门表数据
	public List<Dept> getDeptByCond(Dept dept) {
		return this.deptDAO.getDeptByCond(dept);
	}

	@Override // 继承接口的按条件模糊查询部门表数据
	public List<Dept> getDeptByLike(Dept dept) {
		return this.deptDAO.getDeptByLike(dept);
	}

	@Override // 继承接口的按主键查询部门表数据 返回Entity实例
	public Dept getDeptById(String deptid) {
		return this.deptDAO.getDeptById(deptid);
	}

}

