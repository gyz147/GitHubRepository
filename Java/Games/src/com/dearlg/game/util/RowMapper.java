package com.dearlg.game.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
	public abstract Object mapperObject(ResultSet rs)throws SQLException;
}
