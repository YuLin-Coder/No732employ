package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Trains;

@Repository("trainsDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到TrainsServiceImpl中
public interface TrainsDAO {

	/**
	* TrainsDAO 接口 可以按名称直接调用trains.xml配置文件的SQL语句
	*/

	// 插入员工培训表数据 调用mapper包trains.xml里的insertTrains配置 返回值0(失败),1(成功)
	public int insertTrains(Trains trains);

	// 更新员工培训表数据 调用mapper包trains.xml里的updateTrains配置 返回值0(失败),1(成功)
	public int updateTrains(Trains trains);

	// 按主键删除员工培训表数据 调用mapper包trains.xml里的deleteTrains配置 返回值0(失败),1(成功)
	public int deleteTrains(String trainsid);

	// 批量删除员工培训表数据 调用mapper包trains.xml里的deleteTrainsByIds配置 返回值0(失败),大于0(成功)
	public int deleteTrainsByIds(String[] ids);

	// 查询员工培训表全部数据 调用mapper包trains.xml里的getAllTrains配置 返回List<Trains>类型的数据
	public List<Trains> getAllTrains();

	// 按照Trains类里面的值精确查询 调用mapper包trains.xml里的getTrainsByCond配置 返回List<Trains>类型的数据
	public List<Trains> getTrainsByCond(Trains trains);

	// 按照Trains类里面的值模糊查询 调用mapper包trains.xml里的getTrainsByLike配置 返回List<Trains>类型的数据
	public List<Trains> getTrainsByLike(Trains trains);

	// 按主键查询员工培训表返回单一的Trains实例 调用mapper包trains.xml里的getTrainsById配置
	public Trains getTrainsById(String trainsid);

}


