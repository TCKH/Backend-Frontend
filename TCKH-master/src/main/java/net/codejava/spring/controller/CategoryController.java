package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.dao.CategoryDAO;
import net.codejava.spring.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value="/ListCategory", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Category> ListCategory() throws IOException{
		List<Category> listCategory = categoryDAO.list();
		return listCategory;
	}
}
