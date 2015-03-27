package network;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseCommunicator {
	private Connection aConnection;
	
	public DatabaseCommunicator() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to find postgres driver.");
		}
		
		aConnection = null;
		try {
			aConnection = DriverManager.getConnection(
					"jdbc:postgresql://db2.cs.mcgill.ca:50000/CS421", //host
					"username", //username
					"password" //password
			);
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database server.");
		}
	}
	
	public String doSomething(){
		return null;
	}
	
	public static void main(String[] args) {
		new DatabaseCommunicator();
	}
}
