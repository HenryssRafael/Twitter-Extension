package org.mule.extension.entity;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "type", "message_create"})
public class Event {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("message_create")
	private MessageCreate message_create;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MessageCreate getMessage_create() {
		return message_create;
	}

	public void setMessage_create(MessageCreate message_create) {
		this.message_create = message_create;
	}
	
	
	
}
