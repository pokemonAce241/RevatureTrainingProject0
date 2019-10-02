package dev.jason.services;

import java.util.Set;

import dev.jason.entities.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	
	Account deleteAccount(Account account);
	
	Account deleteSuperAccount(Account account);
	
	Account Transaction(Account account);
	
	Account getAccountByUserIdandAccountName(int id, String accountName);
	
	Set<Account> getCurrentUserAccounts(int userid);
	
	double currentBalance(Account account);

}
