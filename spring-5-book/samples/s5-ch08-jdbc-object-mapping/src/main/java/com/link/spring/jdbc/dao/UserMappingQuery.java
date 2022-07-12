
package com.link.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.link.spring.jdbc.vo.User;

/**
 * User MappingQuery.
 */
public class UserMappingQuery extends MappingSqlQuery<User> {

	public UserMappingQuery(DataSource dataSource) {
        super(dataSource, "SELECT username, age FROM USER");
        compile();
	}

	/**
	 * 行映射
	 * @param rs 结果集
	 * @param rowNumber	结果所在行
	 * @return
	 * @throws SQLException
	 */
	@Override
	protected User mapRow(ResultSet rs, int rowNumber) throws SQLException {

		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setAge(rs.getInt("age"));
		return user;
	}

}
