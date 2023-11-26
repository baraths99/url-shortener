package com.project.urlshortener.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.urlshortener.config.ShortUrlConfig;

@Component
public class ShortUrlUtil {

	
	private ShortUrlConfig config;

	@Autowired
	public ShortUrlUtil(ShortUrlConfig config) {
		this.config = config;
	}
	
	
	
	public String generateUniqueId()
	{
		int keyLength = config.getLength();
		String allowedCharacters  = config.getAllowedCharacters();
		StringBuilder keyBuilder  =new StringBuilder();
		Random random = new Random();
		
		for(int i=0;i<keyLength;i++)
		{
			int randomIndex = random.nextInt(allowedCharacters.length());
			keyBuilder.append(allowedCharacters.charAt(randomIndex));
					
		}
		
		return keyBuilder.toString();
		
		
		
	}
	
	
}
