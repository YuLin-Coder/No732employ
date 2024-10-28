package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AttendDAO;
import com.entity.Attend;
import com.service.AttendService;

@Service("attendService") //
public class AttendServiceImpl implements AttendService {
	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private AttendDAO attendDAO;
	@Override // 继承接口的新增员工考勤表数据 返回值0(失败),1(成功)
	public int insertAttend(Attend attend) {
		return this.attendDAO.insertAttend(attend);
	}

	@Override // 继承接口的更新员工考勤表数据 返回值0(失败),1(成功)
	public int updateAttend(Attend attend) {
		return this.attendDAO.updateAttend(attend);
	}

	@Override // 继承接口的按主键删除员工考勤表数据 返回值0(失败),1(成功)
	public int deleteAttend(String attendid) {
		return this.attendDAO.deleteAttend(attendid);
	}

	@Override // 继承接口的批量删除员工考勤表数据 返回值0(失败),大于0(成功)
	public int deleteAttendByIds(String[] ids) {
		return this.attendDAO.deleteAttendByIds(ids);
	}

	@Override // 继承接口的查询员工考勤表全部数据
	public List<Attend> getAllAttend() {
		return this.attendDAO.getAllAttend();
	}

	@Override // 继承接口的按条件精确查询员工考勤表数据
	public List<Attend> getAttendByCond(Attend attend) {
		return this.attendDAO.getAttendByCond(attend);
	}

	@Override // 继承接口的按条件模糊查询员工考勤表数据
	public List<Attend> getAttendByLike(Attend attend) {
		return this.attendDAO.getAttendByLike(attend);
	}

	@Override // 继承接口的按主键查询员工考勤表数据 返回Entity实例
	public Attend getAttendById(String attendid) {
		return this.attendDAO.getAttendById(attendid);
	}

}

