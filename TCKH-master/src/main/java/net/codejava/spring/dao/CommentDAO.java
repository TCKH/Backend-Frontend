package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Comment;

public interface CommentDAO {
	public void saveOrUpdate(Comment comment);
	public List<Comment> list();
	public Comment get(int id);
	public void delete(int id);
}
