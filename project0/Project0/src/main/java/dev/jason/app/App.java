package dev.jason.app;

import java.util.Scanner;
import java.util.Set;

import dev.jason.entities.Account;
import dev.jason.entities.User;
import dev.jason.services.UserService;
import dev.jason.services.UserServiceImpl;

public class App {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		UserService us = new UserServiceImpl();
		User user = null;
		
		int command;
		
		System.out.print("Type in username");
		String username = scan.next();
		System.out.print("Type in password");
		String password = scan.next();
		
		user = us.login(username, password);
		if(user == null){
			user = us.createNewUser(0, username, password, "registered");
			System.out.println("New user registered");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Welcome to your revature bank account");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		do{
			System.out.println("Main Menu");
			System.out.println("1) View current accounts and balances");
			System.out.println("2) Create an account");
			System.out.println("3) Delete an account");
			System.out.println("4) Make a withdraw");
			System.out.println("5) Make a deposit");
			System.out.println("6) View current users(SuperUser only)");
			System.out.println("7) Create a new user(SuperUser only)");
			System.out.println("8) Update a user(SuperUser only)");
			System.out.println("9)  Delete a user(SuperUser only)");
			System.out.println("10) logout");
			command = scan.nextInt();	
			
			switch(command){
				case 1:
					System.out.println("Current accounts user has:");
					Set<Account> accounts = us.getCurrentUserAccount(user.getId());
					for(Account a: accounts){
						System.out.println("AccountName: " + a.getAccountName());
						System.out.println("Balance: " + a.getBalance());
						System.out.println("");
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 2:
					Account newAccount = null;
					
						System.out.println("Type in account name");
						System.out.println("Accountname:");
						String createaccountname = scan.next();
						
						newAccount = us.createNewAccount(0, user.getId(), createaccountname, 0.0);
						System.out.println("New Account " + createaccountname + " created");
						
					
					
					break;
					
					
				case 3:
					Account newAccoun = null;
					while(newAccoun == null){
						System.out.println("Type in name of account you wish to delete");
						System.out.println("Accountname:");
						String getaccountname = scan.next();
						
						newAccoun= us.getAccount(user.getId(), getaccountname);
						if(newAccoun == null){
							System.out.println("Attempt failed. Account doesn't exist or the name was incorrectly typed Please try again");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					Account check = us.removeAccount(newAccoun);
					if(check == null){
						System.out.println("Account still contains currency. Invalid for deletion");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else{
						System.out.println("Account deleted");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
					
					
				case 4:
					Account newAccountthree = null;
					while(newAccountthree == null){
						System.out.println("Type in name of account you with to make a withdraw from");
						System.out.println("Accountname:");
						String getaccountname = scan.next();
						
						newAccountthree= us.getAccount(user.getId(), getaccountname);
						if(newAccountthree == null){
							System.out.println("Attempt failed. Account doesn't exist or name was incorrectly typed. Please try again");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					double result = -2;
					while(result == -2){
						System.out.println("Enter the amount you wish to withdraw");
						double withdraw = scan.nextDouble();
						result = us.makeAWithdraw(newAccountthree, withdraw);
						if(result == -2){
							System.out.println("Amount requested exceeds amount currently in account. Try another amount");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(result == -1)
						System.out.println("No currency available. Withdraw canceled");
					else
					System.out.println("Transaction successful. New balance is " + us.getCurrentAccountBalance(newAccountthree));
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					
					
				case 5:
					Account newAccountdeposit = null;
					while(newAccountdeposit == null){
						System.out.println("Type in name of account you wish to make a withdraw from");
						System.out.println("Accountname:");
						String getaccountname = scan.next();
						
						newAccountdeposit= us.getAccount(user.getId(), getaccountname);
						if(newAccountdeposit == null){
							System.out.println("Attempt failed. Account doesn't exist or name was incorrectly typed. Please try again");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					System.out.println("Enter the amount you with to deposit");
					double deposit = scan.nextDouble();
					double resultd = us.makeADeposit(newAccountdeposit, deposit);
					
					System.out.println("Transaction successful. New balance is " + us.getCurrentAccountBalance(newAccountdeposit));
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					
					
				case 6:
					if(user.getAuthority().equals("superuser")){
						System.out.println("Current users in the application");
						Set<User> users = us.getCurrentUsers();
						for(User u: users){
							System.out.println(u);
						}
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					}else{
						System.out.println("Access denied. Invalid authorization");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					
					
					
				case 7:
					if(user.getAuthority().equals("superuser")){
						User newUser = null;
						while(newUser == null){
							System.out.println("Type in username and password");
							System.out.println("Username:");
							String createuserusername = scan.next();
							System.out.println("Password:");
							String createuserpassword = scan.next();
							newUser = us.createNewUser(0, createuserusername, createuserpassword, "registered");
							System.out.println("New user " + createuserusername + " created");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						break;
						
					}else{
						System.out.println("Access denied. Invalid authorization");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					
					
					
				case 8:
					if(user.getAuthority().equals("superuser")){
						User newUser = null;
						while(newUser == null){
							System.out.println("Type in username and password of user you wish to update");
							System.out.println("Username:");
							String getuserusername = scan.next();
							System.out.println("Password");
							String getuserpassword = scan.next();
							newUser = us.login(getuserusername, getuserpassword);
							if(newUser == null){
								System.out.println("User is not registered or username/password was incorrectly typed. Please tyr again");
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						
						System.out.println("Type in the new username and/or password you want to update");
						System.out.println("Username:");
						String getuserusername = scan.next();
						System.out.println("Password");
						String getuserpassword = scan.next();
						newUser.setUsername(getuserusername);
						newUser.setPassword(getuserpassword);
						us.updateUser(newUser);
						System.out.println("User updated");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					}else{
						System.out.println("Access denied. Invalid authorization");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					
					
					
				case 9:
					if(user.getAuthority().equals("superuser")){
						User newUser = null;
						while(newUser == null){
							System.out.println("Type in username and password of user you wish to delete");
							System.out.println("Username:");
							String getuserusername = scan.next();
							System.out.println("Password");
							String getuserpassword = scan.next();
							newUser = us.login(getuserusername, getuserpassword);
							if(newUser == null){
								System.out.println("User is not registered or username/password was incorrectly typed. Please tyry again");
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						System.out.println("user found");
						Set<Account> accountsdelete = us.getCurrentUserAccount(newUser.getId());
						for(Account a: accountsdelete){
							us.removeSuperAccount(a);
						}
						
						us.removeUser(newUser);
						System.out.println("User has been removed");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					}else{
						System.out.println("Access denied. Invalid authorization");
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					
					
					
				case 10:
					System.out.println("logging out. Thank you for your services");
					break;
			}
		}while(command!=10);
		

	}

}
