package dev.jason.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

public static Connection createConnection(){
		
		
		try {
			
			Properties props = new Properties();
			
			FileInputStream in = new FileInputStream("src/main/resources/connection.properties");
			props.load(in);
			
			String conInfo = props.getProperty("conn");
			
			
			Connection conn = DriverManager.getConnection(conInfo);
			//System.out.println(conn);
			
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
