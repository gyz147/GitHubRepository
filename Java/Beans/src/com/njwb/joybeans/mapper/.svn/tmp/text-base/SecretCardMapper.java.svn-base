package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.SecretCard;

/**
 * 密保卡数据操作层
 * 
 * @author soft01
 * 
 */
public interface SecretCardMapper {

	/**
	 * 查询所有密保卡
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<SecretCard> queryAllByCondition(Map<String, Object> param) throws Exception;

	/**
	 * 查询所有密保卡的总数
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int queryCnt(Map<String, Object> param) throws Exception;

	/**
	 * 批量生成密保卡
	 * 
	 * @param
	 * @throws SQLException
	 */
	void insertSecretCards(Map<String, Object> param) throws Exception;

	/**
	 * 通过账号密码查询密保卡
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	SecretCard querySecretPrice(Map<String, String> param) throws Exception;

	/**
	 * 更新密保卡的状态
	 * 
	 * @param id
	 * @throws Exception
	 */
	void updateSecretStatus(String id) throws Exception;
}
