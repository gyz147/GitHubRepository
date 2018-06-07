package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.ConsumeRecordMapper;
import com.njwb.joybeans.mapper.JoyBeansUserMapper;
import com.njwb.joybeans.pojo.ConsumeRecord;
import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.pojo.wrapper.ConsumeRecordWrapper;
import com.njwb.joybeans.service.ConsumeRecordService;
import com.njwb.joybeans.util.PageModel;

@Service("consumeRecordService")
public class ConsumeRecordServiceImpl implements ConsumeRecordService {
	@Autowired
	private ConsumeRecordMapper consumeRecordMapper;

	@Autowired
	private JoyBeansUserMapper joyBeansUserMapper;

	@Override
	public ConsumeRecord queryByUserIdAndGameId(String consumerId, String gameId) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("consumerId", consumerId);
		param.put("gameId", gameId);
		ConsumeRecord consumeRecord = null;
		try {
			consumeRecord = consumeRecordMapper.queryByUserIdAndGameId(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consumeRecord;
	}

	@Override
	public PageModel<ConsumeRecordWrapper> queryAllConsumerRecordByConsumerId(int pageNo, int pageSize, String consumerId) throws JoybeansException {
		PageModel<ConsumeRecordWrapper> pageModel = new PageModel<ConsumeRecordWrapper>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("consumerId", consumerId);
		try {
			List<ConsumeRecordWrapper> list = consumeRecordMapper.queryByConsumerId(param);
			int cnt = consumeRecordMapper.queryCnt(param);
			pageModel.setDataList(list);
			pageModel.setCnt(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Transactional
	@Override
	public void createConsumeRecord(String userAccount, String consumerId, String gameId, double price, String buyType, int sendBeansRatio) throws JoybeansException {
		if ("2".equals(buyType)) {
			sendBeansRatio = 0;
		}
		ConsumeRecord consumeRecord = new ConsumeRecord();
		consumeRecord.setConsumerId(consumerId);
		consumeRecord.setGameId(gameId);
		consumeRecord.setPrice(price);
		consumeRecord.setBuyType(buyType);
		consumeRecord.setSendBeans((int) (price * sendBeansRatio));
		JoyBeansUser joyBeansUser = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", consumerId);
		try {
			consumeRecordMapper.insertConsumeRecord(consumeRecord);
			joyBeansUser = joyBeansUserMapper.queryBalance(userAccount);
			if ("1".equals(buyType)) {
				param.put("feeBalance", Integer.valueOf(joyBeansUser.getFeeBalance()) - price);
				param.put("beansBalance", Integer.valueOf(joyBeansUser.getBeansBalance()) + (int) (price * sendBeansRatio));
				param.put("secretBalance", joyBeansUser.getSecretBalance());
			} else if ("2".equals(buyType)) {
				param.put("feeBalance", joyBeansUser.getFeeBalance());
				if (Integer.valueOf(joyBeansUser.getSecretBalance()) >= price) {
					param.put("beansBalance", joyBeansUser.getBeansBalance());
					param.put("secretBalance", Integer.valueOf(joyBeansUser.getSecretBalance()) - price);
				} else {
					param.put("beansBalance", Integer.valueOf(joyBeansUser.getBeansBalance()) + Integer.valueOf(joyBeansUser.getSecretBalance()) - price);
					param.put("secretBalance", 0);
				}
			}
			joyBeansUserMapper.updateBalance(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void updateDownCnt(String id) throws JoybeansException {
		try {
			consumeRecordMapper.updateDownLoadCnt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
