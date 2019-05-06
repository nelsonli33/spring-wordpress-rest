/*
 * 
 */
 package com.example.converters;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.data.PageablePostData;
import com.example.data.PostData;
import com.example.wordpress.resource.PageablePost;

@Component(value = "pageablePostConverter")
public class PageablePostConverter implements Converter<PageablePost, PageablePostData> {

	@Resource(name = "postConverter")
	private PostConverter postConverter;

	@Override
	public PageablePostData convert(final PageablePost source) {

		final List<PostData> posts = getPostConverter().convertAll(source.getPosts());

		final PageablePostData pageablePostData = new PageablePostData();
		pageablePostData.setPosts(posts);
		pageablePostData.setTotalPages(source.getTotalPages());
		return pageablePostData;
	}

	public PostConverter getPostConverter() {
		return postConverter;
	}

	public void setPostConverter(final PostConverter postConverter) {
		this.postConverter = postConverter;
	}


}
