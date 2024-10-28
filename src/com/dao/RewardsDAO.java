package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Rewards;

@Repository("rewardsDAO") // Repository标签定义数据库连接的访问 Spring中直接扫描加载
@Mapper // 不需要在spring配置中设置扫描地址 spring将动态的生成Bean后注入到RewardsServiceImpl中
public interface RewardsDAO {

	/**
	* RewardsDAO 接口 可以按名称直接调用rewards.xml配置文件的SQL语句
	*/

	// 插入员工奖惩表数据 调用mapper包rewards.xml里的insertRewards配置 返回值0(失败),1(成功)
	public int insertRewards(Rewards rewards);

	// 更新员工奖惩表数据 调用mapper包rewards.xml里的updateRewards配置 返回值0(失败),1(成功)
	public int updateRewards(Rewards rewards);

	// 按主键删除员工奖惩表数据 调用mapper包rewards.xml里的deleteRewards配置 返回值0(失败),1(成功)
	public int deleteRewards(String rewardsid);

	// 批量删除员工奖惩表数据 调用mapper包rewards.xml里的deleteRewardsByIds配置 返回值0(失败),大于0(成功)
	public int deleteRewardsByIds(String[] ids);

	// 查询员工奖惩表全部数据 调用mapper包rewards.xml里的getAllRewards配置 返回List<Rewards>类型的数据
	public List<Rewards> getAllRewards();

	// 按照Rewards类里面的值精确查询 调用mapper包rewards.xml里的getRewardsByCond配置 返回List<Rewards>类型的数据
	public List<Rewards> getRewardsByCond(Rewards rewards);

	// 按照Rewards类里面的值模糊查询 调用mapper包rewards.xml里的getRewardsByLike配置 返回List<Rewards>类型的数据
	public List<Rewards> getRewardsByLike(Rewards rewards);

	// 按主键查询员工奖惩表返回单一的Rewards实例 调用mapper包rewards.xml里的getRewardsById配置
	public Rewards getRewardsById(String rewardsid);

}


