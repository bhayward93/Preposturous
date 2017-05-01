package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.experimental.theories.Theories;

import dataStructures.PointAnnotation;
import dataStructures.PointUI;
import dataStructures.Appointment;
import dataStructures.LesserPhotoView;
import dataStructures.Patient;
import dataStructures.Point;
/**
 * Various helper functions to help manage database related connections.
 * @author Ben Hayward
 *
 */
public class DatabaseHelper {
	private static Statement stmt;

	private static Connection conn; 
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
		      String url = "jdbc:sqlserver://preposturous-desktop-server.database.windows.net:1433;database=preposturous-desktop-db;user=p4117178@preposturous-desktop-server;password=B34nsprout;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
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
		return conn;
	}

	/**
	 * @param connection the connection to set
	 */
	public static void setConnection(Connection connection) {
		DatabaseHelper.conn = connection;
	}


public ResultSet findPatient(String patientsName)
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
    rs = stmt.executeQuery("Person WHERE Name = '" + patientsName + "';");
    return rs;
}

public ResultSet findPatientByKey(String key)
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
	rs = stmt.executeQuery("Person WHERE PersonKey = '" + key + "';");
    return rs;
}

public ResultSet filterPatient(String patientsName)
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
	rs = stmt.executeQuery("Person WHERE Name LIKE '" + patientsName + "%';");
    return rs;
}

public ResultSet fecthAll()
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
	rs = stmt.executeQuery("Person");
    return rs;
}


public void addAppointment(int id, String date, String time)
{
	try{
	     stmt = conn.createStatement();
		 String sql = "INSERT INTO APPOINTMENT " +
				 			"VALUES ("+id+", '"+date+"','"+ time+"', "+Byte.parseByte("0")+")";
		 stmt.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	}
}


public void addAnnotation(PointAnnotation a, int id)
{
//        values.put("pointId", id);
//        values.put("text", a.getText());
//        values.put("visualAnalogScale", a.getVisualAnalogueScale());
   	try{
   	     stmt = conn.createStatement();
   		 String sql = "INSERT INTO ANNOTATION " +
   				 			"VALUES ("+id+", '"+a.getText()+"', "+a.getVisualAnalogueScale()+")";
   		 stmt.executeUpdate(sql);
   	}catch(Exception e){
   		e.printStackTrace();
   	}
}

