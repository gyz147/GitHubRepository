package com.njwb.oa.service;

/**
 * 报销业务操作类
 */
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Expend;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

public interface ExpendService {
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws OAException;

	/**
	 * 查询总报销信息
	 * 
	 * @param pageModel
	 * @param configType
	 * @param name
	 * @param type
	 * @param status
	 * @return
	 * @throws OAException
	 */
	PageModel<Expend> queryExpend(int pageNo, int pageSize, String configType, String name, String type, String status) throws OAException;

	/**
	 * 添加报销信息
	 * 
	 * @param expend
	 * @throws OAException
	 */
	void addExpend(Expend expend) throws OAException;

	/**
	 * 查询最后一个报销编号
	 * 
	 * @param cnt
	 * @return
	 */
	int queryExpendNo() throws OAException;

	/**
	 * 删除报销信息
	 * 
	 * @param expendNo
	 * @throws OAException
	 */
	void deletExpend(String expendNo) throws OAException;

	/**
	 * 通过编号查询详细报销信息
	 * 
	 * @param configType
	 * @param expendNo
	 * @return
	 * @throws OAException
	 */
	Expend queryExpendByNo(String configType, String expendNo) throws OAException;

	/**
	 * 修改报销信息
	 * 
	 * @param expend
	 * @throws OAException
	 */
	void modifyExpend(Expend expend) throws OAException;
}
