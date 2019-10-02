package dev.jason.services;

import java.util.Set;

import dev.jason.daos.AccountDAO;
import dev.jason.daos.AccountDAOjdbc;
import dev.jason.daos.AccountDAOlocal;
import dev.jason.entities.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO adao = new AccountDAOjdbc();
	
	@Override
	public Account createAccount(Account account) {
		Account result = adao.createAccount(account);
		return result;
	}

	@Override
	public Account deleteAccount(Account account) {
		
		Account check = adao.getAccountById(account.getId());
		if(check.getBalance() != 0.00){
			return null;
		}
		else{
			return adao.deleteAccount(account);
			
		}
		
		
	}
	
	
	
	@Override
	public Account deleteSuperAccount(Account account) {
		return adao.deleteAccount(account);
	}
	
	
	@Override
	public Account Transaction(Account account){
		return adao.updateAccount(account);
	}

	

	@Override
	public double currentBalance(Account account) {
		Account balance = adao.getAccountById(account.getId());
		return balance.getBalance();
	
	}

	@Override
	public Account getAccountByUserIdandAccountName(int id, String accountName) {
		Account result = adao.getAccountByUserIdAndAccountName(id, accountName);
		return result;
	}

	@Override
	public Set<Account> getCurrentUserAccounts(int userid) {
		return adao.getAllAcountsByUserId(userid);
	}

	

	

	

}
