package com.urlshorter.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.urlshorter.login.model.ShortUrl;
import com.urlshorter.login.model.User;
import com.urlshorter.login.service.ShortUrlService;

@Controller
public class ShortUrlController {

	@Autowired
	ShortUrlService urlShortService;

	@RequestMapping(value = "/admin/viewUrl", method = RequestMethod.GET)
	public ModelAndView viewUrl() {

		ModelAndView modelAndView = new ModelAndView();
		ShortUrl url = new ShortUrl();
		modelAndView.addObject("url", url);
		modelAndView.setViewName("admin/addUrl");
		modelAndView.addObject("urllist", urlShortService.getAllUrl());

		return modelAndView;

	}

	@RequestMapping(value = "/admin/addUrl", method = RequestMethod.POST)
	public ModelAndView addUrl(@Valid ShortUrl shortUrl, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();

		urlShortService.saveShortUrl(shortUrl);
		modelAndView.addObject("urllist", urlShortService.getAllUrl());

		modelAndView.setViewName("admin/viewUrl");
		return modelAndView;
	}

	
	@RequestMapping(value = "/api/addUrl", method = RequestMethod.POST)
	public String apiAddUrl(@RequestBody ShortUrl shortUrl) {


		urlShortService.saveShortUrl(shortUrl);
		return "Url Added Sucess";
	}
	

}
