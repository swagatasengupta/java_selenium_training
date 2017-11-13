package sqlite;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDemo {

	/**
	 * Connect to a sample database
	 * 
	 * @return
	 */
	public static Connection connect(String dbpath) {

		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:" + dbpath;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;

	}

	public static void createNewDatabase(String dbFileAbsPath) {

		String url = "jdbc:sqlite:" + dbFileAbsPath;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created: " + dbFileAbsPath);
			} else {
				System.out.println("DB connection is not open");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createNewTable(String dbAbsPath, String tableName, String fieldsAndConstraints) {
		// SQLite connection string
		String url = "jdbc:sqlite:" + dbAbsPath;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n " + fieldsAndConstraints + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("executed query successfully: " + sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

    public static ResultSet getResultSet(Connection conn, String sqlQuery){
        ResultSet rs = null;
        try {
             rs  = conn.createStatement().executeQuery(sqlQuery);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static List<Object[]> getResultSetAs2DList(Connection conn, String sqlQuery){
 
    	List<Object[]> records=new ArrayList<Object[]>();
    	
    	ResultSet rs = null;
        try {
             rs  = conn.createStatement().executeQuery(sqlQuery);
     	    int cols = rs.getMetaData().getColumnCount();
         	while(rs.next()){
        	    Object[] arr = new Object[cols];
        	    for(int i=0; i<cols; i++){
        	      arr[i] = rs.getObject(i+1);
        	    }
        	    records.add(arr);
        	}    	

             // print result
             for( Object[] row: records ){
                 for( Object s: row ){
                     System.out.print( " " + s.toString() );
                 }
                 System.out.println();
             }            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return records;
    }
   
    public static Object[][] getResultSetAs2DObjectArray(Connection conn, String sqlQuery){

    	List<Object []> rsList = getResultSetAs2DList(conn, sqlQuery); 
    	return  rsList.toArray(new Object[rsList.size()][]);
    }
    
    
    /**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
/*		String newDBAbsPath = new File(".").getAbsolutePath() + File.separator + "resources" + File.separator
				+ "newSQLiteDB.db";
		createNewDatabase(newDBAbsPath);
		
		 * String dbpath = "test01.db"; File dbfile = new File(dbpath);
		 
		String tableName = "NewTable";
		String tablefieldsAndConstraints = " id integer PRIMARY KEY,\n" + "	name text NOT NULL,\n"
				+ "	capacity real\n";
		createNewTable(newDBAbsPath, tableName, tablefieldsAndConstraints);

		Connection conn = connect(newDBAbsPath);
       // String sql = "SELECT id, name, capacity FROM warehouses";
        String sql = "SELECT * FROM " + tableName;
        ResultSet rs = getResultSet(conn, sql);
        try {
        	ResultSetMetaData rsmd = rs.getMetaData();
        	System.out.println("rsmd.getColumnCount: " + rsmd.getColumnCount());
        	rs.last();
        	System.out.println("after rs.last, rs.getRows: " + rs.getRow());
            rs.setFetchDirection(ResultSet.FETCH_REVERSE);
		    rs.beforeFirst();
          rs.setFetchDirection(ResultSet.FETCH_FORWARD);
            
			while (rs.next()) {
				System.out.println(rs.getInt("id") +  "\t" + 
			                       rs.getString("name") + "\t" +
			                       rs.getDouble("capacity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Object[][] arrRS = getResultSetAs2DObjectArray(conn, sql);
        for (int i= 0; i< arrRS.length; i++) {
        	for (int j = 0; j< arrRS[i].length; j++) {
        		System.out.println("Object " + i + j + " = " + arrRS[i][j] );
        	}
        }
        
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
	}
}