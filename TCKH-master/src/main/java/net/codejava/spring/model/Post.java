package net.codejava.spring.model;

public class Post {
	private int id;
	private String name;
	private String title;
	private String keyword;
	private String lastModified;
	private String usernameId;
	private String nameAuthor;

	public Post() {
	}
	public Post(String name, String title, String keyword, String lastModified, 
			String usernameId, String nameAuthor) {
		this.name = name;
		this.keyword = keyword;
		this.title = title;
		this.lastModified = lastModified;
		this.usernameId = usernameId;
		this.nameAuthor = nameAuthor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getUsernameId() {
		return usernameId;
	}

	public void setUsernameId(String usernameId) {
		this.usernameId = usernameId;
	}
	public String getNameAuthor(){
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

}
