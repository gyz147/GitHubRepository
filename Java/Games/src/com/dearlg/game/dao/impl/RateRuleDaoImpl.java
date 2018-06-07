package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.dao.RateRuleDao;
import com.dearlg.game.entity.RateRule;
import com.dearlg.game.entity.User;
import com.dearlg.game.util.JdbcTemplate;

public class RateRuleDaoImpl implements RateRuleDao {

	@SuppressWarnings("unchecked")
	@Override
	public RateRule queryByUser(User user) throws SQLException {
		RateRule rateRule = null;
		String sql = "select t_address,t_rate from t_rule where t_address=?";
		List<RateRule> raterulelist = JdbcTemplate.executeQuery(sql, new RateRuleMapper(), user.getAddress());
		if (raterulelist.size() > 0) {
			rateRule = raterulelist.get(0);
		}
		return rateRule;
	}

}
