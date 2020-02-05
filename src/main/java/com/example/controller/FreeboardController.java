package com.example.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.freeboard.FreeboardListService;
import com.example.service.freeboard.FreeboardWriteService;


@Controller
public class FreeboardController {
	
	@Autowired
    private FreeboardListService freeboardListService;
	
    @Autowired
    private FreeboardWriteService freeboardWriteService;
	
	private int returnIntValue(String stringToInt){
        return Integer.parseInt(stringToInt);
    }
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="pageNum", defaultValue="1")String pageNum) {
		String page = freeboardListService.freeboardList(returnIntValue(pageNum));
		return page;
	}
	
	@PostMapping("/freeboardWriteRequest")
    public String freeboardWriteRequest(@RequestParam Map<String ,String > paramMap){
        String title = paramMap.get("title");
        String content = paramMap.get("content");
        String writer = paramMap.get("writer");

        freeboardWriteService.write(title, content, writer);

        return "redirect:/freeboard";
    }
	
	@GetMapping("/freeBoardInfo")
	public String getPost(@RequestParam(value="freeid") String freeId) {
		return "freeBoardInfo";
	}
}
