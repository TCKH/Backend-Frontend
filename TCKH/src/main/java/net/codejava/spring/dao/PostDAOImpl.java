package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import net.codejava.spring.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public List<Post> list() {
		String sql = "SELECT * FROM post";
		List<Post> listPost = jdbcTemplate.query(sql, new RowMapper<Post>() {

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post aPost = new Post();
	
				aPost.setId(rs.getInt("post_id"));
				aPost.setTitle(rs.getString("title"));
				aPost.setContent(rs.getString("content"));
				aPost.setComment(rs.getString("comment"));
				aPost.setAbstracts(rs.getString("abstracts"));
				aPost.setHighlights(rs.getString("highlights"));
				
				return aPost;
			}
			
		});
		
		return listPost;
	}

}
