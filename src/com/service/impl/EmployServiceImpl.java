package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EmployDAO;
import com.entity.Employ;
import com.service.EmployService;

@Service("employService") //
public class EmployServiceImpl implements EmployService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private EmployDAO employDAO;
	@Override // 继承接口的新增员工表数据 返回值0(失败),1(成功)
	public int insertEmploy(Employ employ) {
		return this.employDAO.insertEmploy(employ);
	}

	@Override // 继承接口的更新员工表数据 返回值0(失败),1(成功)
	public int updateEmploy(Employ employ) {
		return this.employDAO.updateEmploy(employ);
	}

	@Override // 继承接口的按主键删除员工表数据 返回值0(失败),1(成功)
	public int deleteEmploy(String employid) {
		return this.employDAO.deleteEmploy(employid);
	}

	@Override // 继承接口的批量删除员工表数据 返回值0(失败),大于0(成功)
	public int deleteEmployByIds(String[] ids) {
		return this.employDAO.deleteEmployByIds(ids);
	}

	@Override // 继承接口的查询员工表全部数据
	public List<Employ> getAllEmploy() {
		return this.employDAO.getAllEmploy();
	}

	@Override // 继承接口的按条件精确查询员工表数据
	public List<Employ> getEmployByCond(Employ employ) {
		return this.employDAO.getEmployByCond(employ);
	}

	@Override // 继承接口的按条件模糊查询员工表数据
	public List<Employ> getEmployByLike(Employ employ) {
		return this.employDAO.getEmployByLike(employ);
	}

	@Override // 继承接口的按主键查询员工表数据 返回Entity实例
	public Employ getEmployById(String employid) {
		return this.employDAO.getEmployById(employid);
	}

}

