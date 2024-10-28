package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SalaryDAO;
import com.entity.Salary;
import com.service.SalaryService;

@Service("salaryService") //
public class SalaryServiceImpl implements SalaryService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private SalaryDAO salaryDAO;
	@Override // 继承接口的新增员工薪资表数据 返回值0(失败),1(成功)
	public int insertSalary(Salary salary) {
		return this.salaryDAO.insertSalary(salary);
	}

	@Override // 继承接口的更新员工薪资表数据 返回值0(失败),1(成功)
	public int updateSalary(Salary salary) {
		return this.salaryDAO.updateSalary(salary);
	}

	@Override // 继承接口的按主键删除员工薪资表数据 返回值0(失败),1(成功)
	public int deleteSalary(String salaryid) {
		return this.salaryDAO.deleteSalary(salaryid);
	}

	@Override // 继承接口的批量删除员工薪资表数据 返回值0(失败),大于0(成功)
	public int deleteSalaryByIds(String[] ids) {
		return this.salaryDAO.deleteSalaryByIds(ids);
	}

	@Override // 继承接口的查询员工薪资表全部数据
	public List<Salary> getAllSalary() {
		return this.salaryDAO.getAllSalary();
	}

	@Override // 继承接口的按条件精确查询员工薪资表数据
	public List<Salary> getSalaryByCond(Salary salary) {
		return this.salaryDAO.getSalaryByCond(salary);
	}

	@Override // 继承接口的按条件模糊查询员工薪资表数据
	public List<Salary> getSalaryByLike(Salary salary) {
		return this.salaryDAO.getSalaryByLike(salary);
	}

	@Override // 继承接口的按主键查询员工薪资表数据 返回Entity实例
	public Salary getSalaryById(String salaryid) {
		return this.salaryDAO.getSalaryById(salaryid);
	}

}

