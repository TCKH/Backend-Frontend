package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Post;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface PostDAO {
	public void saveOrUpdate(Post post);
	public List<Post> list();
	public Post get(int contactId);
	public void delete(int id);
}
