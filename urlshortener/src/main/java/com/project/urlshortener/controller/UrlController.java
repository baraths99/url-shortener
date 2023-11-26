package com.project.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.urlshortener.dto.ShortUrlRequest;
import com.project.urlshortener.dto.ShortUrlResponse;
import com.project.urlshortener.service.UrlShortenerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UrlController {
	
	@Autowired
	private final UrlShortenerService service;
	
	@PostMapping("/createUrl")
	public ResponseEntity<ShortUrlResponse> createUrl(@RequestBody ShortUrlRequest request){
		
		ShortUrlResponse response = service.createShortUrl(request);
		
		return ResponseEntity.ok(response);
		
		
	}

}
