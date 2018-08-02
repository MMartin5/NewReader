package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
