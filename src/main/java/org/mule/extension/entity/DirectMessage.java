package org.mule.extension.entity;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DirectMessage {
	private Event event;
	DirectMessage(){
		super();
	}
	public DirectMessage(String receiptId,String message){
		this.event = new Event();
		this.event.setType("message_create");
		this.event.setMessage_create(new MessageCreate(new Target(receiptId), new MessageData(message)));
	} 
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}


	

	

}