public synchronized void addPoints(LesserPhotoView lpw, ArrayList<PointUI> points) //TODO Is this sync effective?
{
    for(PointUI p: points)
    {
	    try{
		     stmt = conn.createStatement();
			 String sql = "INSERT INTO POINT " +
					 			"VALUES ("+lpw.getViewId()+", '"+p.getName()+"','"+ p.getX()+"', "+p.getY()+", 1)";
			 stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
    }    
}

public synchronized void addBarPoints(LesserPhotoView lpw,  ArrayList<Point> points)
{
    stmt = conn.createStatement();
    for(Point p: points){
    	  try{
 		     stmt = conn.createStatement();
 			 String sql = "INSERT INTO POINT " +
 					 			"VALUES ("+lpw.getViewId()+", '"+p.getName()+"','"+ p.getX()+"', "+p.getY()+", 1)";
 			 stmt.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
    }
 }

//Not sure this is needed?
//public void addPoint(int viewID, String name, int x, int y)
//{
//    ContentValues values = new ContentValues();
//
//    values.put("viewId", viewID);
//    values.put("name", name);
//    values.put("x", x);
//    values.put("y", y);
//    values.put("status", 1);
//
//    database.insert("Point", null, values);
//}

public void addView(Appointment apnt, LesserPhotoView pView)
{
	stmt = conn.createStatement();
    	  try{
 		     stmt = conn.createStatement();
 			 String sql = "INSERT INTO POINT " +
 					 			"VALUES ("+apnt.getAppointmentId()+", '"+pView.getViewAngleValue()+"','"+ pView.getViewTypeValue()+"', "+pView.getFilePath()+", true)";
 			 stmt.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
}


//need to see about database fields, and amend.
public void addPatient(Patient ptnt)
{
	stmt = conn.createStatement();
	  try{
	     stmt = conn.createStatement();
		 String sql = "INSERT INTO POINT " +
				 			"VALUES (NULL, '"
				 						   +ptnt.getFirstName()+"', '"
				 						   +ptnt.getMiddleNames() + "', '"
				 						   +ptnt.getLastName() + "', '"
				 						   +ptnt.getAddress1() + "', '"
				 						   +ptnt.getAddress2() + "', '"
				 						   +ptnt.getAddress3() + "', '"
				 						   +ptnt.getTown() + "', '"
				 						   +ptnt.getCounty() + "', '"
				 						   +ptnt.getPostCode() + "', '"
				 					       +ptnt.getPhone() + "', '"
				 						   +ptnt.getEmail() + "', "
				 						   +"True , '"
				 						   +ptnt.getPersonKey()
				 						   +"')";
		 stmt.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	}   
	linkPatient(1, "11/11/2001", ptnt.getPersonKey());

}
    //values.put("gender", patient.getGenderValue());
    //values.put("dob", patient.getDob());
    //pass objects gndr a dob into param



public void linkPatient(int gender, String dob, String key)
{
	stmt = conn.createStatement();
    	  try{
 		     stmt = conn.createStatement();
 			  String res = "Person WHERE personKey = '" + key + "';";
 			 stmt.executeUpdate(res);
			  if (res != null) // && res.moveToFirst()) - Android code; TODO look up at a later date
		      {
		      String autoIncId = "";
		      
	          //values must contain all db fields that are not autofill...
				  String sql = "INSERT INTO PATIENT " +
				 			"VALUES ("+autoIncId+", "   //Needs auto-incrementing, the DB should hopefully already be set up to do this.
				 						   +gender+", "
				 						   +", '"
				 						   +dob+"')";
				  stmt.executeUpdate(sql);			
			        linkClinician(autoIncId);
			    }
    	  }catch(Exception e){
   			e.printStackTrace();
   		}
}


public void finishAppointment(int id)
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
	rs = stmt.executeQuery("Appointment WHERE _id = '" + id + "';");
    if (rs != null) //&& res.moveToFirst())
    {
        //put appointment status to 1 = complete
    	stmt.executeQuery("INSERT INTO APPOINTMENT VALUES ("+1+")"); //TODO This should be setting the status to complete but may update another row...
    }

}

public void linkClinician(String id)
{
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ResultSet rs = null;
	rs = stmt.executeQuery("Patient WHERE personId = '" + id + "';");
    if (rs != null)
    {
        //clinician id needs address so not hard coded
    	
     rs=stmt.executeQuery(	"INSERT INTO ASSIGNMENT "
     + "VALUES (1, NULL, TRUE)");
    }
}

public ArrayList patientList(ResultSet resultSet){
	 ArrayList<Patient> patients = new ArrayList<Patient>();
	 if (resultSet != null)    {
		 while (resultSet.next()) {
			 Patient patient = new Patient();
			 patient.setPatientId(resultSet.findColumn("_id")); //c.getInt(c.getColumnIndex("_id"))
			 patient.setFirstName(resultSet.getString("firstName"));
			 patient.setMiddleNames(resultSet.getString("mName"));
			 patient.setLastName(resultSet.getString("lastName"));
			 patient.setAddress1(resultSet.getString("address1"));
			 patient.setAddress2(resultSet.getString("address2"));
			 patient.setAddress3(resultSet.getString("address3"));
			 patient.setTown(resultSet.getString("town")); //TODO some of these labels may not be correct
			 patient.setCounty(resultSet.getString("county"));
			 patient.setPostCode(resultSet.getString("postcode"));
			 patient.setPhone(resultSet.getString("phone"));
			 patient.setEmail(resultSet.getString("email"));
			 patient.setPersonKey(resultSet.getString("personKey"));
			 patient.setPatientId(resultSet.getInt("_id"));
			 patient.setGender(resultSet.getByte("gender"));//Byte.parseByte("1"), ?? why was a default value set.
			 patient.setNote(resultSet.getString("noteText"));
			 //may need an arraylist off appointments adding; see android code here  //NOTE TEXT",new ArrayList<Appointment>()));
			 patients.add(patient);
		 }
     }
    return patients;
}

public String getPatientsOfClinician()
{
    String res = database.rawQuery("SELECT Person._id," +
                    " Person.firstName," +
                    " Person.lastName," +
                    " Person.address1," +
                    " Person.address2," +
                    " Person.address3," +
                    "" +
                    " Person.personKey," +
                    " Patient.gender, Patient.dob, Patient.personId, Patient._id, " +
                    " Assignment.clinicianId, Assignment.patientId " +
                    "FROM Person INNER JOIN Patient " +
                    "On Person._id = Patient.personId " +
                    "INNER JOIN Assignment " +
                    "On Assignment.patientId = Patient._id " +
                    "WHERE Assignment.clinicianId = 1",
            null);

    return res;
}

public ArrayList appointmentList(String c)
{
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    if (c != null && c.moveToFirst())
    {
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            try
            {
                appointments.add(new Appointment(c.getInt(c.getColumnIndex("_id")),
                        new SimpleDateFormat("dd/MM/yyyy").parse(c.getString(c.getColumnIndex("date"))),
                        new SimpleDateFormat("HH:mm").parse(c.getString(c.getColumnIndex("time"))),
                        AppointmentStatus.valueOf((byte) c.getInt(c.getColumnIndex("status"))), new LesserPhotoView[0]));
            } catch (ParseException e)
            {
                e.printStackTrace();
            }

        }
    }
    c.close();

    return appointments;
}


public String getAppointments(int id)
{

    String res = database.rawQuery("SELECT Person._id," +
                    " Person.firstName," +
                    " Person.address1," +
                    "" +
                    " Person.personKey," +
                    " Patient.gender, Patient.dob, Patient.personId, Patient._id, " +
                    " Appointment.patientId, Appointment.date, Appointment.time, Appointment._id, Appointment.status " +
                    "FROM Person INNER JOIN Patient " +
                    "On Person._id = Patient.personId " +
                    "INNER JOIN Appointment " +
                    "On Appointment.patientId = Patient._id " +
                    "WHERE Appointment.patientId = "+id,
            null);

    return res;
}



public PhotoView completeAppointment(String c)
{
    //ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    PhotoView pView = new PhotoView();
    if (c != null && c.moveToFirst())
    {
//        PhotoView pView = new PhotoView(c.getInt(c.getColumnIndex("_id")),
//                viewAnglew, viewtype, strinpath, imgphoto,
//                arraylistpoint, arraylistlines)
        pView.setViewId(c.getInt(c.getColumnIndex("_id")));
        pView.setFilePath(c.getString(c.getColumnIndex("filePath")));

//        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
//        {
//            try
//            {
//                appointments.add(new Appointment(c.getInt(c.getColumnIndex("_id")),
//                        new SimpleDateFormat("dd/MM/yyyy").parse(c.getString(c.getColumnIndex("date"))),
//                        new SimpleDateFormat("HH:mm").parse(c.getString(c.getColumnIndex("time"))),
//                        new Byte(Byte.parseByte("1")), new LesserPhotoView[0]));
//            } catch (ParseException e)
//            {
//                e.printStackTrace();
//            }
//
//        }

    }
    c.close();

    return pView;
}

public String getCompleteAppointment(int id)
{
    Log.d("id is=",""+id);
    String res = database.rawQuery("SELECT View._id," +
                    " View.viewAngle," +
                    " View.filePath," +
                    "" +
                    " View.active," +
                    " Appointment._id, Appointment.status " +
                    "FROM Appointment INNER JOIN View " +
                    "On Appointment._id = View.appointmentId " +
                    "WHERE Appointment._Id = "+id,
            null);

    return res;
}


public ArrayList viewsList(String c)
{
    ArrayList<PhotoView> views = new ArrayList<PhotoView>();

    if (c != null && c.moveToFirst())
    {
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            //TRY/CATCH remove by AS why? Also, issues with ViewAngle/Type as
            //DB BLOB needs int??
            views.add(new PhotoView(c.getInt(c.getColumnIndex("_id")),
                    ViewAngle.valueOf((byte) c.getInt(c.getColumnIndex("viewAngle"))),
                    ViewType.valueOf((byte) c.getInt(c.getColumnIndex(("viewType")))),
                    c.getString(c.getColumnIndex("filePath")), null,null,null));
//AppointmentStatus.valueOf((byte) c.getInt(c.getColumnIndex("status")))
        }
    }
    c.close();

    return views;
}

