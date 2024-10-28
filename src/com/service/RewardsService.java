package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Rewards;
@Service("rewardsService") // 自动注册到Spring容器，不需要再在xml文件定义bean
public interface RewardsService {
	// 插入员工奖惩表数据 调用rewardsDAO里的insertRewards配置
	public int insertRewards(Rewards rewards);

	// 更新员工奖惩表数据 调用rewardsDAO里的updateRewards配置
	public int updateRewards(Rewards rewards);

	// 按主键删除员工奖惩表数据 调用rewardsDAO里的deleteRewards配置
	public int deleteRewards(String rewardsid);

	// 批量删除员工奖惩表数据 调用mapper包rewards.xml里的deleteRewardsByIds配置 返回值0(失败),大于0(成功)
	public int deleteRewardsByIds(String[] ids);

	// 查询全部数据 调用rewardsDAO里的getAllRewards配置
	public List<Rewards> getAllRewards();

	// 按照Rewards类里面的字段名称精确查询 调用rewardsDAO里的getRewardsByCond配置
	public List<Rewards> getRewardsByCond(Rewards rewards);

	// 按照Rewards类里面的字段名称模糊查询 调用rewardsDAO里的getRewardsByLike配置
	public List<Rewards> getRewardsByLike(Rewards rewards);

	// 按主键查询表返回单一的Rewards实例 调用rewardsDAO里的getRewardsById配置
	public Rewards getRewardsById(String rewardsid);

}

