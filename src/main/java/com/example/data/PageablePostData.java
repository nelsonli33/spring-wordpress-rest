/*
 * 
 */
 package com.example.data;

import java.util.List;

public class PageablePostData {

	private List<PostData> posts;
	private int totalPages;

	public List<PostData> getPosts() {
		return posts;
	}

	public void setPosts(final List<PostData> posts) {
		this.posts = posts;
	}


	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(final int totalPages) {
		this.totalPages = totalPages;
	}

}
