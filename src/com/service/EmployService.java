package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Employ;
@Service("employService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface EmployService {
	// 插入员工表数据 调用employDAO里的insertEmploy配置
	public int insertEmploy(Employ employ);

	// 更新员工表数据 调用employDAO里的updateEmploy配置
	public int updateEmploy(Employ employ);

	// 按主键删除员工表数据 调用employDAO里的deleteEmploy配置
	public int deleteEmploy(String employid);

	// 批量删除员工表数据 调用mapper包employ.xml里的deleteEmployByIds配置 返回值0(失败),大于0(成功)
	public int deleteEmployByIds(String[] ids);

	// 查询全部数据 调用employDAO里的getAllEmploy配置
	public List<Employ> getAllEmploy();

	// 按照Employ类里面的字段名称精确查询 调用employDAO里的getEmployByCond配置
	public List<Employ> getEmployByCond(Employ employ);

	// 按照Employ类里面的字段名称模糊查询 调用employDAO里的getEmployByLike配置
	public List<Employ> getEmployByLike(Employ employ);

	// 按主键查询表返回单一的Employ实例 调用employDAO里的getEmployById配置
	public Employ getEmployById(String employid);

}

