
package com.link.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.link.spring.jdbc.vo.User;

/**
 * User DAO.
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<User> listUser() {
		List<User> users = this.jdbcTemplate.query(
				// 查询结果集
				"SELECT username, age FROM USER",
				new RowMapper<User>() {
					// 对象映射
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setUsername(rs.getString("username"));
						user.setAge(rs.getInt("age"));
						return user;
					}
				});
		
		return users;
	}

}
