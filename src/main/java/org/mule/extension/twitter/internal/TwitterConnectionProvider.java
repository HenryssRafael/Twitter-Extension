package org.mule.extension.twitter.internal;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TwitterConnectionProvider implements PoolingConnectionProvider<TwitterConnection> {

  private final Logger LOGGER = LoggerFactory.getLogger(TwitterConnectionProvider.class);

@Override
public TwitterConnection connect() throws ConnectionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void disconnect(TwitterConnection connection) {
	// TODO Auto-generated method stub
	
}

@Override
public ConnectionValidationResult validate(TwitterConnection connection) {
	// TODO Auto-generated method stub
	return null;
}


}
