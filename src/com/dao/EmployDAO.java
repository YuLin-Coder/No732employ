package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Employ;

@Repository("employDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到EmployServiceImpl中
public interface EmployDAO {

	/**
	* EmployDAO 接口 可以按名称直接调用employ.xml配置文件的SQL语句
	*/

	// 插入员工表数据 调用mapper包employ.xml里的insertEmploy配置 返回值0(失败),1(成功)
	public int insertEmploy(Employ employ);

	// 更新员工表数据 调用mapper包employ.xml里的updateEmploy配置 返回值0(失败),1(成功)
	public int updateEmploy(Employ employ);

	// 按主键删除员工表数据 调用mapper包employ.xml里的deleteEmploy配置 返回值0(失败),1(成功)
	public int deleteEmploy(String employid);

	// 批量删除员工表数据 调用mapper包employ.xml里的deleteEmployByIds配置 返回值0(失败),大于0(成功)
	public int deleteEmployByIds(String[] ids);

	// 查询员工表全部数据 调用mapper包employ.xml里的getAllEmploy配置 返回List<Employ>类型的数据
	public List<Employ> getAllEmploy();

	// 按照Employ类里面的值精确查询 调用mapper包employ.xml里的getEmployByCond配置 返回List<Employ>类型的数据
	public List<Employ> getEmployByCond(Employ employ);

	// 按照Employ类里面的值模糊查询 调用mapper包employ.xml里的getEmployByLike配置 返回List<Employ>类型的数据
	public List<Employ> getEmployByLike(Employ employ);

	// 按主键查询员工表返回单一的Employ实例 调用mapper包employ.xml里的getEmployById配置
	public Employ getEmployById(String employid);

}


