package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.experimental.theories.Theories;
/**
 * Various helper functions to help manage database related connections.
 * @author Ben Hayward
 *
 */
public class DatabaseHelper {

	private static Connection connection; 
	/**
	 * Creates a connection through the Preposturous database 
	 * in Azure's cloud.
	 * 
	 * Some code taken from:
	 * http://alvinalexander.com/java/edu/pj/pj010024/
	 */
	public final static void connectToDb(){
		    try
		    {
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      String url = "jdbc:sqlserver://preposturous-desktop-server.database.windows.net:1433;database=preposturous-desktop-db;user=p4117178@preposturous-desktop-server;password={B34nsprout};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		      Connection conn = DriverManager.getConnection(url,"p4117178","B34nsprout"); //TODO Copy PW and renew azure sub. 
		      setConnection(conn);
		     //TODO CHANGE PW
		    }
		    catch (Exception e)
		    {
		      System.err.println(e.getMessage()); 
		      e.printStackTrace();
		    } 
	}
	
	/**
	 * Closes a connection.
	 * @param conn the connection to be closed.
	 */
	public final static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Tells if a connection is open, or has closed. True and false representing 
	 * open and closed connections respectively.
	 * @param conn the connection to be tested
	 * @return returns a boolean representing the state of the connection
	 */
	public final static boolean isConnected(Connection conn){
		try {
			return (!conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Gets an appointment object
	 * @param id the ID of the object
	 * @param conn the connection for the request
	 */
	public static void getAppointments(Integer id, Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT Person._id," +
			           " Person.firstName," +
			           " Person.address1," +
			           "" +
			           " Person.personKey," +
			           " Patient.gender, Patient.dob, Patient.personId, Patient._id, " +
			           " Appointment.patientId, Appointment.date, Appointment.time, Appointment._id, Appointment.height, Appointment.status " +
			           "FROM Person INNER JOIN Patient " +
			           "On Person._id = Patient.personId " +
			           "INNER JOIN Appointment " +
			           "On Appointment.patientId = Patient._id " +
			           "WHERE Appointment.patientId = "+id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rs.toString());
	}

	/**
	 * @return the connection
	 */
	public static Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public static void setConnection(Connection connection) {
		DatabaseHelper.connection = connection;
	}
}
