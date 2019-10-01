package dev.jason.services;

import java.util.Set;

import dev.jason.daos.UserDAO;
import dev.jason.daos.UserDAOjdbc;
import dev.jason.daos.UserDAOlocal;
import dev.jason.entities.Account;
import dev.jason.entities.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO udao = new UserDAOjdbc();
	private AccountService as = new AccountServiceImpl();
	
	@Override
	public User login(String username, String password) {
		return udao.getUserByUsernameAndPassword(username, password);
	}
	@Override
	public User createNewUser(int id, String username, String password, String authority) {
		User user = new User(id,username,password,authority,null);
		return udao.createUser(user);
	}
	@Override
	public User removeUser(User user) {
		
		return udao.deleteUser(user);
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return udao.updateUser(user);
	}
	@Override
	public Set<User> getCurrentUsers() {
		return udao.getAllUsers();
	}
	
	@Override
	public Set<Account> getCurrentUserAccount(int id) {
		return as.getCurrentUserAccounts(id);
	}
	
	@Override
	public Account createNewAccount(int id, int userId, String accountname, double balance) {
		Account account = new Account(id,userId,accountname,balance);
		return as.createAccount(account);
	}
	@Override
	public Account removeAccount(Account account) {
		return as.deleteAccount(account);
	}
	
	@Override
	public Account removeSuperAccount(Account account) {
		return as.deleteSuperAccount(account);
	}
	
	@Override
	public Account getAccount(int userid,String accountname) {
		return as.getAccountByUserIdandAccountName(userid, accountname);
	}
	@Override
	public double getCurrentAccountBalance(Account account) {
		return as.currentBalance(account);
	}
	@Override
	public double makeAWithdraw(Account account, double amount) {
		double check = as.currentBalance(account);
		if(amount < check){
			check = check-amount;
			account.setBalance(check);
			as.Transaction(account);
			return check;
			
		}else{
			return 0;
		}
		
	}
	@Override
	public double makeADeposit(Account account, double amount) {
		double check = as.currentBalance(account);
		
		check = check+amount;
		account.setBalance(check);
		as.Transaction(account);
		return check;
	}
	
	
	
	
	
	
	
	

	

	

}
