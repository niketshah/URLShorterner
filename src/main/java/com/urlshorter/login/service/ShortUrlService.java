package com.urlshorter.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshorter.login.model.ShortUrl;
import com.urlshorter.login.repository.ShortUrlRepository;



@Service("ShortUrlService")
public class ShortUrlService {

	@Autowired
	ShortUrlRepository urlRepo;

	@Autowired
	ShortnerURl shrtService;
	

	public ShortUrl saveShortUrl(ShortUrl shortUrl) {
		shortUrl.setShortUrl(shrtService.create(shortUrl.getFullUrl()));

		return urlRepo.save(shortUrl);
	}

	public List<ShortUrl> getAllUrl() {
		
		return urlRepo.findAll();
	}

}
