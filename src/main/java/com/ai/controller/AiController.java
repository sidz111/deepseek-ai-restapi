package com.ai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.service.AiService;

@RestController
public class AiController {
	private AiService aiService;

	public AiController(AiService aiService) {
		this.aiService = aiService;
	}

	@GetMapping("/ask")
	public ResponseEntity<String> askMeAnything(
			@RequestParam(value = "query", required = false, defaultValue = "How are you? How can you help me?") String query) {

		String response = aiService.askMe(query);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
