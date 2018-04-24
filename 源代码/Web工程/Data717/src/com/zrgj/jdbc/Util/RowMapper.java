package com.zrgj.jdbc.Util;

import java.sql.ResultSet;

public interface RowMapper<T> {
	public T rowMapper(ResultSet rs)throws Exception;
}
