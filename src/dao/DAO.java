package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class DAO {
	private static DAO singleton = null;
	Connection connect;
	
	public static DAO getDAO() 
		throws ClassNotFoundException, SQLException 
	{
		if(singleton == null) {
			// Get user password
			System.out.println("Enter DB password: ");
			Scanner scan = new Scanner(System.in);
			String pwd = scan.nextLine();
			scan.close();
			// Get unique connection
			DAOConnection daoConnect = new DAOConnection(pwd);
			daoConnect.connect();
			singleton = new DAO();
			singleton.connect = daoConnect.getConnection();
		}
		return singleton;
	}
	
	public ResultSet query(String query) 
			throws SQLException, ClassNotFoundException
	{
		Statement st = connect.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	private DAO() {
		// void
	}
}
