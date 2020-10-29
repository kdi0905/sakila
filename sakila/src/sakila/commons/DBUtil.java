package sakila.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection selectDB() throws Exception {
		final String URL="jdbc:mariadb://localhost:3306/sakila";
		final String USER ="root";
		final String PASSWORD="java1004";
		Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
		return conn;
	}
}
