/*
 * 
 */
 package com.example.converters;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.client.WpApiClient;
import com.example.data.PostData;
import com.example.wordpress.resource.Post;

@Component(value = "postConverter")
public class PostConverter implements Converter<Post, PostData> {

	@Resource(name = "wpApiClient")
	private WpApiClient wpApiClient;

	@Resource(name = "mediaConverter")
	private MediaConverter mediaConverter;


	@Override
	public PostData convert(final Post source) {
		final PostData postData = new PostData();
		if ("publish".equals(source.getStatus())) {
			postData.setId(source.getId());
			postData.setDate(source.getDate());
			postData.setTitle(source.getTitle().getRendered());
			postData.setExcerpt(source.getExcerpt().getRendered());
			postData.setContent(source.getContent().getRendered());
			postData.setMedia(getMediaConverter().convert(getWpApiClient().getMedia(source.getFeaturedMedia())));
		}
		return postData;
	}


	public WpApiClient getWpApiClient() {
		return wpApiClient;
	}

	public void setWpApiClient(final WpApiClient wpApiClient) {
		this.wpApiClient = wpApiClient;
	}

	public MediaConverter getMediaConverter() {
		return mediaConverter;
	}

	public void setMediaConverter(final MediaConverter mediaConverter) {
		this.mediaConverter = mediaConverter;
	}


}
