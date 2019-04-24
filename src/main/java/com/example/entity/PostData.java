/*
 * 
 */
 package com.example.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData {

	private int id;
	private Date date;
	private Date modified;
	private String slug;
	private String link;
	private String status;
	private String type;
	private String password;
	private BaseRenderedData title;
	private BaseRenderedData content;
	private BaseRenderedData excerpt;
	@JsonProperty("featured_media")
	private int featuredMedia;
	private int author;
	private int[] categories;
	private int[] tags;

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
	public Date getModified() {
		return modified;
	}

	public void setModified(final Date modified) {
		this.modified = modified;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(final String slug) {
		this.slug = slug;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	public BaseRenderedData getTitle() {
		return title;
	}

	public void setTitle(final BaseRenderedData title) {
		this.title = title;
	}
	public BaseRenderedData getContent() {
		return content;
	}

	public void setContent(final BaseRenderedData content) {
		this.content = content;
	}
	public BaseRenderedData getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(final BaseRenderedData excerpt) {
		this.excerpt = excerpt;
	}

	public int getFeaturedMedia() {
		return featuredMedia;
	}

	public void setFeaturedMedia(final int featuredMedia) {
		this.featuredMedia = featuredMedia;
	}
	public int getAuthor() {
		return author;
	}

	public void setAuthor(final int author) {
		this.author = author;
	}
	public int[] getCategories() {
		return categories;
	}

	public void setCategories(final int[] categories) {
		this.categories = categories;
	}
	public int[] getTags() {
		return tags;
	}

	public void setTags(final int[] tags) {
		this.tags = tags;
	}

}
