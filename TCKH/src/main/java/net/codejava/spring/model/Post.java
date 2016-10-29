package net.codejava.spring.model;

public class Post {
	private int id;
	private String name;
	private String image;
	private String content;
	private String createTime;
	private int categoryId;
	private String usernameId;

	public Post() {
	}

	public Post(String name, String image, String content, String createTime, int categoryId, String usernameId) {
		this.name = name;
		this.content = content;
		this.image = image;
		this.createTime = createTime;
		this.categoryId = categoryId;
		this.usernameId = usernameId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUsernameId() {
		return usernameId;
	}

	public void setUsernameId(String usernameId) {
		this.usernameId = usernameId;
	}
	public int getCateloryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


}
