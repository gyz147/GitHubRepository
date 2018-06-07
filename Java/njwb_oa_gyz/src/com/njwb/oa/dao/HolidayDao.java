package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Holiday;
import com.njwb.oa.util.PageModel;

/**
 * 请假的数据操作层
 * 
 * @author soft01
 * 
 */
public interface HolidayDao {
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws SQLException;

	/**
	 * 查询请假信息
	 * 
	 * @param pageModel
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	PageModel<Holiday> queryHoliday(PageModel<Holiday> pageModel, String configType, String name, String type, String status) throws SQLException;

	/**
	 * 查询请假信息的总数
	 * 
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	int queryHolidayCnt(String name, String type, String status) throws SQLException;

	/**
	 * 添加请假信息
	 * 
	 * @param holiday
	 * @throws SQLException
	 */
	void addHoliday(Holiday holiday) throws SQLException;

	/**
	 * 删除请假信息
	 * 
	 * @param holidayNo
	 * @throws SQLException
	 */
	void deletHoliday(String holidayNo) throws SQLException;

	/**
	 * 通过请假编号查询请假信息
	 * 
	 * @param holidayNo
	 * @return
	 * @throws SQLException
	 */
	Holiday queryHolidayByNo(String configType, String holidayNo) throws SQLException;

	/**
	 * 修改请假信息
	 * 
	 * @param holiday
	 * @throws SQLException
	 */
	void modifyHoliday(Holiday holiday) throws SQLException;

	/**
	 * 查询最后一个请假编号
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryHollidayNo(int cnt) throws SQLException;

}
