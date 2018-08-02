package modules;
import java.sql.SQLException;

import controller.NewsAggregator;
import dao.DAO;

public class AggregateNewsModule {

	public static void main(String[] args) {
		try {
			DAO.getDAO(); // make sure we connect to the DB
			NewsAggregator aggreg = new NewsAggregator();
			aggreg.connectToAPI();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
