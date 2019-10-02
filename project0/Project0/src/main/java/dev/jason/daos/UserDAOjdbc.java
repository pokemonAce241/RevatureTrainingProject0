package dev.jason.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.entities.User;
import dev.jason.utils.ConnectionUtil;

public class UserDAOjdbc implements UserDAO{

	@Override
	public User createUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "INSERT INTO Project0.bankUser values (?,?,?,?)";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, 0);
	    	   ps.setString(2, user.getUsername());
	    	   ps.setString(3, user.getPassword());
	    	   ps.setString(4, user.getAuthority());
	    	   
	    	   ps.execute();
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public User getUserById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project0.bankUser where id = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, id);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   User user = new User();
	    	   
	    	   user.setId(rs.getInt("id"));
	    	   user.setUsername(rs.getString("username"));
	    	   user.setPassword(rs.getString("password"));
	    	   user.setAuthority(rs.getString("authority"));
	    	   
	    	   return user;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public User getUserByUsername(String username) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project0.bankUser where username = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setString(1, username);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   User user = new User();
	    	   
	    	   user.setId(rs.getInt("id"));
	    	   user.setUsername(rs.getString("username"));
	    	   user.setPassword(rs.getString("password"));
	    	   user.setAuthority(rs.getString("authority"));
	    	   
	    	   return user;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String Password) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   
	    	   String sql = "SELECT * from Project0.bankUser where username = ? AND password = ?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setString(1, username);
	    	   ps.setString(2, Password);
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   rs.next();
	    	   
	    	   User user = new User();
	    	   
	    	   user.setId(rs.getInt("id"));
	    	   user.setUsername(rs.getString("username"));
	    	   user.setPassword(rs.getString("password"));
	    	   user.setAuthority(rs.getString("authority"));
	    	   
	    	   return user;
	    	   
	    	   
	       }catch(SQLException e){
	    	 //  e.printStackTrace();
	       }
			return null;
	}

	@Override
	public User updateUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
	    	   String sql = "UPDATE Project0.bankUser SET id = ?, username = ?, password = ?, authority = ? WHERE id = ?";
	    	   
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   ps.setInt(1, user.getId());
	    	   ps.setString(2, user.getUsername());
	    	   ps.setString(3, user.getPassword());
	    	   ps.setString(4, user.getAuthority());
	    	   ps.setInt(5, user.getId());
	    	   
	    	   ps.execute();
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	 //  e.printStackTrace();
	       }
			return null;
	}

	@Override
	public User deleteUser(User user) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE from Project0.bankUser WHERE id=?";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   ps.setInt(1, user.getId());
	    	   ps.execute();
	    	   
	    	   return user;
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

	@Override
	public Set<User> getAllUsers() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * from Project0.bankUser";
	    	   PreparedStatement ps = conn.prepareStatement(sql);
	    	   
	    	   Set<User> Users = new HashSet<User>();
	    	   
	    	   ResultSet rs = ps.executeQuery();
	    	   
	    	   while(rs.next()){
	    		   User user = new User();
		    	   
		    	   user.setId(rs.getInt("id"));
		    	   user.setUsername(rs.getString("username"));
		    	   user.setPassword(rs.getString("password"));
		    	   user.setAuthority(rs.getString("authority"));
		    	   
		    	   Users.add(user);
	    	   }
	    	   return Users;
	    	   
	    	   
	       }catch(SQLException e){
	    	  // e.printStackTrace();
	       }
			return null;
	}

}
