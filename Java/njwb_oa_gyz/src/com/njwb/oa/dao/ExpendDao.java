package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Expend;
import com.njwb.oa.util.PageModel;

/**
 * 报销的数据操作层
 * 
 * @author soft01
 * 
 */
public interface ExpendDao {

	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws SQLException;

	/**
	 * 查询报销信息
	 * 
	 * @param pageModel
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	PageModel<Expend> queryExpend(PageModel<Expend> pageModel, String configType, String name, String type, String status) throws SQLException;

	/**
	 * 查询报销信息的总数
	 * 
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	int queryExpendCnt(String name, String type, String status) throws SQLException;

	/**
	 * 添加报销信息
	 * 
	 * @param expend
	 * @throws SQLException
	 */
	void addExpend(Expend expend) throws SQLException;

	/**
	 * 查询最后一个报销编号
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryExpendNo(int cnt) throws SQLException;

	/**
	 * 删除报销信息
	 * 
	 * @param expendNo
	 * @throws SQLException
	 */
	void deletExpend(String expendNo) throws SQLException;

	/**
	 * 通过编号查询详细报销信息
	 * 
	 * @param expendNo
	 * @return
	 * @throws SQLException
	 */
	Expend queryExpendByNo(String configType, String expendNo) throws SQLException;

	/**
	 * 修改报销信息
	 * 
	 * @param expend
	 * @throws SQLException
	 */
	void modifyExpend(Expend expend) throws SQLException;
}
