
package com.link.spring.jdbc.service;

import java.util.List;

import com.link.spring.jdbc.vo.User;

/**
 * User Service.
 */
public interface UserService {

	/**
	 * 查询用户
	 * 
	 * @return
	 */
	List<User> listUser();
}
