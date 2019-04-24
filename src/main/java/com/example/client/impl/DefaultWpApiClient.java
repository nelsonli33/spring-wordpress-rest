/*
 * 
 */
 package com.example.client.impl;


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

import com.example.client.WpApiClient;
import com.example.entity.ArticleData;
import com.example.entity.MediaData;
import com.example.entity.PageablePostData;
import com.example.entity.PostData;

@Component(value = "wpApiClient")
public class DefaultWpApiClient implements WpApiClient {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultWpApiClient.class);

	private static String WORDPRESS_DOMAIN = "https://runners-blog.com";

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;


	@Override
	public PageablePostData getPosts() {
		return getPosts(1);
	}

	@Override
	public PageablePostData getPosts(final int page) {
		URI targetUrl = UriComponentsBuilder.fromUriString(WORDPRESS_DOMAIN).path("/wp-json/wp/v2/posts").build()
				.toUri();

		if (page > 1) {
			targetUrl = UriComponentsBuilder.fromUriString(WORDPRESS_DOMAIN).path("/wp-json/wp/v2/posts")
					.queryParam("page", page).build().toUri();
		}

		final ResponseEntity<List<PostData>> postsResp = restTemplate.exchange(
				targetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PostData>>() {
				});

		final List<PostData> posts = postsResp.getBody();
		final HttpHeaders headers = postsResp.getHeaders();
		final int totalPages = Integer.parseInt(headers.getFirst("X-WP-TotalPages"));

		final PageablePostData pageablePostData = new PageablePostData();
		pageablePostData.setPosts(posts);
		pageablePostData.setPage(page);
		pageablePostData.setTotalPages(totalPages);
		return pageablePostData;

	}

	@Override
	public ArticleData getArticle(final String id) {

		final PostData post = restTemplate.getForObject(WORDPRESS_DOMAIN + "/wp-json/wp/v2/posts/{id}", PostData.class,
				id);
		final MediaData media = getMedia(post.getFeaturedMedia());
		final ArticleData article = new ArticleData();
		article.setPost(post);
		article.setMedia(media);
		return article;

	}

	@Override
	public MediaData getMedia(final int id) {
		final MediaData media = restTemplate.getForObject(WORDPRESS_DOMAIN + "/wp-json/wp/v2/media/{id}",
				MediaData.class, id);
		return media;
	}


	public void setRestTemplate(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}



}
