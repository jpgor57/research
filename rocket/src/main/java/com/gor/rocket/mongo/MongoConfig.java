/**
 * 
 */
package com.gor.rocket.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

/**
 * @author irish
 *
 */
@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration 
{
	/**
	 * 
	 */
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MongoConfig.class.getName());
	
	/**
	 * 
	 */
	@Value("${spring.data.mongodb.database}")
	private String db;
	
	/**
	 * 
	 */
	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	/**
	 * 
	 */
	@Value("${spring.data.mongodb.username}")
	private String user;
	
	/**
	 * 
	 */
	@Value("${spring.data.mongodb.password}")
	private String pass;
	
	/**
	 * 
	 */
	@Override
	@Bean
	public MongoClient reactiveMongoClient()
	{
		uri = uri.replaceFirst("<username>", user);
		uri = uri.replaceFirst("<password>", pass);
		log.info("Mongo URI: " + uri);
		return MongoClients.create(uri);
	}
	
	/**
	 * 
	 * @return
	 */
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() 
    {
        return new ReactiveMongoTemplate(reactiveMongoClient(), db);
    }
    
	/**
	 * 
	 */
	@Override
	protected String getDatabaseName() 
	{
		return db;
	}

}