public String getViews(int id)
{
    Log.d("id is=",""+id);
    String res = database.rawQuery("SELECT View._id," +
                    " View.appointmentId," +
                    " View.viewAngle," +
                    "" +
                    " View.viewType," +
                    " View.filePath, View.active " +
                    "FROM View " +
                    "WHERE View.appointmentId = "+id,
            null);

    return res;
}

public ArrayList pointsList(String c)
{
    ArrayList<Point> points = new ArrayList<Point>();

    if (c != null && c.moveToFirst())
    {
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            points.add(new Point(c.getInt(c.getColumnIndex("_id")),c.getString(c.getColumnIndex("name")),
                    c.getInt(c.getColumnIndex("x")), c.getInt(c.getColumnIndex("y")),null));
        }
    }
    c.close();

    return points;
}

public String getPoints(int id)
{
    Log.d("id is=",""+id);
    String res = database.rawQuery("SELECT Point._id," +
                    " Point.name," +
                    " Point.viewId," +
                    "" +
                    " Point.x," +
                    " Point.y " +
                    "FROM Point " +
                    "WHERE Point.viewId = "+id,
            null);

    return res;
}

public String getAnnotation(int id)
{
    Log.d("id is=",""+id);
    String res = database.rawQuery("SELECT Annotation._id," +
                    " Annotation.text," +
                    " Annotation.visualAnalogScale " +
                    "FROM Annotation " +
                    "WHERE Annotation.pointId = "+id,
            null);

    return res;
}

