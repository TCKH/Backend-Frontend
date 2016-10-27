package net.codejava.spring.dao;


import net.codejava.spring.model.User;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface UserDAO {
	
	public void insert(User user);
	public User get(String username);

}
