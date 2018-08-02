package dao;

import java.sql.SQLException;

import redis.clients.jedis.Jedis;

public class DAORedisConnection {
	private Jedis connect;
	
	public void connect() {
		Jedis jedis = new Jedis("localhost");
		connect = jedis;
	}
	
	public Jedis getConnection() {
		return connect;
	}
	
	public void disconnect() throws SQLException {
		connect.close();
	}
}
