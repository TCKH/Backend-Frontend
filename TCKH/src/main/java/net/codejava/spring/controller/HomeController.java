package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.ContactDAO;
import net.codejava.spring.model.Contact;

import net.codejava.spring.dao.PostDAO;
import net.codejava.spring.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private PostDAO postDAO;

	@RequestMapping(value="/ListContact", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Contact> ListContact() throws IOException{
		List<Contact> listContact = contactDAO.list();
		return listContact;
	}
	@RequestMapping(value = "/post", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Post> listPost() throws IOException{
		List<Post> listPost = postDAO.list();
		return listPost;
	}
	@RequestMapping(value = "/newContact", method = RequestMethod.POST)
	public @ResponseBody void newContact(@RequestBody Contact contact) {
		contactDAO.saveOrUpdate(contact);		
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdate(contact);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		
		return model;
	}
	
}
