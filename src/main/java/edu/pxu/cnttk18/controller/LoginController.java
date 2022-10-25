package edu.pxu.cnttk18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.pxu.cnttk18.model.Account;

@Controller
public class LoginController {
	@ModelAttribute("account")
	public Account set() {
		return new Account();
	}
	
	@RequestMapping("/login")
	public String home() {
		return "login";
	}
	
	@PostMapping("/submit")
    public ModelAndView loginUser(@ModelAttribute("account") Account account){
		if (account.getUserName().equals("admin")&& account.getPassword().equals("admin")) {
			ModelAndView modelAndView = new ModelAndView("admin");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("login");
	        modelAndView.addObject("message", "ten tai khoan dang nhap hoac mat khau bi sai!!");
	        return modelAndView;
		}
    }		
} 
