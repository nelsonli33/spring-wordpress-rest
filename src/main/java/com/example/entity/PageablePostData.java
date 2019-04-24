/*
 * 
 */
 package com.example.entity;

import java.util.List;

public class PageablePostData {

	private List<PostData> posts;
	private int page;
	private int totalPages;

	public List<PostData> getPosts() {
		return posts;
	}

	public void setPosts(final List<PostData> posts) {
		this.posts = posts;
	}

	public int getPage() {
		return page;
	}

	public void setPage(final int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(final int totalPages) {
		this.totalPages = totalPages;
	}

}
