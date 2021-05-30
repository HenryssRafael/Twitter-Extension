package org.mule.restclient;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.extension.entity.DirectMessage;
import org.mule.extension.twitter.exception.RestJerseyConnectorException;
import org.mule.extension.twitter.exception.RestJerseyConnectorTokenExpiredException;
import org.mule.extension.twitter.internal.TwitterConfiguration;
import org.mule.extension.twitter.internal.TwitterOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

public class TwitterClient {
	private Client client;
	private WebResource apiResource;
	private TwitterConfiguration configuration;
	private final Logger LOGGER = LoggerFactory.getLogger(TwitterClient.class);
	public TwitterClient(TwitterConfiguration extension) {
		setConfiguration(extension);
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		this.client = Client.create(clientConfig);
		//this.client.addFilter(new LoggingFilter(System.out));
		this.apiResource = this.client
				.resource(getConfiguration().getApiUrl() + "/" + getConfiguration().getApiVersion());
		this.apiResource = addSignHeader(apiResource);
	}

	public boolean directMessage(String to, String message)
			throws RestJerseyConnectorException, RestJerseyConnectorTokenExpiredException {
		ObjectMapper mapper = new ObjectMapper();
		WebResource webResource = getApiResource().path("direct_messages").path("events").path("new.json");
		boolean success = true;
		try {
			webResource.accept(MediaType.APPLICATION_JSON).method("POST",
					mapper.writeValueAsString(new DirectMessage(to, message)));

		} catch (UniformInterfaceException | IOException e) {

			e.printStackTrace();
			success = false;
		}
		LOGGER.info("Envio exitoso: " + success);
		return success;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public WebResource getApiResource() {
		return apiResource;
	}

	public void setApiResource(WebResource apiResource) {
		this.apiResource = apiResource;
	}

	public TwitterConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(TwitterConfiguration configuration) {
		this.configuration = configuration;
	}

	private WebResource addSignHeader(WebResource webResource) {

		OAuthParameters params = new OAuthParameters();
		params.signatureMethod("HMAC-SHA1");
		params.consumerKey(getConfiguration().getConsumerKey());
		params.setToken(getConfiguration().getAccessToken());

		OAuthSecrets secrets = new OAuthSecrets();
		secrets.consumerSecret(getConfiguration().getConsumerSecret());
		secrets.setTokenSecret(getConfiguration().getAccessTokenSecret());

		OAuthClientFilter filter = new OAuthClientFilter(client.getProviders(), params, secrets);

		webResource.addFilter(filter);
		return webResource;
	}

}
