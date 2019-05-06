/*
 * 
 */
 package com.example.wordpress.resource;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

	private int id;
	private Date date;
	private Date modified;
	private String slug;
	private String link;
	private String status;
	private String type;
	private String password;
	private BaseRendered title;
	private BaseRendered content;
	private BaseRendered excerpt;
	@JsonProperty("featured_media")
	private int featuredMedia;
	private int author;
	private List<Integer> categories;
	private List<Integer> tags;



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
	public BaseRendered getTitle() {
		return title;
	}

	public void setTitle(final BaseRendered title) {
		this.title = title;
	}
	public BaseRendered getContent() {
		return content;
	}

	public void setContent(final BaseRendered content) {
		this.content = content;
	}
	public BaseRendered getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(final BaseRendered excerpt) {
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

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(final List<Integer> categories) {
		this.categories = categories;
	}

	public List<Integer> getTags() {
		return tags;
	}

	public void setTags(final List<Integer> tags) {
		this.tags = tags;
	}


}
