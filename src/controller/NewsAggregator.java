package controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import beans.BeanNews;


public class NewsAggregator {
	
	private static final String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=57f4696d8c28484f849bc09108670849";
	private static final String arrayName = "articles";
	private static final String datePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	/**
	 * Convert a date represented as a string to a unix timestamp
	 * 
	 * @param dateStr
	 * 			The string representing the date
	 * 
	 * @return
	 * 			An integer representing the unix timestamp
	 */
	private long convertDateToTimestamp(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		try {
			Date date = format.parse(dateStr);
			return (date.getTime() / 1000l); // convert from milliseconds to seconds
		} catch (ParseException e) {
			System.out.println("Incorrect date format.");
		}		
		return 0;
	}
	
	/**
	 * Read one object from a JSON parser and build the news object
	 * from the extracted information
	 * 
	 * @param parser
	 * 			The JSON parser
	 * 
	 * @return
	 * 			A BeanNews representing the news object
	 * 
	 * @throws IOException
	 */
	private BeanNews readNews(JsonParser parser) throws IOException {
		String title = "";
		String description = "";
		String url = "";
		long publishedAt = 0;
		// Parse JSON object fields
		while (parser.nextToken() != JsonToken.END_OBJECT || parser.nextFieldName() != null) {
			String field = parser.getCurrentName();
			parser.nextToken();
			if (field.equals("title")) {
				title = parser.getText();
			}
			else if (field.equals("description")) {
				description = parser.getText();
			}
			else if (field.equals("url")) {
				url = parser.getText();
			}
			else if (field.equals("publishedAt")) {
				publishedAt = convertDateToTimestamp(parser.getValueAsString());
			}
		}
		return new BeanNews(title, description, url, publishedAt);
	}
	
	public void connectToAPI() {
		// Connect to API
		try {
			URL api = new URL(url);
			InputStream content = api.openStream();
			// Parse data
			JsonFactory factory = new JsonFactory();
			JsonParser parser = factory.createParser(content);
			while (!parser.isClosed()) {	// read until eof
				JsonToken token = parser.nextToken();
				if (token == null) {
					break;
				}
				// Find the "articles" token (array)
				if (token.equals(JsonToken.FIELD_NAME) && 
						parser.getCurrentName().equals(arrayName)) {
					token = parser.nextToken(); // get the start of the array
					if (!token.equals(JsonToken.START_ARRAY)) {
						break;
					}
					// Iterate over the array of news
					while (!parser.getCurrentToken().equals(JsonToken.END_ARRAY)) {
						if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
							// Get the news object from the current JSON object
							BeanNews news = readNews(parser);
							System.out.println(String.format("%s %s %s", news.getTitle(), news.getUrl(), news.getDescription()));
						}
						else {
							parser.nextToken();
						}
					}
				}
			}
			parser.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
