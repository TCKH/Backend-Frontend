package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import net.codejava.spring.model.Post;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the PostDAO interface.
 * @author www.codejava.net
 *
 */
public class PostDAOImpl implements PostDAO {

	private JdbcTemplate jdbcTemplate;
	
	public PostDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(Post post) {
		if (post.getId() > 0) {
			// update
			String sql = "UPDATE articles SET name=?, image=?, content=?, "
						+ "createTime=?, categoryId=?, usernameId=? WHERE id=?";
			jdbcTemplate.update(sql, post.getName(), post.getImage(),
					post.getContent(), post.getCreateTime(),
					post.getCateloryId(), post.getUsernameId(), post.getId());
		} else {
			// insert
			String sql = "INSERT INTO articles (name, image, content, createTime,categoryId,usernameId)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, post.getName(), post.getImage(),
					post.getContent(), post.getCreateTime(), post.getCateloryId(), post.getUsernameId());
		}
		
	}

	@Override
	public List<Post> list() {
		String sql = "SELECT * FROM articles";
		List<Post> listPost = jdbcTemplate.query(sql, new RowMapper<Post>() {

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post aPost = new Post();
	
				aPost.setId(rs.getInt("id"));
				aPost.setName(rs.getString("name"));
				aPost.setContent(rs.getString("content"));
				aPost.setImage(rs.getString("image"));
				aPost.setUsernameId(rs.getString("usernameId"));
				aPost.setCreateTime(rs.getString("createTime"));
				aPost.setCategoryId(rs.getInt("categoryId"));
				
				return aPost;
			}
			
		});
		
		return listPost;
	}
	@Override
	public Post get(int id) {
		String sql = "SELECT * FROM articles WHERE id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Post>() {

			@Override
			public Post extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Post post = new Post();
					post.setId(rs.getInt("id"));
					post.setName(rs.getString("name"));
					post.setContent(rs.getString("content"));
					post.setImage(rs.getString("image"));
					post.setUsernameId(rs.getString("usernameId"));
					post.setCreateTime(rs.getString("createTime"));
					post.setCategoryId(rs.getInt("categoryId"));
					return post;
				}
				
				return null;
			}
			
		});
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM articles WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

}
