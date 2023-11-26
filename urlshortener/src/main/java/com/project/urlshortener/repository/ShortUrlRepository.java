package com.project.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.project.urlshortener.entity.ShortUrlEntity;


@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
	
	ShortUrlEntity findByKey(String key);
	ShortUrlEntity findByFullUrl(String fullUrl);
	

}
