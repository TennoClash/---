package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UsersDAO;
import com.entity.Users;
import com.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	@Resource
	private UsersDAO usersDAO;

	@Override
	public int insertUsers(Users users) {
		return this.usersDAO.insertUsers(users);
	}

	@Override
	public int updateUsers(Users users) {
		return this.usersDAO.updateUsers(users);
	}

	@Override
	public int deleteUsers(String usersid) {
		return this.usersDAO.deleteUsers(usersid);
	}

	@Override
	public List<Users> getAllUsers() {
		return this.usersDAO.getAllUsers();
	}

	@Override
	public List<Users> getUsersByCond(Users users) {
		return this.usersDAO.getUsersByCond(users);
	}

	@Override
	public List<Users> getUsersByLike(Users users) {
		return this.usersDAO.getUsersByLike(users);
	}

	@Override
	public Users getUsersById(String usersid) {
		return this.usersDAO.getUsersById(usersid);
	}

}
