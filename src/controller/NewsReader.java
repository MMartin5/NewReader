package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import beans.BeanNews;
import dao.DAONews;

public class NewsReader {
	
	public void printNews() {
		try {
			DAONews daoNews = new DAONews();
			List<BeanNews> newsList;
			newsList = daoNews.getNews();
			System.out.println("### NEWS ###");
			for (BeanNews news : newsList) {
				Date date = new Date(news.getPublishedAt()*1000); // convert to milliseconds
				System.out.println(String.format("\n| %s | %s | %s", date.toString(), news.getTitle(), news.getUrl()));
				System.out.println(news.getDescription());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
