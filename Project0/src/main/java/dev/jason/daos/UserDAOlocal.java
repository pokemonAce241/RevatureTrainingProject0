package dev.jason.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dev.jason.entities.User;


public class UserDAOlocal implements UserDAO {
	
	// To be replaced with proper connection with sql
		public static final Map<Integer,User> usertable = new HashMap<Integer,User>();
		
	   
		private static int idmaker = 1000;

	public User createUser(User user) {

		idmaker++;
		user.setId(idmaker);
		usertable.put(idmaker, user); // add to sql database
		return user;
	}

	public User getUserById(int id) {
		User user = usertable.get(id);
		return user;
	}

	public User getUserByUsername(String username) {
		
		List<User> users = new ArrayList<User>(usertable.values()); //find user in sql
		
		try{
			users.removeIf((user) -> {
				
				if(user.getUsername().equals(username)){
					return false;
				}else{
					return true;
				}
			}				
					);
			return users.get(0);
			
		} catch(Exception e){
			return null;
		}		
				
	}
	
	
	public User getUserByUsernameAndPassword(String username, String Password) {
		List<User> users = new ArrayList<User>(usertable.values()); //find user in sql
		
		try{
			users.removeIf((user) -> {
				
				if(user.getUsername().equals(username) && user.getPassword().equals(Password)){
					return false;
				}else{
					return true;
				}
			}				
					);
			return users.get(0);
			
		} catch(Exception e){
			return null;
		}
			
	}

	public User updateUser(User user) {
		usertable.put(user.getId(), user);// update user in sql
		return user;
	}

	public User deleteUser(User user) {
		return usertable.remove(user.getId());// remove user from sql
		//return result;
	}

	@Override
	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
