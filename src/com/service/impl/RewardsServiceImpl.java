package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RewardsDAO;
import com.entity.Rewards;
import com.service.RewardsService;

@Service("rewardsService") //
public class RewardsServiceImpl implements RewardsService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private RewardsDAO rewardsDAO;
	@Override // 继承接口的新增员工奖惩表数据 返回值0(失败),1(成功)
	public int insertRewards(Rewards rewards) {
		return this.rewardsDAO.insertRewards(rewards);
	}

	@Override // 继承接口的更新员工奖惩表数据 返回值0(失败),1(成功)
	public int updateRewards(Rewards rewards) {
		return this.rewardsDAO.updateRewards(rewards);
	}

	@Override // 继承接口的按主键删除员工奖惩表数据 返回值0(失败),1(成功)
	public int deleteRewards(String rewardsid) {
		return this.rewardsDAO.deleteRewards(rewardsid);
	}

	@Override // 继承接口的批量删除员工奖惩表数据 返回值0(失败),大于0(成功)
	public int deleteRewardsByIds(String[] ids) {
		return this.rewardsDAO.deleteRewardsByIds(ids);
	}

	@Override // 继承接口的查询员工奖惩表全部数据
	public List<Rewards> getAllRewards() {
		return this.rewardsDAO.getAllRewards();
	}

	@Override // 继承接口的按条件精确查询员工奖惩表数据
	public List<Rewards> getRewardsByCond(Rewards rewards) {
		return this.rewardsDAO.getRewardsByCond(rewards);
	}

	@Override // 继承接口的按条件模糊查询员工奖惩表数据
	public List<Rewards> getRewardsByLike(Rewards rewards) {
		return this.rewardsDAO.getRewardsByLike(rewards);
	}

	@Override // 继承接口的按主键查询员工奖惩表数据 返回Entity实例
	public Rewards getRewardsById(String rewardsid) {
		return this.rewardsDAO.getRewardsById(rewardsid);
	}

}

