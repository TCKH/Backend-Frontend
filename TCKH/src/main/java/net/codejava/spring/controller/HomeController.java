package net.codejava.spring.controller;

import net.codejava.spring.dao.PostDAO;
import net.codejava.spring.model.Post;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private PostDAO postDAO;

	@RequestMapping(value="/ListArticle", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Post> ListArticle() throws IOException{
		List<Post> listArticle = postDAO.list();
		return listArticle;
	}
	
	@RequestMapping(value = "/NewArticle", method = RequestMethod.POST)
	public @ResponseBody void newArticle(@RequestBody Post post) {
		postDAO.saveOrUpdate(post);
	}
	@RequestMapping(value = "/GetArticle", method = RequestMethod.POST)
	public @ResponseBody Post GetArticle(@RequestBody Post post) {
		post = postDAO.get(post.getId());
		return post;
	}
	@RequestMapping(value = "/DeleteArticle", method = RequestMethod.POST)
	public @ResponseBody List<Post> DeleteArticle(@RequestBody Post post) {
		postDAO.delete(post.getId());
		List<Post> listArticle = postDAO.list();
		return listArticle;
	}
	
}
