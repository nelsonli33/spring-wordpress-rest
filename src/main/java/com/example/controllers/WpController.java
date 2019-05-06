/*
 * 
 */
 package com.example.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.data.CategoryData;
import com.example.data.PageablePostData;
import com.example.data.PostData;
import com.example.facades.WpApiFacade;

@Controller
public class WpController {

	@Resource(name = "wpApiFacade")
	private WpApiFacade wpApiFacade;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String showPostsForCategory(@PathVariable("categoryId") final int id, final Model model) {
		final List<PostData> postData = wpApiFacade.getPostsForCategory(id);
		final CategoryData categoryData = wpApiFacade.getCategoryForId(id);
		model.addAttribute("categoryData", categoryData);
		model.addAttribute("postData", postData);
		return "post-category";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String showPosts(final Model model) {
		final PageablePostData pageablePostData = wpApiFacade.getPosts();
		model.addAttribute("pageablePostData", pageablePostData);
		return "post";
    }

	@RequestMapping(value = "/posts", params = "page", method = RequestMethod.GET)
	public String showPaginationPosts(@RequestParam("page") final int page, final Model model) {
		final PageablePostData pageablePostData = wpApiFacade.getPostsForPage(page);
		model.addAttribute("pageablePostData", pageablePostData);
		return "post";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String showArticle(@PathVariable("id") final int id, final Model model) {
		final PostData postData = wpApiFacade.getPostForId(id);
		model.addAttribute("postData", postData);
		return "article";
	}

}
