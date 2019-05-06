/*
 * 
 */
 package com.example.data;

import java.util.Date;

public class PostData {
	private int id;
	private Date date;
	private String title;
	private String content;
	private String excerpt;
	private MediaData media;

	public PostData() {

	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(final String excerpt) {
		this.excerpt = excerpt;
	}

	public MediaData getMedia() {
		return media;
	}

	public void setMedia(final MediaData media) {
		this.media = media;
	}



}
