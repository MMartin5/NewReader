package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import beans.BeanNews;

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

			PreparedStatement statement = dao.connect.prepareStatement(query);
			statement.setString(1, title);
			statement.setString(2, desc);
			statement.setString(3, url);
			statement.setLong(4, publishedAt);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}
			return false;
		}
	
	public List<BeanNews> getNews() throws ClassNotFoundException, SQLException {
		DAO dao = DAO.getDAO();
		String query = "SELECT * FROM news ORDER BY publishedAt DESC;";
		ResultSet res = dao.query(query);
		List<BeanNews> newsList = new LinkedList<>();
		while(res.next()){
			BeanNews news = new BeanNews(
					res.getString("title"),
					res.getString("description"), 
					res.getString("url"), 
					res.getLong("publishedAt"));
			newsList.add(news);
		}
		return newsList;
	}

}
