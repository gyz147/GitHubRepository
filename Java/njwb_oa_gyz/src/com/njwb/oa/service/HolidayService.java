package com.njwb.oa.service;

/**
 * 请假信息的业务操作层
 */
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Holiday;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

public interface HolidayService {
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws OAException;

	/**
	 * 查询请假信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 */
	PageModel<Holiday> queryHoliday(int pageNo, int pageSize, String configType, String name, String type, String status) throws OAException;

	/**
	 * 添加请假信息
	 * 
	 * @param holiday
	 * @throws OAException
	 */
	void addHoliday(Holiday holiday) throws OAException;

	/**
	 * 删除请假信息
	 * 
	 * @param holidayNo
	 * @throws OAException
	 */
	void deletHoliday(String holidayNo) throws OAException;

	/**
	 * 通过请假编号查询请假信息
	 * 
	 * @param holidayNo
	 * @return
	 * @throws OAException
	 */
	Holiday queryHolidayByNo(String configType, String holidayNo) throws OAException;

	/**
	 * 修改请假信息
	 * 
	 * @param holiday
	 * @throws OAException
	 */
	void modifyHoliday(Holiday holiday) throws OAException;

	/**
	 * 查询最后一个请假编号
	 * 
	 * @param cnt
	 * @return
	 */
	int queryHollidayNo() throws OAException;
}
