package dev.jason.servicetest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jason.entities.Account;
import dev.jason.entities.User;
import dev.jason.services.AccountService;
import dev.jason.services.AccountServiceImpl;
import dev.jason.services.UserService;
import dev.jason.services.UserServiceImpl;

public class UserServicetest {
	
	public static UserService us = new UserServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
/*
	@Test
	public void login() {
		User userone = us.login("pokemonAce241", "412691Kirby");
		User usertwo = us.login("fdseresfer", "sersferte241");
		
		Assert.assertNull(usertwo);
		Assert.assertEquals("pokemonAce241", userone.getUsername());
		Assert.assertEquals("412691Kirby", userone.getPassword());
		//fail("Not yet implemented");
	}
	
	@Test
	public void creatNewUser() {
		us.createNewUser(0,"vikingKing42","8473Dot","registered");
		User check = us.login("vikingKing42", "8473Dot");
		
		Assert.assertEquals("vikingKing42", check.getUsername());
		Assert.assertEquals("8473Dot", check.getPassword());
		//fail("Not yet implemented");
	}
	
	@Test
	public void removeUser() {
		User user = us.login("vikingKing42", "8473Dot");
		us.removeUser(user);
		User noUser = us.login("vikingKing42", "8473Dot");
		Assert.assertNull(noUser);
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void updateUser() {
		User user = us.login("jareberry583", "usacor243");
		user.setAuthority("superuser");
		user.setPassword("penguinUSA464");
		us.updateUser(user);
		User check = us.login("jareberry583", "penguinUSA464");
		
		Assert.assertEquals("superuser",check.getAuthority());
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void getCurrentUsers() {
		Set<User> users = us.getCurrentUsers();
		for(User u: users){
			System.out.println(u);
		}
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void getAccount() {
		User user = us.login("pokemonAce241", "412691Kirby");
		Account account = us.getAccount(2, "food");
		System.out.println(account.getBalance());
		Assert.assertNull(account);
		
		//fail("Not yet implemented");
	}
	
		
	@Test
	public void createNewAccount() {
		User user = us.login("pokemonAce241", "412691Kirby");
		us.createNewAccount(0, user.getId(), "start", 0.00);
		//Assert.assertEquals(149.54,us.);
		fail("Not yet implemented");
	}
	

	@Test
	public void removeAccount() {
		Account account = us.getAccount(2,"saving");
		us.removeAccount(account);
		Account check = us.getAccount(2, "saving");
		Assert.assertEquals("saving",check.getAccountName());
		
		us.removeAccount(us.getAccount(1, "start"));
		Assert.assertNull(us.getAccount(1, "start"));
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void getCurrentAccountBalance() {
		Account account = us.getAccount(1, "checking");
		double check = us.getCurrentAccountBalance(account);
		System.out.println(check);
		fail("Not yet implemented");
	}
	
	@Test
	public void makeAWithdraw() {
		Account account = us.getAccount(3, "fun");
		us.makeAWithdraw(account, 50.00);
		
		Account sucess = us.getAccount(3, "fun");
		Assert.assertEquals(25.00, sucess.getBalance());
		
		us.makeAWithdraw(sucess, 50.00);
		
		Account fail = us.getAccount(3, "fun");
		Assert.assertEquals(25.00, sucess.getBalance());
		//fail("Not yet implemented");
	}
	*/
	@Test
	public void makeADeposit() {
		Account account = us.getAccount(3, "fun");
		us.makeADeposit(account, 50.00);
		
		Account sucess = us.getAccount(3, "fun");
		Assert.assertEquals(75.00, sucess.getBalance());
		
		fail("Not yet implemented");
	}
	
}
