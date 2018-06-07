package com.njwb.joybeans.service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.ConsumeRecord;
import com.njwb.joybeans.pojo.wrapper.ConsumeRecordWrapper;
import com.njwb.joybeans.util.PageModel;

/**
 * 消费记录的业务操作层
 * 
 * @author soft01
 * 
 */
public interface ConsumeRecordService {
	/**
	 * 通过用户ID和游戏ID查询消费记录
	 * 
	 * @return
	 * @throws JoybeansException
	 */
	ConsumeRecord queryByUserIdAndGameId(String consumerId, String gameId) throws JoybeansException;

	/**
	 * 分页查询某用户的消费记录
	 * 
	 * @param gameName
	 * @param gameType
	 * @return
	 */
	PageModel<ConsumeRecordWrapper> queryAllConsumerRecordByConsumerId(int pageNo, int pageSize, String consumerId) throws JoybeansException;

	/**
	 * 生成消费记录
	 * 
	 * @throws JoybeansException
	 */
	void createConsumeRecord(String userAccount, String consumerId, String gameId, double price, String buyType, int sendBeansRatio) throws JoybeansException;

	/**
	 * 下载成功后更新下载次数
	 * 
	 * @param id
	 * @throws JoybeansException
	 */
	void updateDownCnt(String id) throws JoybeansException;
}
