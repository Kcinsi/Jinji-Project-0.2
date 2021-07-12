package dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JinjiDBManager {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://	localhost:3306/wakaba";
	private static final String DB_NAME = "root";
	private static final String DB_PASS = "182461b17174";

	public static Connection getConnection() throws ClassNotFoundException, SQLException{			
		Class.forName(DRIVER_NAME);
		Connection connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASS);
		return connection;
	}

	public static void close(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement statement) {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}