package LoginPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.CommonDialogs.Type;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("UserName");
		String password = request.getParameter("password");
		String type = request.getParameter("list");

		if (validateLogin(username, password, type)) {
			if (type == "m") {
				response.sendRedirect("maker.html");

			} else {
				response.sendRedirect("checker.html");
			}
		} else {
			System.out.println("invalid login");
		}
	}

	private boolean validateLogin(String username, String password, String type) {
		try {
			// Load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// Create a statement
			Statement statement = connection.createStatement();
			// Execute a Query
			// String query = "select count(*) from TEMP_MAKERST where username ='" +
			// username + "' and password ='"
			// + password + "'and type='" + type + "'";

			// ResultSet loginResult = statement.executeQuery(query);
			// Iterate through the result set and display the records.
			// loginResult.next();

			// Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection
					.prepareStatement("select from TEMP_MAKERST where username=? and password=? and type=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, type);
			ResultSet rs=stmt.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getString("username"));
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password) && rs.getString("list").equals(type))
				{
					return true;
				}
		//rs.getString("username");
			}
			
			boolean value = stmt.execute();
			System.out.println(value);

//			String a =result.getString(1);
//			System.out.println(result.getString(1));
//			System.out.println(query);
//			int result = statement.executeUpdate(query);
//			System.out.println(a);
//			System.out.println(result);
			// result.next();
			// System.out.println(result.getInt(2));

			// connection.commit();
//			if (value == true) {
//				return true;
//			} else {
//				return false;
//			}

		} catch (ClassNotFoundException exception) {
			System.out.println("validateLogin:" + exception);
		} catch (SQLException exception) {
			System.out.println("sqlexceptionvalidateLogin:" + exception);
		}
		return false;
	}
}
