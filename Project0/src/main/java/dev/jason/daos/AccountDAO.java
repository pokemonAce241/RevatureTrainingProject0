package dev.jason.daos;

import java.util.Set;

import dev.jason.entities.Account;

public interface AccountDAO {
	//create
	Account createAccount(Account account);
	
	//read
	Account getAccountById(int id);
	//Account getAccountByUserId(int id);
	Account getAccountByUserIdAndAccountName(int id, String accountName);
	Set<Account> getAllAccounts();
	Set<Account> getAllAcountsByUserId(int id);
	
	//update
	Account updateAccount(Account account);
	
	//delete
	Account deleteAccount(Account account);

}
