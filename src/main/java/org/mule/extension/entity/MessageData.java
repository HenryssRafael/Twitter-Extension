package org.mule.extension.entity;

import org.codehaus.jackson.annotate.JsonProperty;

public class MessageData {
	@JsonProperty("text")
	private String text;

	MessageData() {
	}

	MessageData(String message) {
		setText(message);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
