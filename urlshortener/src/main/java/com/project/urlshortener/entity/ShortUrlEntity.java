package com.project.urlshortener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="urls")
public class ShortUrlEntity {
	
	@Id
	@Column(name = "id",nullable  =false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String key;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String fullUrl;
	
	@Column(nullable = false)
	private Long clickCount;

}
