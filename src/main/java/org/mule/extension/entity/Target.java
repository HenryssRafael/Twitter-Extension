package org.mule.extension.entity;

import org.codehaus.jackson.annotate.JsonProperty;

public class Target {
	@JsonProperty("recipient_id")
	private String recipient_id;

	Target() {
	}

	Target(String recipient_id) {
		setRecipient_id(recipient_id);
	}

	public String getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}

}