public PointAnnotation annotationList(String c)
{
    PointAnnotation anno = new PointAnnotation();

    if (c != null && c.moveToFirst())
    {
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            anno.setVisualAnalogueScale(c.getInt(c.getColumnIndex("visualAnalogScale")));
            anno.setText(c.getString(c.getColumnIndex("text")));
        }
    }
    c.close();

    return anno;
}

public PointAnnotation getAnnotationObject(String c)
{

    PointAnnotation anno = new PointAnnotation();
    if (c != null && c.moveToFirst())
    {
        anno.setVisualAnalogueScale(c.getInt(c.getColumnIndex("visualAnalogScale")));
        anno.setText(c.getString(c.getColumnIndex("text")));
    }
    c.close();

    return anno;
}


public Appointment prevAppointment(String c)
{
    ArrayList<Appointment> list = new ArrayList<Appointment>();
    Appointment apnt = new Appointment();

    if (c != null && c.moveToFirst())
    {
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            list.add(new Appointment(c.getInt(c.getColumnIndex("_id")), null, null, null, new LesserPhotoView[0]));
        }

        if(list.size() >= 2) {
            apnt = list.get(list.size() - 2);
        }
    }
    c.close();

    return apnt;
}

public String getLastAppointment(int id)
{
    String res = database.rawQuery("SELECT Person._id," +
                    " Person.firstName," +
                    " Person.address1," +
                    "" +
                    " Person.personKey," +
                    " Patient.gender, Patient.dob, Patient.personId, Patient._id, " +
                    " Appointment.patientId, Appointment.date, Appointment.time, Appointment._id, Appointment.status " +
                    "FROM Person INNER JOIN Patient " +
                    "On Person._id = Patient.personId " +
                    "INNER JOIN Appointment " +
                    "On Appointment.patientId = Patient._id " +
                    "WHERE Appointment.patientId = "+id,
            null);

    return res;
}


public boolean Login(String username, String password) throws SQLException
{
    String mString = database.rawQuery("SELECT * FROM Clinician WHERE username=? AND passHash=?", new String[]{username,password});
    if (mString != null) {
        if(mString.getCount() > 0)
        {
            return true;
        }
    }
    return false;
}
