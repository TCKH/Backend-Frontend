package net.codejava.spring.model;

public class Post {
	private int id;
	private String title;
	private String content;
	private String comment;
	private String abstracts;
	private String highlights;

	public Post() {
	}

	public Post(String title, String content, String comment, String abstracts, String highlights) {
		this.title = title;
		this.content = content;
		this.comment = comment;
		this.abstracts = abstracts;
		this.highlights = highlights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}


}
