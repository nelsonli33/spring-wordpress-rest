/*
 * 
 */
package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRenderedData {

	private String rendered;
	@JsonProperty(value = "protected", required = false)
	private String isProtected;

	public String getRendered() {
		return rendered;
	}

	public void setRendered(final String rendered) {
		this.rendered = rendered;
	}
	public String getIsProtected() {
		return isProtected;
	}

	public void setIsProtected(final String isProtected) {
		this.isProtected = isProtected;
	}


}
