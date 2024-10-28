package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Salary;

@Repository("salaryDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到SalaryServiceImpl中
public interface SalaryDAO {

	/**
	* SalaryDAO 接口 可以按名称直接调用salary.xml配置文件的SQL语句
	*/

	// 插入员工薪资表数据 调用mapper包salary.xml里的insertSalary配置 返回值0(失败),1(成功)
	public int insertSalary(Salary salary);

	// 更新员工薪资表数据 调用mapper包salary.xml里的updateSalary配置 返回值0(失败),1(成功)
	public int updateSalary(Salary salary);

	// 按主键删除员工薪资表数据 调用mapper包salary.xml里的deleteSalary配置 返回值0(失败),1(成功)
	public int deleteSalary(String salaryid);

	// 批量删除员工薪资表数据 调用mapper包salary.xml里的deleteSalaryByIds配置 返回值0(失败),大于0(成功)
	public int deleteSalaryByIds(String[] ids);

	// 查询员工薪资表全部数据 调用mapper包salary.xml里的getAllSalary配置 返回List<Salary>类型的数据
	public List<Salary> getAllSalary();

	// 按照Salary类里面的值精确查询 调用mapper包salary.xml里的getSalaryByCond配置 返回List<Salary>类型的数据
	public List<Salary> getSalaryByCond(Salary salary);

	// 按照Salary类里面的值模糊查询 调用mapper包salary.xml里的getSalaryByLike配置 返回List<Salary>类型的数据
	public List<Salary> getSalaryByLike(Salary salary);

	// 按主键查询员工薪资表返回单一的Salary实例 调用mapper包salary.xml里的getSalaryById配置
	public Salary getSalaryById(String salaryid);

}


