
package com.link.spring.jdbc.service;

import java.util.List;

import com.link.spring.jdbc.vo.User;

/**
 * User Service.
 */
public interface UserService {

	/**
	 * 初始化User表
	 */
	void createUserTable();

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 查询用户
	 * 
	 * @return
	 */
	List<User> listUser();
}
