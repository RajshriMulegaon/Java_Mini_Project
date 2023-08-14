package jdbcpoject.dbconfig;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DatabaseConnection 
	{
	    private static Connection connection;

	    public static Connection getConnection() 
	    {
	        if (connection == null) 
	        {
	            try {
	                String dbUrl = "jdbc:mysql://localhost:3306/bloodbank";
	                String dbUsername = "root";
	                String dbPassword = "root";
	                Class.forName("com.mysql.cj.jdbc.Driver");
	  connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	            } catch (ClassNotFoundException | SQLException e)
	            {
	    			System.out.println(e.getMessage());
	            }
	        }
	        return connection;
	    }
	}
