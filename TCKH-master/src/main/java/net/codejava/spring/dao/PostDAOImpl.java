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
			String sql = "UPDATE articles SET name=?, keyword=?, title=?, "
						+ "lastModified=?, usernameId=?, nameAuthor=?, size=?, reviewer=?, comment=? WHERE id=?";
			jdbcTemplate.update(sql, post.getName(), post.getKeyword(),
					post.getTitle(), post.getLastModified(), post.getUsernameId(), 
					post.getNameAuthor(), post.getSize(), post.getReviewer(), post.getComment(), post.getId());
		} else {
			// insert
			String sql = "INSERT INTO articles (name, keyword, title, usernameId,lastModified,nameAuthor,size,reviewer,comment)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, post.getName(), post.getKeyword(),
					post.getTitle(), post.getUsernameId(), post.getLastModified(), post.getNameAuthor(), 
					post.getSize(), post.getReviewer(), post.getComment());
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
				aPost.setKeyword(rs.getString("keyword"));
				aPost.setTitle(rs.getString("title"));
				aPost.setUsernameId(rs.getString("usernameId"));
				aPost.setLastModified(rs.getString("lastModified"));
				aPost.setNameAuthor(rs.getString("nameAuthor"));
				aPost.setSize(rs.getDouble("size"));
				aPost.setReviewer(rs.getString("reviewer"));
				aPost.setComment(rs.getString("comment"));
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
					post.setKeyword(rs.getString("keyword"));
					post.setTitle(rs.getString("title"));
					post.setUsernameId(rs.getString("usernameId"));
					post.setLastModified(rs.getString("lastModified"));
					post.setNameAuthor(rs.getString("nameAuthor"));
					post.setSize(rs.getDouble("size"));
					post.setReviewer(rs.getString("reviewer"));
					post.setComment(rs.getString("comment"));
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
