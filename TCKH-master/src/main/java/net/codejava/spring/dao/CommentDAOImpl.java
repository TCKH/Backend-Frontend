package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Comment;

public class CommentDAOImpl implements CommentDAO {
private JdbcTemplate jdbcTemplate;
	
	public CommentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(Comment comment) {
		System.out.println(comment);
		if (comment.getId() > 0) {
			// update
			String sql = "UPDATE comment SET articleId=?, version=?, content=?, "
						+ "title=?, type=?, date=?, fileName=? WHERE id=?";
			jdbcTemplate.update(sql, comment.getArticleId(), comment.getVersion(),
					comment.getContent(), comment.getTitle(), comment.getType(), 
					comment.getDate(), comment.getFileName(), comment.getId());
		} else {
			// insert
			String sql = "INSERT INTO comment (articleId, version, content, title,type,date,fileName)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, comment.getArticleId(), comment.getVersion(),
					comment.getContent(), comment.getTitle(), comment.getType(), 
					comment.getDate(), comment.getFileName());
		}
	}
	@Override
	public List<Comment> list() {
		String sql = "SELECT * FROM comment";
		List<Comment> listComment = jdbcTemplate.query(sql, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Comment aComment = new Comment();
	
				aComment.setId(rs.getInt("id"));
				aComment.setVersion(rs.getInt("version"));
				aComment.setArticleId(rs.getInt("articleId"));
				aComment.setTitle(rs.getString("title"));
				aComment.setContent(rs.getString("content"));
				aComment.setDate(rs.getString("date"));
				aComment.setType(rs.getString("type"));
				aComment.setFileName(rs.getString("fileName"));
				return aComment;
			}
			
		});
		
		return listComment;
	}
	@Override
	public Comment get(int id) {
		String sql = "SELECT * FROM comment WHERE id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Comment>() {

			@Override
			public Comment extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Comment _comment = new Comment();
					_comment.setId(rs.getInt("id"));
					_comment.setVersion(rs.getInt("version"));
					_comment.setArticleId(rs.getInt("articleId"));
					_comment.setTitle(rs.getString("title"));
					_comment.setContent(rs.getString("content"));
					_comment.setDate(rs.getString("date"));
					_comment.setType(rs.getString("type"));
					_comment.setFileName(rs.getString("fileName"));
					return _comment;
				}
				
				return null;
			}
			
		});
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM comment WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

}
