package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

	/**
	 * creates a connection through the databasehttp://alvinalexander.com/java/edu/pj/pj010024/
     *
	 */
	public static void connectToDb(){
		    try
		    {
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      String url = "jdbc:sqlserver://preposturous-desktop-server.database.windows.net:1433;database=preposturous-desktop-db;user=p4117178@preposturous-desktop-server;password={B34nsprout};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"; 
		      Connection conn = DriverManager.getConnection(url,"p4117178","8gfwfWaHcpGX3e69"); //TODO Copy PW and renew azure sub. 
		     //TODO CHANGE PW
		    }
		    catch (Exception e)
		    {
		      System.err.println(e.getMessage()); 
		      e.printStackTrace();
		    } 
	}
}
