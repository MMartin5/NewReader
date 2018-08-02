package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import beans.BeanNews;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class DAONews {
	/**
	 * Insert a news into the database
	 * 
	 * @param title
	 * @param desc
	 * @param url
	 * @param publishedAt
	 * 
	 * @return
	 * 		True if the insertion was successful, false otherwise 
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean addNews(String title, String desc, String url, long publishedAt) 
			throws ClassNotFoundException, SQLException
		{
			DAO dao = DAO.getDAO();
			String query = "INSERT INTO news (title, description, url, publishedAt) VALUES (?, ?, ?, ?);";

			PreparedStatement statement = dao.mysqlConnect.prepareStatement(query);
			statement.setString(1, title);
			statement.setString(2, desc);
			statement.setString(3, url);
			statement.setLong(4, publishedAt);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// Store this news in the Redis DB
				Jedis jedis = dao.jedisConnect;
				Map<String, String> map = new HashMap<>();
				map.put("title", title);
				map.put("description", desc);
				map.put("publishedAt", String.valueOf(publishedAt));
				map.put("url", url);
				jedis.hmset("news:"+url, map);
				// Add this key to the list of news
				jedis.lpush("all:news", url);
				
				return true;
			}
			return false;
		}
	
	/**
	 * Get all news from the DB 
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<BeanNews> getNews() throws ClassNotFoundException, SQLException {
		List<BeanNews> newsList = new LinkedList<>();

		DAO dao = DAO.getDAO();
		Jedis jedis = dao.jedisConnect;
		
		// Get the list of news, sorted by descending publication time 
		List<String> newsKeys = jedis.sort("all:news", new SortingParams().by("news:*->publishedAt").desc());
		if (!newsList.isEmpty()) {
			for (String key : newsKeys) {
				Map<String, String> map = jedis.hgetAll("news:"+key); // get the map values for this news
				BeanNews news = new BeanNews(
						map.get("title"),
						map.get("description"), 
						map.get("url"), 
						Long.parseLong(map.get("publishedAt")));
				newsList.add(news);
			}
		}
		else {		
			String query = "SELECT * FROM news ORDER BY publishedAt DESC;";
			ResultSet res = dao.query(query);
			while(res.next()){
				BeanNews news = new BeanNews(
						res.getString("title"),
						res.getString("description"), 
						res.getString("url"), 
						res.getLong("publishedAt"));
				newsList.add(news);
			}
		}
		return newsList;
	}

}
