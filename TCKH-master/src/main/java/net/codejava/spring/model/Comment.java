package net.codejava.spring.model;

public class Comment {
	private int id;
	private int articleId;
	private int version;
	private String content;
	private String title;
	private String type;
	private String date;
	private String fileName;

	
	public Comment(){
		
	}
	public Comment(int id, int articleId, int version, String content,
			String title, String type, String date, String fileName) {
		this.id = id;
		this.articleId = articleId;
		this.version = version;
		this.content = content;
		this.title = title;
		this.type = type;
		this.date = date;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
