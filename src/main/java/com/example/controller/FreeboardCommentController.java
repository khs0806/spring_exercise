package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeboardCommentController {
	
	@GetMapping("/freeboardCommentList")
	@ResponseBody
	public Map<String, String> freeboardCommentList(){
		return null;
	}
}
