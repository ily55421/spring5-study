
package com.link.spring.jdbc.dao;

import java.util.List;

import com.link.spring.jdbc.vo.User;

/**
 * User DAO.

 */
public interface UserDao {

	/**
	 * 查询用户
	 * 
	 * @return
	 */
	List<User> listUser();

}
