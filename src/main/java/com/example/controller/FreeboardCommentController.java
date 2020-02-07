package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Freeboard;
import com.example.model.FreeboardComment;
import com.example.repository.FreeboardCommentRepository;
import com.example.service.freeboardComment.FreeboardCommentListService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FreeboardCommentController {
	
	@Autowired
	private FreeboardCommentListService freeboardCommentListService;
	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping(value="/freeboardCommentList", produces=MediaTypes.HAL_JSON_VALUE)
	@ResponseBody
	public String freeboardCommentList(){
		Freeboard freeboard = (Freeboard) session.getAttribute("freeboard");
		List<FreeboardComment> commentList = freeboardCommentListService.getList(freeboard.getFreeId());
		String value = null;
		try {
			value = objectMapper.writeValueAsString(commentList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	@PostMapping("/freeboardCommentWrite")
	@ResponseBody
	public String freeboardCommentWrite(@RequestBody FreeboardComment freeboardComment) {
		freeboardComment.setWriteDate(LocalDateTime.now());
		freeboardCommentRepository.save(freeboardComment);
		return "freeboardComment inserted";
	}
}
