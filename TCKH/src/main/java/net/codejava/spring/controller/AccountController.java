package net.codejava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.dao.UserDAO;
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
		}
		return false;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User Login(@RequestBody User user) {

		User userRegister = new User();
		userRegister = userDAO.get(user.getUsername());
		if(userRegister != null){
			if(userRegister.getPassword().equals(user.getPassword())){
				return userRegister;
			}
		}
		return userRegister;
	}
	
}	
