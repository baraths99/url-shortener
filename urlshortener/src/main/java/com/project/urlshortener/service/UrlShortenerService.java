package com.project.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.urlshortener.config.ShortUrlConfig;
import com.project.urlshortener.dto.ShortUrlRequest;
import com.project.urlshortener.dto.ShortUrlResponse;
import com.project.urlshortener.entity.ShortUrlEntity;
import com.project.urlshortener.repository.ShortUrlRepository;
import com.project.urlshortener.util.ShortUrlUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UrlShortenerService {
	@Autowired
	private final ShortUrlRepository repository;
	@Autowired
	private final ShortUrlUtil util;

	public ShortUrlResponse createShortUrl(ShortUrlRequest request) {
		String fullUrl = request.getUrl();
		ShortUrlEntity existingUrl = repository.findByFullUrl(fullUrl);
		if(existingUrl!=null)
		{
		   return ShortUrlResponse.builder().key(existingUrl.getKey()).build();	
		}
		else
		{
			String newKey = util.generateUniqueId();
			ShortUrlEntity newEntity = ShortUrlEntity.builder().key(newKey)
		                               .fullUrl(fullUrl).clickCount(0L).build();
			repository.save(newEntity);
			return ShortUrlResponse.builder().key(newKey).build();
		}
	}

}
