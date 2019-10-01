package dev.jason.services;

import dev.jason.entities.User;

public interface SuperUserService {
	
	User viewUsers();	
	
	User createUser(int id, String username, String password, String authority);
	
	User updateUser(int id, String username, String password, String authority);
	
	User deleteUser(int id);

}
