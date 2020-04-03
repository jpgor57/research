/**
 * 
 */
package com.gor.rocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author irish
 *
 */
@Configuration
public class RocketRouter 
{
	@Bean
	public RouterFunction<ServerResponse> route(RocketHandler handler)
	{
		return RouterFunctions.route(RequestPredicates.GET("/get/{id}")
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
				handler::get).andRoute(RequestPredicates.POST("/post")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						handler::post).andRoute(RequestPredicates.GET("/test")
								.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
								handler::test);
	}
}
