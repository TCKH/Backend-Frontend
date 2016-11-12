package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Post;
import net.codejava.spring.model.User;

@Controller
public class AccountController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody Boolean register(@RequestBody User user) {
		User userRegister = new User();
		userRegister = userDAO.get(user.getUsername());
		if(userRegister == null){
			userDAO.insert(user);
			return true;
		}else if(userRegister != null){
			userDAO.update(user);
			return true;
		}
		return false;
	}
	@RequestMapping(value="/UserType", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> UserType() throws IOException{
		List<User> userType = userDAO.list();
		return userType;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User Login(@RequestBody User user) {

		User userRegister = new User();
		userRegister = userDAO.get(user.getUsername());
		if(userRegister != null){
			if(userRegister.getPassword().equals(user.getPassword())){
				String token = UUID.randomUUID().toString();
				System.out.println(token);
				userRegister.setToken(token);
				userDAO.update(userRegister);
				return userRegister;
			}
		}
		return userRegister;
	}
	@RequestMapping(value="/ListUsers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> ListArticle() throws IOException{
		List<User> listArticle = userDAO.list();
		return listArticle;
	}
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody List<User> DeleteUser(@RequestBody User user) {
		userDAO.delete(user.getUsername());
		List<User> listUser = userDAO.list();
		return listUser;
	}
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public @ResponseBody Boolean EditUser(@RequestBody User user) {
		userDAO.update(user);
		return true;
	}
	
}	
