package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Post;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface PostDAO {
	public List<Post> list();
}
