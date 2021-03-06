package JPL.java.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static DBUtils instance;
	private Connection connection;
	
	private DBUtils() {
		Properties properties = new Properties();
		try {
			properties.load(DBUtils.class.getResourceAsStream("/dbCOnfig.properties"));
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=CandidateManagement";
			String userName = "sa";
			String password = "gintaka";

			Class.forName(driver);

			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=CandidateManagement";
			String userName = "sa";
			String password = "gintaka";

			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println(connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static DBUtils getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DBUtils();
		}
		return instance;
	}
}
