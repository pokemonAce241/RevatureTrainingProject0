package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.utils.ConnectionUtil;

public class AccountDAOjdbc implements AccountDAO {

	@Override
	public Account createAccount(Account account) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "INSERT INTO Project0.account values (?,?,?,?)";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, 0);
	    	   ps.setInt(2, account.getUserId());
	    	   ps.setString(3, account.getAccountName());
	    	   ps.setDouble(4, account.getBalance());
	    	   
	    	   ps.execute();
	    	   return account;
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Account getAccountById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project0.account where id = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   Account account = new Account();
	    	   
	    	   account.setId(rs.getInt("id"));
	    	   account.setUserId(rs.getInt("userid"));
	    	   account.setAccountName(rs.getString("accountName"));
	    	   account.setBalance(rs.getDouble("balance"));
	    	   
	    	   return account;
	    	   
	    	   
	       }catch(SQLException e){
	    	   //e.printStackTrace();
	       }
			return null;
	}

	/*
	@Override
	public Account getAccountByUserId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	
			String sql = "SELECT * from Project0.account where userid = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   Account account = new Account();
	    	   
	    	   account.setId(rs.getInt("id"));
	    	   account.setUserId(rs.getInt("userid"));
	    	   account.setAccountName(rs.getString("accountName"));
	    	   account.setBalance(rs.getDouble("balance"));
	    	   
	    	   return account;
	    	   
	    	   
	       }catch(SQLException e){
	    	   e.printStackTrace();
	       }
			return null;
	}
	
	*/

	

	@Override
	public Set<Account> getAllAccounts() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * from Project0.account";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   Set<Account> accounts = new HashSet<Account>();
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   while(rs.next()){
	    		   Account account = new Account();
		    	   
		    	   account.setId(rs.getInt("id"));
		    	   account.setUserId(rs.getInt("userid"));
		    	   account.setAccountName(rs.getString("accountName"));
		    	   account.setBalance(rs.getDouble("balance"));
		    	   
		    	   accounts.add(account);
	    	   }
	    	   return accounts;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Set<Account> getAllAcountsByUserId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * from Project0.account where userid = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);   
	    	   Set<Account> accounts = new HashSet<Account>();
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   while(rs.next()){
	    		   Account account = new Account();
		    	   
		    	   account.setId(rs.getInt("id"));
		    	   account.setUserId(rs.getInt("userid"));
		    	   account.setAccountName(rs.getString("accountName"));
		    	   account.setBalance(rs.getDouble("balance"));
		    	   
		    	   accounts.add(account);
	    	   }
	    	   return accounts;
	    	   
	    	   
	    	   
	       }catch(SQLException e){
	    	   //e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Account updateAccount(Account account) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   String sql = "UPDATE Project0.account SET id = ?,userid = ?,accountName = ?, balance = ? WHERE id = ?";
	    	   
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, account.getId());
	    	   ps.setInt(2, account.getUserId());
	    	   ps.setString(3, account.getAccountName());
	    	   ps.setDouble(4, account.getBalance());
	    	   ps.setInt(5, account.getId());
	    	   
	    	   ps.execute();
	    	   return account;
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Account deleteAccount(Account account) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE from Project0.account WHERE id=?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, account.getId());
	    	   ps.execute();
	    	   
	    	   return account;
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Account getAccountByUserIdAndAccountName(int id, String accountName) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	
			String sql = "SELECT * from Project0.account where userid = ? AND accountName = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   ps.setString(2, accountName);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   Account account = new Account();
	    	   
	    	   account.setId(rs.getInt("id"));
	    	   account.setUserId(rs.getInt("userid"));
	    	   account.setAccountName(rs.getString("accountName"));
	    	   account.setBalance(rs.getDouble("balance"));
	    	   
	    	   return account;
	    	   
	    	   
	       }catch(SQLException e){
	    	 //  e.printStackTrace();
	       }
			return null;
	}

}
