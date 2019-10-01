package dev.jason.services;

import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.entities.User;

public interface UserService {
	
	User login(String username, String password);
	
	User createNewUser(int id, String username, String password, String authority);
	
	User removeUser(User user);
	
	User updateUser(User user);
	
	Set<User> getCurrentUsers();
	
	Set<Account> getCurrentUserAccount(int id);
	
	Account createNewAccount(int id, int userId, String accountname, double balance);
	
	Account removeAccount(Account account);
	
	Account removeSuperAccount(Account account);
	
	Account getAccount(int userId, String accountname);
	
	double getCurrentAccountBalance(Account account);
	
	double makeAWithdraw(Account account,double amount);
	
	double makeADeposit(Account account,double amount);
	
	

}
