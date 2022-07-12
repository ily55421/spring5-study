
package com.link.spring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.link.spring.jdbc.dao.UserDao;
import com.link.spring.jdbc.vo.User;

/**
 * User Service.
 */
@Service
public class UserServiceImpl implements UserService {

	private UserDao userdao;
	
    @Autowired
    public void setUserDao(UserDao userdao) {
        this.userdao = userdao;
    }

	public void createUserTable() {
		userdao.createUserTable();
	}
	
	public void saveUser(User user) {
		userdao.saveUser(user);
	}

	public List<User> listUser() {
		return userdao.listUser();
	}

}
