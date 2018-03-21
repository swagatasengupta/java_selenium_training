package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestMySQLDB {

	public static void main(String[] args) {

		String hostName = "localhost"; //change if host is different
		int port = 3306; // change if port is different
		String userName = "root"; //change if DB user name is different
		String password = "password"; // change if DB password for user name is different
		String dbName = "test_schema01"; //change if DB schema is different.
		String query = "select * from creds"; //change the select query if needed. Take care of the table name etc.
		
		
		//this statement will form the connect string. Dont disturb this unless you are really sure of what you are doing.
		String connString = "jdbc:mysql://"
				+ hostName + ":" + port + "/"
				+ dbName + "?"
				+ "user="+userName+"&"
				+ "password="+password;
		//"jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw"
		
		
		
		System.out.println("attempting to connect:: " + connString);
		Connection connection = null;
		ResultSet res = null;
	    try {
	        
	    	Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver is deprecated

	        connection = DriverManager.getConnection(connString);
	        Statement st = connection.createStatement();                                 
	        System.out.println("connection succeeded");
	        

	        res = st.executeQuery(query);
	        while(res.next()) {
	        	int cols = res.getMetaData().getColumnCount();
	        	System.out.println("column count: " + cols);
	        	for (int i=1; i<=cols; i++) {
	        		System.out.print(res.getObject(i) + " ");
	        	}
	        	System.out.println("");
	        }
	        
	        }catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	                System.out.println("Database connection terminated");
	            } catch (Exception e) { /* ignore close errors */ }
	        }
	    }
		
	}

}
