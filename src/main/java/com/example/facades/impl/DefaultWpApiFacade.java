/*
 * 
 */
 package com.example.facades.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.client.WpApiClient;
import com.example.converters.CategoryConverter;
import com.example.converters.MediaConverter;
import com.example.converters.PageablePostConverter;
import com.example.converters.PostConverter;
import com.example.data.CategoryData;
import com.example.data.MediaData;
import com.example.data.PageablePostData;
import com.example.data.PostData;
import com.example.facades.WpApiFacade;
import com.example.wordpress.resource.Category;
import com.example.wordpress.resource.Media;
import com.example.wordpress.resource.PageablePost;
import com.example.wordpress.resource.Post;

@Component(value = "wpApiFacade")
public class DefaultWpApiFacade implements WpApiFacade {

	@Resource(name = "wpApiClient")
	private WpApiClient wpApiClient;

	@Resource(name = "postConverter")
	private PostConverter postConverter;

	@Resource(name = "mediaConverter")
	private MediaConverter mediaConverter;

	@Resource(name = "categoryConverter")
	private CategoryConverter categoryConverter;

	@Resource(name = "pageablePostConverter")
	private PageablePostConverter pageablePostConverter;


	@Override
	public PageablePostData getPosts() {
		return getPostsForPage(1);
	}

	@Override
	public PageablePostData getPostsForPage(final int page) {
		final PageablePost pageablePost = wpApiClient.getPostsForPage(page);
		return getPageablePostConverter().convert(pageablePost);
	}


	@Override
	public PostData getPostForId(final int id) {
		final Post post = getWpApiClient().getPostForId(id);
		return getPostConverter().convert(post);
	}

	@Override
	public List<PostData> getPostsForCategory(final int id) {
		final List<Post> posts = getWpApiClient().getPostsForCategory(id);
		return getPostConverter().convertAll(posts);
	}

	@Override
	public MediaData getMediaForId(final int id) {
		final Media media = getWpApiClient().getMedia(id);
		return getMediaConverter().convert(media);
	}

	@Override
	public CategoryData getCategoryForId(final int id) {
		final Category category = getWpApiClient().getCategory(id);
		return getCategoryConverter().convert(category);
	}




	public WpApiClient getWpApiClient() {
		return wpApiClient;
	}

	public void setWpApiClient(final WpApiClient wpApiClient) {
		this.wpApiClient = wpApiClient;
	}

	public PostConverter getPostConverter() {
		return postConverter;
	}

	public void setPostConverter(final PostConverter postConverter) {
		this.postConverter = postConverter;
	}

	public MediaConverter getMediaConverter() {
		return mediaConverter;
	}

	public void setMediaConverter(final MediaConverter mediaConverter) {
		this.mediaConverter = mediaConverter;
	}

	public PageablePostConverter getPageablePostConverter() {
		return pageablePostConverter;
	}

	public void setPageablePostConverter(final PageablePostConverter pageablePostConverter) {
		this.pageablePostConverter = pageablePostConverter;
	}

	public CategoryConverter getCategoryConverter() {
		return categoryConverter;
	}

	public void setCategoryConverter(final CategoryConverter categoryConverter) {
		this.categoryConverter = categoryConverter;
	}

}
