package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Users;

@Service("usersService")
public interface UsersService {
	public int insertUsers(Users users);

	public int updateUsers(Users users);

	public int deleteUsers(String usersid);

	public List<Users> getAllUsers();

	public List<Users> getUsersByCond(Users users);

	public List<Users> getUsersByLike(Users users);

	public Users getUsersById(String usersid);
}
