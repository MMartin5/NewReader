package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOMysqlConnection {
	private final String url;
	private final String user;
	private final String pwd;
	private Connection connect;
	
	public DAOMysqlConnection(String password) {
		url = Config1.url;
		user = Config1.user;
		pwd = password;
	}

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		connect = DriverManager.getConnection(url, user, pwd);
	}
	
	public Connection getConnection() {
		return connect;
	}
	
	public void disconnect() throws SQLException {
		connect.close();
	}
}
