package org.mule.extension.twitter.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.extension.entity.ResponseMessage;
import org.mule.extension.twitter.exception.RestJerseyConnectorException;
import org.mule.extension.twitter.exception.RestJerseyConnectorTokenExpiredException;
import org.mule.restclient.TwitterClient;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class TwitterOperations {
	private TwitterClient twitterClient;
	private final Logger LOGGER = LoggerFactory.getLogger(TwitterOperations.class);

	@MediaType(value = ANY, strict = false)
	public ResponseMessage directMessage(@Alias("recipientId")String recipientId, @Alias("message") String message, @Config TwitterConfiguration configuration) {
		this.twitterClient = new TwitterClient(configuration);
		boolean success = true;
		ResponseMessage response = new ResponseMessage(recipientId,message);
		try {
			response.setSuccessful(this.twitterClient.directMessage(recipientId, message));
		} catch (RestJerseyConnectorException | RestJerseyConnectorTokenExpiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			response.setSuccessful(false);
			response.setMessage(message); ; 
		}
		return response;
	}

}
