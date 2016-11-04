package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import net.codejava.spring.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users (username, password, lastname, firstname, email, usertype)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
			user.getLastname(), user.getFirstname(), user.getEmail(), user.getUserType());
		/*if (user.getUsername().length() > 0) {
			// update
			String sql = "UPDATE users SET username=?, password=?, lastname=?, "
						+ "firstname=?, email=? WHERE username=?";
			jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
					user.getLastname(), user.getFirstname(), user.getEmail(), user.getUsername());
		} else {
			// insert
			String sql = "INSERT INTO users (username, password, lastname, firstname, email)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
					user.getLastname(), user.getFirstname(), user.getEmail());
		}
	*/
	}
	@Override
	public User get(String userName) {
		String sql = "SELECT * FROM users as u WHERE u.username = '" + userName +"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setLastname(rs.getString("lastname"));
					user.setFirstname(rs.getString("firstname"));
					return user;
				}
				
				return null;
			}
			
		});
	}

}
