/*
 * 
 */
 package com.example.service.impl;


import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.service.WpApiService;
import com.example.wordpress.resource.Category;
import com.example.wordpress.resource.Media;
import com.example.wordpress.resource.PageablePost;
import com.example.wordpress.resource.Post;

@Component(value = "wpApiService")
public class DefaultWpApiService implements WpApiService {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultWpApiService.class);

	private static String WORDPRESS_DOMAIN = "https://runners-blog.com";

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;


	@Override
	public PageablePost getPosts() {
		return getPostsForPage(1);
	}

	@Override
	public PageablePost getPostsForPage(final int page) {
		URI targetUrl = UriComponentsBuilder.fromUriString(WORDPRESS_DOMAIN).path("/wp-json/wp/v2/posts").build()
				.toUri();

		if (page > 1) {
			targetUrl = UriComponentsBuilder.fromUriString(WORDPRESS_DOMAIN).path("/wp-json/wp/v2/posts")
					.queryParam("page", page).build().toUri();
		}

		final ResponseEntity<List<Post>> postsResp = restTemplate.exchange(
				targetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});
		final List<Post> posts = postsResp.getBody();
		final HttpHeaders headers = postsResp.getHeaders();
		final int totalPages = Integer.parseInt(headers.getFirst("X-WP-TotalPages"));

		final PageablePost pageablePost = new PageablePost();
		pageablePost.setPosts(posts);
		pageablePost.setTotalPages(totalPages);
		return pageablePost;
	}



	@Override
	public List<Post> getPostsForCategory(final int id) {
		final URI targetUrl = UriComponentsBuilder.fromUriString(WORDPRESS_DOMAIN).path("/wp-json/wp/v2/posts")
				.queryParam("categories", id).queryParam("orderby", "date").build().toUri();
		final ResponseEntity<List<Post>> postsResp = restTemplate.exchange(targetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});

		final List<Post> posts = postsResp.getBody();
		return posts;
	}


	@Override
	public Post getPostForId(final int id) {
		return restTemplate.getForObject(WORDPRESS_DOMAIN + "/wp-json/wp/v2/posts/{id}", Post.class, id);
	}


	@Override
	public Media getMedia(final int id) {
		return restTemplate.getForObject(WORDPRESS_DOMAIN + "/wp-json/wp/v2/media/{id}",
				Media.class, id);
	}


	@Override
	public Category getCategory(final int id) {
		return restTemplate.getForObject(WORDPRESS_DOMAIN + "/wp-json/wp/v2/categories/{id}",
				Category.class, id);
	}

	public void setRestTemplate(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


}
