/*
 * 
 */
 package com.example.facades;

import java.util.List;

import com.example.data.CategoryData;
import com.example.data.MediaData;
import com.example.data.PageablePostData;
import com.example.data.PostData;

public interface WpApiFacade {

	PageablePostData getPosts();

	PageablePostData getPostsForPage(final int page);

	List<PostData> getPostsForCategory(final int id);

	PostData getPostForId(final int id);

	MediaData getMediaForId(final int id);

	CategoryData getCategoryForId(final int id);

}
