package dev.jason.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.entities.User;




public class AccountDAOlocal implements AccountDAO {
	
	// To be replaced with proper connection with sql
	public static final Map<Integer,Account> accounttable = new HashMap<Integer,Account>();  
	private static int idmaker = 1000;

	@Override
	public Account createAccount(Account account) {
		idmaker++;
		account.setId(idmaker);
		accounttable.put(idmaker, account);
		return account;
	}

	@Override
	public Account getAccountById(int id) {
		Account account = accounttable.get(id);
		return account;
	}
	
	/*
	@Override
	public Account getAccountByUserId(int id) {
		List<Account> userAccount = new ArrayList<Account>(accounttable.values());
		
		userAccount.removeIf((account)->{
			if(account.getUserId() == id){
				return false;
			}else{
				return true;
			}
		});
		return userAccount.get(0);
	}
	*/
	
	@Override
	public Account getAccountByUserIdAndAccountName(int id, String accountName) {
		List<Account> userAccount = new ArrayList<Account>(accounttable.values());
		
		userAccount.removeIf((account)->{
			if(account.getUserId() == id && account.getAccountName().equals(accountName)){
				return false;
			}else{
				return true;
			}
		});
		return userAccount.get(0);
	}
	
	
	
	
	@Override
	public Set<Account> getAllAccounts() {
		
		Set<Account> accounts = new HashSet<Account>(accounttable.values());
		return accounts;
	}

	@Override
	public Set<Account> getAllAcountsByUserId(int id) {
		Set<Account> accounts = new HashSet<Account>(accounttable.values());
		
		accounts.removeIf((account)->{
			if(account.getUserId() == id){
				return false;
			}else{
				return true;
			}
		});
		return accounts;
	}
	
	

	@Override
	public Account updateAccount(Account account) {
		accounttable.put(account.getId(), account);
		return account;
	}

	@Override
	public Account deleteAccount(Account account) {
		return accounttable.remove(account.getId());
		
	}

	

	

	

	

	

	

}
