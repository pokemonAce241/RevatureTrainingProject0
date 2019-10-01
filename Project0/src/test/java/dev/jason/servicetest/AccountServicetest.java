package dev.jason.servicetest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jason.entities.Account;
import dev.jason.services.AccountService;
import dev.jason.services.AccountServiceImpl;

public class AccountServicetest {
	
	public static AccountService as = new AccountServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    /*
	@Test
	public void createAccount() {
		
		Account account = new Account(0,1,"emergancy",542.34);
		as.createAccount(account);
		Assert.assertEquals(account, as.getAccountByUserIdandAccountName(1, "emergancy"));
		//fail("Not yet implemented");
	}
	*/
	/*
	@Test
	public void deleteAccount() {
		Account account = as.getAccountByUserIdandAccountName(1, "emergancy");
		
		Assert.assertNull(as.deleteAccount(account));
		account.setBalance(0.00);
		as.Transaction(account);
		Account check = as.getAccountByUserIdandAccountName(1, "emergancy");
		System.out.println(check.getBalance());
		Assert.assertNull(check);
		//fail("Not yet implemented");
	}
	
	
	
	
	@Test
	public void Transaction() {
		
		Account account = as.getAccountByUserIdandAccountName(2, "saving");
		account.setBalance(2340.50);
		as.Transaction(account);
		Account check = as.getAccountByUserIdandAccountName(2, "saving");
		Assert.assertEquals(2340.50, check.getBalance());
		//fail("Not yet implemented");
	}
	*/
	@SuppressWarnings("deprecation")
	@Test
	public void getAccountByUserIdandAccountName() {
		Account account = as.getAccountByUserIdandAccountName(2, "food");
		Assert.assertEquals(2, account.getUserId());
		//Assert.assertEquals(157.31, account.getBalance());
		System.out.println(account.getUserId());
		System.out.println(account.getBalance());
		System.out.println(account.getAccountName());
		//fail("Not yet implemented");
	}
	
	/*
	@Test
	public void getCurrentUserAccounts() {
		
		Set<Account> accounts = as.getCurrentUserAccounts(2);
		Assert.assertEquals(2,accounts.size());
		Assert.assertEquals(true,accounts.contains(as.getAccountByUserIdandAccountName(2, "saving")));
		Assert.assertEquals(true,accounts.contains(as.getAccountByUserIdandAccountName(2, "food")));
		//fail("Not yet implemented");
	}
	
	@Test
	public void currentBalance() {
		Account account = as.getAccountByUserIdandAccountName(1, "checking");
		System.out.println(as.currentBalance(account));
		Assert.assertEquals(298.45, as.currentBalance(account));
		
		
		//fail("Not yet implemented");
	}
	*/

}
