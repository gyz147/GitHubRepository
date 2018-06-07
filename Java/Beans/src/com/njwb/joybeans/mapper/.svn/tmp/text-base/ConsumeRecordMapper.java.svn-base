package com.njwb.joybeans.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.ConsumeRecord;
import com.njwb.joybeans.pojo.wrapper.ConsumeRecordWrapper;

/**
 * 下载记录的数据操作层
 * 
 * @author soft01
 * 
 */
public interface ConsumeRecordMapper {
	/**
	 * 通过用户ID和游戏ID查询下载记录
	 * 
	 * @return
	 * @throws Exception
	 */
	ConsumeRecord queryByUserIdAndGameId(Map<String, String> param) throws Exception;

	/**
	 * 查询某用户的消费记录
	 * 
	 * @param consumerId
	 * @return
	 * @throws Exception
	 */
	List<ConsumeRecordWrapper> queryByConsumerId(Map<String, String> param) throws Exception;

	/**
	 * 查询某用户的消费记录的总数
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int queryCnt(Map<String, String> param) throws Exception;

	/**
	 * 生成消费记录
	 * 
	 * @throws Exception
	 */
	void insertConsumeRecord(ConsumeRecord consumeRecord) throws Exception;

	/**
	 * 更新某条下载记录的下载次数
	 * 
	 * @param id
	 * @throws Exception
	 */
	void updateDownLoadCnt(String id) throws Exception;
}
