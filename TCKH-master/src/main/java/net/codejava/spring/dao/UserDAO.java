package net.codejava.spring.dao;


import java.util.List;

import net.codejava.spring.model.User;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface UserDAO {
	
	public void insert(User user);
	public void update(User user);
	public User get(String username);
	public List<User> list();
	public void delete(String username);
}
