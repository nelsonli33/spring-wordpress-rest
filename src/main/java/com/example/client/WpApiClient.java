/*
 * 
 */
 package com.example.client;

import com.example.entity.ArticleData;
import com.example.entity.MediaData;
import com.example.entity.PageablePostData;

public interface WpApiClient {

	PageablePostData getPosts();

	PageablePostData getPosts(final int page);

	ArticleData getArticle(final String id);

	MediaData getMedia(final int id);

}
