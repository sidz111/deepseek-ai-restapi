package com.ai.service.iml;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.ai.service.AiService;

@Service
public class AiServiceImpl implements AiService{
	
	private ChatClient chatClient;
	
	public AiServiceImpl(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@Override
	public String askMe(String question) {
		return chatClient.prompt(question).call().content();
	}

}
