package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Nagender
 */
public final class ConnectionManager {
	private static Connection connection;

	private ConnectionManager() {

	}

	/**
	 * This method will be used to establish connection with database
	 * 
	 * @return connection
	 */
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
		String userName = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * This method is used to close the connection variable
	 */
	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
		}
	}

}
