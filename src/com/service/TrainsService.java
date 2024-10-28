package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Trains;
@Service("trainsService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface TrainsService {
	// 插入员工培训表数据 调用trainsDAO里的insertTrains配置
	public int insertTrains(Trains trains);

	// 更新员工培训表数据 调用trainsDAO里的updateTrains配置
	public int updateTrains(Trains trains);

	// 按主键删除员工培训表数据 调用trainsDAO里的deleteTrains配置
	public int deleteTrains(String trainsid);

	// 批量删除员工培训表数据 调用mapper包trains.xml里的deleteTrainsByIds配置 返回值0(失败),大于0(成功)
	public int deleteTrainsByIds(String[] ids);

	// 查询全部数据 调用trainsDAO里的getAllTrains配置
	public List<Trains> getAllTrains();

	// 按照Trains类里面的字段名称精确查询 调用trainsDAO里的getTrainsByCond配置
	public List<Trains> getTrainsByCond(Trains trains);

	// 按照Trains类里面的字段名称模糊查询 调用trainsDAO里的getTrainsByLike配置
	public List<Trains> getTrainsByLike(Trains trains);

	// 按主键查询表返回单一的Trains实例 调用trainsDAO里的getTrainsById配置
	public Trains getTrainsById(String trainsid);

}

