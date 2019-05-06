/*
 * 
 */
 package com.example.wordpress.resource;

import java.util.List;

public class PageablePost {
	private List<Post> posts;
	private int totalPages;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(final List<Post> posts) {
		this.posts = posts;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(final int totalPages) {
		this.totalPages = totalPages;
	}

}
