package dev.jason.daos;

import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.entities.User;

public interface UserDAO {
	
	//create
	User createUser(User user);
	
	//read
	User getUserById(int id);
	User getUserByUsername(String username);
	User getUserByUsernameAndPassword(String username, String Password);
	Set<User> getAllUsers();
	//update
	User updateUser(User user);
	
	//delete
	User deleteUser(User user);

}
