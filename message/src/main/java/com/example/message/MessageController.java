package com.example.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("messages")

public class MessageController {

    @GetMapping(value = "/{memberId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAllMessagesByMemberId(@PathVariable int memberId) throws JsonProcessingException {
    	List<String> messages = findMessagesByMemberId(memberId);
    	String jsonString = new ObjectMapper().writeValueAsString(messages);
    	return jsonString;
    }

	private List<String> findMessagesByMemberId(int memberId) {
		// TODO Auto-generated method stub
		Map<Integer, List<String>> allMessages = new HashMap();
		allMessages.put(1, new ArrayList<String>(Arrays.asList("test1","test2")));
		allMessages.put(2, new ArrayList<String>(Arrays.asList("test3","test4")));
		
		return allMessages.get(memberId);
	}
}
