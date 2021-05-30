package org.mule.extension.entity;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@JsonPropertyOrder({ "target", "message_data"})
public class MessageCreate {
	@JsonProperty("target")
	private Target target;
	
	@JsonProperty("message_data")
	private MessageData message_data;
	MessageCreate(){
		super();
	}
	MessageCreate(Target target, MessageData message_data){
		setTarget(target);
		setMessage_data(message_data);
	}
	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public MessageData getMessage_data() {
		return message_data;
	}

	public void setMessage_data(MessageData message_data) {
		this.message_data = message_data;
	}
	
	
}
