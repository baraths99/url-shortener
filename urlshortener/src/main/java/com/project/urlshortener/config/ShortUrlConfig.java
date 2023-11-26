package com.project.urlshortener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "short-url")
@Getter
@Setter
public class ShortUrlConfig {
	
	private String allowedCharacters;
	private int length;

}
