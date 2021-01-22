package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MakeConnection implements ServletContextListener {

	private static Connection con = fetchConnection();
	
	private static Connection fetchConnection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver Found");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null; 
		}
		try {
			String url ="jdbc:mysql://localhost:3306/data";
			String user =""; // Enter user
			String pass =""; // Enter password	
			return DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection getDBConnection() {
		return con;
	}
	
	public void contextDestroyed(ServletContextEvent sce)  { 
		try {
			con.close();
			System.out.println("DB Connection Closed!");
		}catch(Exception e) {
			e.printStackTrace();
		}
    	System.out.println("Project Stopped!");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Project Started!");
    }
	
}
