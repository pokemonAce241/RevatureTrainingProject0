package dev.jason.daotest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import dev.jason.daos.AccountDAO;
import dev.jason.daos.AccountDAOjdbc;
import dev.jason.daos.AccountDAOlocal;
import dev.jason.daos.UserDAO;
import dev.jason.daos.UserDAOlocal;
import dev.jason.entities.Account;
import junit.framework.Assert;

public class AccountDAOtest {
	
	public static AccountDAO adao = new AccountDAOjdbc();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
/*
	@Test
	public void createAccount() {
		Account account = new Account(0,3,"emergancy",500.50);
		adao.createAccount(account);
		
		Assert.assertEquals(account, adao.getAccountById(6));
		
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void getAccountById() {
		Account account = adao.getAccountById(3);
		Assert.assertEquals(3,account.getId());
		Assert.assertEquals(2,account.getUserId());
		Assert.assertEquals("saving",account.getAccountName());
		Assert.assertEquals(3593.65,account.getBalance());
		//fail("Not yet implemented");
		
		Account fail = adao.getAccountById(7);
		
		Assert.assertNull(fail);
	}
	*/
	@Test
	public void getAccountByUserIdAndAccountName(){
		Account account = adao.getAccountByUserIdAndAccountName(2, "food");
		Assert.assertEquals(4,account.getId());
		Assert.assertEquals(2,account.getUserId());
		Assert.assertEquals("food",account.getAccountName());
		Assert.assertEquals(157.31,account.getBalance());
		
		Account fail = adao.getAccountByUserIdAndAccountName(2, "fail");
		Assert.assertNull(fail);
		
		
	}
	/*
	@Test
	public void getAllAcounts() {
		Set<Account> accounts = adao.getAllAccounts();
		Assert.assertEquals(6, accounts.size());
		//fail("Not yet implemented");
	}
	
	@Test
	public void getAllAcountsByUserId() {
		Set<Account> accounts = adao.getAllAcountsByUserId(1);
		
		Account account1 = adao.getAccountById(1);
		Account account2 = adao.getAccountById(2);
		
		Assert.assertEquals(2, accounts.size());
		
		Assert.assertEquals(true, accounts.contains(account1));
		Assert.assertEquals(true, accounts.contains(account2));
		
		Set<Account> fail = adao.getAllAcountsByUserId(4);
		Assert.assertEquals(0,fail.size());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void updateAccount() {
		
		Account account = new Account(6,3,"maintenance",251.64);
		
		adao.updateAccount(account);
		
		Account check = adao.getAccountById(6);
		
		Assert.assertEquals(6,check.getId());
		Assert.assertEquals(3,check.getUserId());
		Assert.assertEquals("maintenance",check.getAccountName());
		Assert.assertEquals(251.64,check.getBalance());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void deleteAccount() {
		Account account = adao.getAccountById(6);
		adao.deleteAccount(account);
		
		Set<Account> accounts = adao.getAllAccounts();
		
		Assert.assertEquals(5,accounts.size());
		Assert.assertEquals(false, accounts.contains(account));
		
		//fail("Not yet implemented");
	}
    */
}
