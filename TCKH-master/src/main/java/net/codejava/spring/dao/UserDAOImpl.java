package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


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
		// insert
		String sql = "INSERT INTO users (username, password, lastname, firstname, email, usertype, token, money)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
			user.getLastname(), user.getFirstname(), user.getEmail(), user.getUserType(), user.getToken(), user.getMoney());
	}
	@Override
	public void update(User user) {
		// update
		String sql = "UPDATE users SET username=?, password=?, lastname=?, "
					+ "firstname=?, email=?, usertype=?, token=?, money=? WHERE username=?";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
				user.getLastname(), user.getFirstname(), user.getEmail(),
				user.getUserType() ,user.getToken(), user.getMoney(), user.getUsername());
	}
	@Override
	public List<User> list() {
		String sql = "SELECT * FROM users";
		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User aUser = new User();
				aUser.setUsername(rs.getString("username"));
				aUser.setPassword(rs.getString("password"));
				aUser.setEmail(rs.getString("email"));
				aUser.setLastname(rs.getString("lastname"));
				aUser.setFirstname(rs.getString("firstname"));
				aUser.setUserType(rs.getString("usertype"));
				aUser.setToken(rs.getString("token"));
				aUser.setMoney(rs.getString("money"));
				return aUser;
			}
			
		});
		
		return listUser;
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
					user.setUserType(rs.getString("usertype"));
					user.setToken(rs.getString("token"));
					user.setMoney(rs.getString("money"));
					return user;
				}
				
				return null;
			}
			
		});
	}
	@Override
	public void delete(String username) {
		String sql = "DELETE FROM users WHERE username=?";
		jdbcTemplate.update(sql, username);
	}

}
