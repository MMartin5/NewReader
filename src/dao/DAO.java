package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

import java.sql.ResultSet;

public class DAO {
	private static DAO singleton = null;
	Connection mysqlConnect;
	Jedis jedisConnect;
	
	public static DAO getDAO() 
		throws ClassNotFoundException, SQLException 
	{
		if(singleton == null) {
			// Get user password
			System.out.println("Enter DB password: ");
			Scanner scan = new Scanner(System.in);
			String pwd = scan.nextLine();
			scan.close();
			// Get unique MySQL connection
			DAOMysqlConnection daoConnect = new DAOMysqlConnection(pwd);
			daoConnect.connect();
			// Get unique Redis connection
			DAORedisConnection redisConnect = new DAORedisConnection();
			redisConnect.connect();
			// Init singleton
			singleton = new DAO();
			singleton.mysqlConnect = daoConnect.getConnection();
			singleton.jedisConnect = redisConnect.getConnection();
		}
		return singleton;
	}
	
	public ResultSet query(String query) 
			throws SQLException, ClassNotFoundException
	{
		Statement st = mysqlConnect.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	private DAO() {
		// void
	}
}
