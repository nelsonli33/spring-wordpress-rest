/*
 * 
 */
 package com.example.controllers;

import java.util.List;

import javax.annotation.Resource;

import com.example.service.WpApiService;
import com.example.wordpress.resource.Category;
import com.example.wordpress.resource.PageablePost;
import com.example.wordpress.resource.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WpController {

	@Resource(name = "wpApiService")
	private WpApiService wpApiService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String showPostsForCategory(@PathVariable("categoryId") final int id, final Model model) {
		final List<Post> posts = wpApiService.getPostsForCategory(id);
		final Category category = wpApiService.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("posts", posts);
		return "post-category";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String showPosts(final Model model) {
		final PageablePost pageablePost = wpApiService.getPosts();
		model.addAttribute("pageablePost", pageablePost);
		return "post";
    }

	@RequestMapping(value = "/posts", params = "page", method = RequestMethod.GET)
	public String showPaginationPosts(@RequestParam("page") final int page, final Model model) {
		final PageablePost pageablePost = wpApiService.getPostsForPage(page);
		model.addAttribute("pageablePost", pageablePost);
		return "post";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String showArticle(@PathVariable("id") final int id, final Model model) {
		final Post post = wpApiService.getPostForId(id);
		model.addAttribute("post", post);
		return "article";
	}

}
