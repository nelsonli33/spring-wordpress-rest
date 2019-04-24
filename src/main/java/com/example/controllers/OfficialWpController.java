/*
 * 
 */
 package com.example.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.client.WpApiClient;
import com.example.entity.ArticleData;
import com.example.entity.PageablePostData;

@Controller
public class OfficialWpController {

	@Resource(name = "wpApiClient")
	private WpApiClient wpApiClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPosts(final Model model) {
		final PageablePostData posts = wpApiClient.getPosts();
		model.addAttribute("postData", posts);
		return "index";
    }

	@RequestMapping(value = "/", params = "page", method = RequestMethod.GET)
	public String showPaginationPosts(@RequestParam("page") final int page, final Model model) {
		final PageablePostData posts = wpApiClient.getPosts(page);
		model.addAttribute("postData", posts);
		return "index";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String showArticle(@PathVariable("id") final String id, final Model model) {
		final ArticleData article = wpApiClient.getArticle(id);
		model.addAttribute("articleData", article);
		return "article";
	}

}
