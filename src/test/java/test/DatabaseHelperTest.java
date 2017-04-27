package test;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import utils.DatabaseHelper;

public class DatabaseHelperTest {

	private static Connection thisConn = null;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DatabaseHelper.closeConnection(thisConn); //Ensures the connection object is not left open.
	}

	@Before
	public void setUp() throws Exception {
		DatabaseHelper.connectToDb();
		thisConn = DatabaseHelper.getConnection(); //store the current connection object for use in tearDownAfterClass()
	}

	@Test
	public final void testConnectToDb() {
		assert(DatabaseHelper.isConnected(thisConn));
	}

	@Test
	public final void testCloseConnection() {
		assert(DatabaseHelper.isConnected(thisConn));
	}

	@Test
	public final void testIsConnected() {
		assert(DatabaseHelper.isConnected(thisConn));
	}

	@Test
	public final void testGetAppointments() {
		assert(DatabaseHelper.isConnected(thisConn));
	}

	/**
	 * @return the thisConn
	 */
	public Connection getThisConn() {
		return thisConn;
	}

}


