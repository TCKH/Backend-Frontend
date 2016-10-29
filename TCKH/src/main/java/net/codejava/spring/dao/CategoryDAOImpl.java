package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import net.codejava.spring.model.Category;

public class CategoryDAOImpl implements CategoryDAO{
private JdbcTemplate jdbcTemplate;
	
	public CategoryDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Category> list() {
		String sql = "SELECT * FROM categories";
		List<Category> listCategory = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
	
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				return category;
			}
		});
		return listCategory;
	}
	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM categories WHERE id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Category>() {

			@Override
			public Category extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Category category = new Category();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					return category;
				}
				return null;
			}
			
		});
	}
}
