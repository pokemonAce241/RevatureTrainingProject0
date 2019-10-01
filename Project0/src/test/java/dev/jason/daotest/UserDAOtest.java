package dev.jason.daotest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dev.jason.daos.UserDAO;
import dev.jason.daos.UserDAOjdbc;
import dev.jason.daos.UserDAOlocal;
import dev.jason.entities.User;
import junit.framework.Assert;

public class UserDAOtest {
	
	public static UserDAO udao = new UserDAOjdbc();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void addUser() {
		
		User user = new User(0,"vikingking24","ffssll90","registered",null);
		
		udao.createUser(user);
		
		
		Assert.assertEquals(user, udao.getUserById(4));
		//fail("Not yet implemented");
	}
	
	@Test
	public void getUserbyId(){
		
		User user = udao.getUserById(2);		
		Assert.assertEquals(2, user.getId());
		Assert.assertEquals("jareberry583", user.getUsername());
		Assert.assertEquals("usacor243", user.getPassword());
		Assert.assertEquals("registered", user.getAuthority());
		
		User fail = udao.getUserById(5);
		Assert.assertNull(fail);
	}
	
	@Test
	public void getUserbyUsername(){
		
		User user = udao.getUserByUsername("jareberry583");		
		Assert.assertEquals(2, user.getId());
		Assert.assertEquals("jareberry583", user.getUsername());
		Assert.assertEquals("usacor243", user.getPassword());
		Assert.assertEquals("registered", user.getAuthority());
		
		User fail = udao.getUserByUsername("invalidUser");
		Assert.assertNull(fail);
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void getUserbyUsernameAndPassword(){
		
		User user = udao.getUserByUsernameAndPassword("jareberry583","usacor243");		
		Assert.assertEquals(2, user.getId());
		Assert.assertEquals("jareberry583", user.getUsername());
		Assert.assertEquals("usacor243", user.getPassword());
		Assert.assertEquals("registered", user.getAuthority());
		
		User failUser = udao.getUserByUsernameAndPassword("invalidUser","usacor243");
		User failPassword = udao.getUserByUsernameAndPassword("jareberry583","invalicPassword");
		
		Assert.assertNull(failUser);
		Assert.assertNull(failPassword);
		
		//fail("Not yet implemented");
		
	}
	
	@Test
	public void updateUser(){
		
		User user = new User(4,"vikingqueen34","ddoojj2","superUser",null);
		
		udao.updateUser(user);
		
		User check = udao.getUserById(4);
		Assert.assertEquals(4, user.getId());
		Assert.assertEquals("vikingqueen34", user.getUsername());
		Assert.assertEquals("ddoojj2", user.getPassword());
		Assert.assertEquals("superUser", user.getAuthority());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void removeUser(){
		
		User user = udao.getUserById(4);
		
		udao.deleteUser(user);
		
		User check = udao.getUserById(4);
		Assert.assertNull(check);
		
		//fail("Not yet implemented");
	}
	
	

}
