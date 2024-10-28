package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TrainsDAO;
import com.entity.Trains;
import com.service.TrainsService;

@Service("trainsService") //
public class TrainsServiceImpl implements TrainsService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private TrainsDAO trainsDAO;
	@Override // 继承接口的新增员工培训表数据 返回值0(失败),1(成功)
	public int insertTrains(Trains trains) {
		return this.trainsDAO.insertTrains(trains);
	}

	@Override // 继承接口的更新员工培训表数据 返回值0(失败),1(成功)
	public int updateTrains(Trains trains) {
		return this.trainsDAO.updateTrains(trains);
	}

	@Override // 继承接口的按主键删除员工培训表数据 返回值0(失败),1(成功)
	public int deleteTrains(String trainsid) {
		return this.trainsDAO.deleteTrains(trainsid);
	}

	@Override // 继承接口的批量删除员工培训表数据 返回值0(失败),大于0(成功)
	public int deleteTrainsByIds(String[] ids) {
		return this.trainsDAO.deleteTrainsByIds(ids);
	}

	@Override // 继承接口的查询员工培训表全部数据
	public List<Trains> getAllTrains() {
		return this.trainsDAO.getAllTrains();
	}

	@Override // 继承接口的按条件精确查询员工培训表数据
	public List<Trains> getTrainsByCond(Trains trains) {
		return this.trainsDAO.getTrainsByCond(trains);
	}

	@Override // 继承接口的按条件模糊查询员工培训表数据
	public List<Trains> getTrainsByLike(Trains trains) {
		return this.trainsDAO.getTrainsByLike(trains);
	}

	@Override // 继承接口的按主键查询员工培训表数据 返回Entity实例
	public Trains getTrainsById(String trainsid) {
		return this.trainsDAO.getTrainsById(trainsid);
	}

}

