/*
 * 
 */
 package com.example.service;

import java.util.List;

import com.example.wordpress.resource.Category;
import com.example.wordpress.resource.Media;
import com.example.wordpress.resource.PageablePost;
import com.example.wordpress.resource.Post;

public interface WpApiService {

	PageablePost getPosts();

	PageablePost getPostsForPage(final int page);

	Post getPostForId(final int id);

	List<Post> getPostsForCategory(int id);

	Media getMedia(final int id);

	Category getCategory(final int id);

}
