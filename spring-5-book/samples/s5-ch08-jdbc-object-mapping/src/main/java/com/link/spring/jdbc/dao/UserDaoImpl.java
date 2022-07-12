
package com.link.spring.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.link.spring.jdbc.vo.User;

/**
 * User DAO.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
	private UserMappingQuery userMappingQuery;
	private UserSqlUpdate userSqlUpdate;
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.userMappingQuery = new UserMappingQuery(dataSource);
        this.userSqlUpdate = new UserSqlUpdate(dataSource);
    }
	    
	public void saveUser(User user) {
		this.userSqlUpdate.execute(user);
	}

	public List<User> listUser() {
		return this.userMappingQuery.execute();
	}

	public void createUserTable() {
		 this.jdbcTemplate.execute("CREATE TABLE USER (USERNAME varchar(250),AGE INT)");
	}

}
