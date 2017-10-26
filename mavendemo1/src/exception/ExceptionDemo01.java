package exception;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionDemo01 {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con  = null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
		return con;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Connection con1 = getConnection();
		}
		// note - catch block is not mandatory. Finally can also suppress the errors (if any)
		catch (SQLException e) {
			System.out.println("Error occured: " + e.getMessage() + "\nPlease check driver connection");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured: " + e.getMessage() + "\nPlease check if class com.mysql.jdbc.Driver exists");
			e.printStackTrace();
		}
		finally {
			System.out.println("This will always execute - regardless of whether exception comes or not");
		}

	}

}
