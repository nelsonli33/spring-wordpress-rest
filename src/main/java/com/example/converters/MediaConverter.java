/*
 * 
 */
 package com.example.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.data.MediaData;
import com.example.wordpress.resource.Media;

@Component(value = "mediaConverter")
public class MediaConverter implements Converter<Media, MediaData> {

	@Override
	public MediaData convert(final Media source) {
		final MediaData mediaData = new MediaData();
		mediaData.setAltText(source.getAltText());
		mediaData.setId(source.getId());
		mediaData.setSourceUrl(source.getSourceUrl());
		mediaData.setDescription(source.getDescription().getRendered());
		return mediaData;
	}

}
