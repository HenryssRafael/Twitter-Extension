package org.mule.extension.entity;

public class ResponseMessage {
	private String recipientId;
	private String message;
	private boolean successful;

	ResponseMessage() {
	}

	public ResponseMessage(String recipientId, String message) {
		setRecipientId(recipientId);
		setMessage(message);
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	
}
