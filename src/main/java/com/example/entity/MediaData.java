/*
 * 
 */
 package com.example.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaData {

	private int id;
	private Date date;
	private BaseRenderedData guid;
	private Date modified;
	private String slug;
	private String type;
	private int author;
	@JsonProperty("comment_status")
	private String commentStatus;
	@JsonProperty("ping_status")
	private String pingStatus;
	@JsonProperty("alt_text")
	private String altText;
	private BaseRenderedData description;
	private BaseRenderedData caption;
	@JsonProperty("media_type")
	private String mediaType;
	@JsonProperty("mime_type")
	private String mimeType;
	@JsonProperty("source_url")
	private String sourceUrl;

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

	public BaseRenderedData getGuid() {
		return guid;
	}

	public void setGuid(final BaseRenderedData guid) {
		this.guid = guid;
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

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(final int author) {
		this.author = author;
	}

	public String getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(final String commentStatus) {
		this.commentStatus = commentStatus;
	}

	public String getPingStatus() {
		return pingStatus;
	}

	public void setPingStatus(final String pingStatus) {
		this.pingStatus = pingStatus;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(final String altText) {
		this.altText = altText;
	}

	public BaseRenderedData getDescription() {
		return description;
	}

	public void setDescription(final BaseRenderedData description) {
		this.description = description;
	}

	public BaseRenderedData getCaption() {
		return caption;
	}

	public void setCaption(final BaseRenderedData caption) {
		this.caption = caption;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(final String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(final String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}


}
