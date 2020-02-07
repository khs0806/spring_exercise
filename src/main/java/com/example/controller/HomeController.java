package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/joinPage")
	public String joinPage() {
		return "join";
	}
	
	@RequestMapping(value="/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/logoutPage")
	public String logoutPage() {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="/freeboardWritePage")
	public String freeboardWritePage(){
		return "freeboardWrite";
	}
}
