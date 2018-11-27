package com.brd.fileoperation;
import com.brd.fileoperation.*;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class javaconn {
	static Connection connection = null;
	static {
		try

		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);

		}

	}

	public void connmethod(String customerId, String CustomerCode, String CustomerName, String CustomerAddress1,
			String CustomerAddress2, String CustomerPinCode, String Emailaddress, String ContactNumber,
			String PrimaryContactPerson, String RecordStatus, String ActiveInactiveFlag, String CreateDate,
			String CreatedBy, String ModifiedDate, String ModifiedBy, String AuthorizedDate, String AuthorizedBy)throws SQLException,IOException {
		try {
//			if(AuthorizedDate.equals("~")) {
//				AuthorizedDate = "";
//			}
			String teString = "insert into costumermaster6 values('"+customerId+"','" + CustomerCode + "','" + CustomerName +"','"+CustomerAddress1+ "','" +CustomerAddress2+"','" +CustomerPinCode +"','"+Emailaddress +"','"+ContactNumber+ "','" +PrimaryContactPerson+ "','" +RecordStatus+ "','" +ActiveInactiveFlag+ "','" +CreateDate+ "','" +CreatedBy+ "','" +ModifiedDate+ "','" +ModifiedBy+ "','"+AuthorizedDate+ "','"+AuthorizedBy+ "')";


//			PreparedStatement stmt = connection
//					.prepareStatement("insert into jaga1_costumermaster values('1',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");			stmt.setString(1, CustomerCode);
//			stmt.setString(2, CustomerName);
//			stmt.setString(3, CustomerAddress1);
//			stmt.setString(4, CustomerAddress2);
//			stmt.setString(5, CustomerPinCode);
//		stmt.setString(6, Emailaddress);
//		stmt.setString(7, ContactNumber);
//		stmt.setString(8, PrimaryContactPerson);
//			stmt.setString(9, RecordStatus);
//			stmt.setString(10, ActiveInactiveFlag); N
//		stmt.setString(11, CreateDate);			stmt.setString(12, CreatedBy);
//			stmt.setString(13, ModifiedDate);
//		stmt.setString(14, ModifiedBy);
//		stmt.setString(15, AuthorizedDate);
//			stmt.setString(16, AuthorizedBy);
			
			Statement stmt = connection.createStatement();
			System.out.println(teString);
			int i = stmt.executeUpdate(teString);
			System.out.println("datainserted successfully");
			System.out.println(i);
			connection.commit();
			//System.err.println(stmt.toString());
			//stmt.executeUpdate(teString);

		} catch (Exception e) {
			System.out.println("connmethod : " + e);
		}
	}

}
