package beans;

public class BeanNews {
	private final String title;
	private final String description;
	private final String url;
	private final long publishedAt;
	
	public BeanNews(String title, String description, String url, long publishedAt) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
		this.publishedAt = publishedAt;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public long getPublishedAt() {
		return publishedAt;
	}

}
