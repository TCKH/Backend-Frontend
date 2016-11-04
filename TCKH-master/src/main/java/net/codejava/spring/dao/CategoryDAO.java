package net.codejava.spring.dao;
import java.util.List;

import net.codejava.spring.model.Category;

public interface CategoryDAO {
	public Category get(int id);
	public List<Category> list();
}
