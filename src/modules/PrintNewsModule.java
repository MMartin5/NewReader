package modules;

import java.sql.SQLException;

import controller.NewsReader;
import dao.DAO;

public class PrintNewsModule {

	public static void main(String[] args) {
		try {
			DAO.getDAO();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewsReader reader = new NewsReader();
		reader.printNews();
	}

}
