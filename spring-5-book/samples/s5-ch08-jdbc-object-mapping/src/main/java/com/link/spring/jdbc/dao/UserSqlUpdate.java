
package com.link.spring.jdbc.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import com.link.spring.jdbc.vo.User;

/**
 * User SqlUpdate.
 */
public class UserSqlUpdate extends SqlUpdate {
	
	public UserSqlUpdate(DataSource ds) {
        // 设置数据源
        setDataSource(ds);
        // 设置sql
        setSql("INSERT INTO USER (username, age) VALUES (?, ?)");
        // 声明参数
        declareParameter(new SqlParameter("username", Types.VARCHAR));
        // 声明参数
        declareParameter(new SqlParameter("age", Types.NUMERIC));
        compile();
    }

    /**
     * 执行方法
     * @param user
     * @return
     */
	 public int execute(User user) {
	    return update( user.getUsername(), user.getAge());
	}

}
