/**
 * 
 */
package com.gor.rocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gor.rocket.model.Rocket;
import com.gor.rocket.repo.RocketRepository;

import reactor.core.publisher.Mono;

/**
 * @author irish
 *
 */
@Component
public class RocketHandler
{
	@Autowired
	private RocketRepository repo;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> get(ServerRequest request)
	{
		String id = request.pathVariable("id");
		return ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromPublisher(repo.findById(id), Rocket.class));
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> post(ServerRequest request)
	{
		Mono<Rocket> rocket = request.bodyToMono(Rocket.class);
		return ServerResponse.status(HttpStatus.CREATED).body(BodyInserters.fromPublisher(rocket.flatMap(repo::save), Rocket.class));
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> test(ServerRequest request)
	{
		Rocket r = new Rocket("AA1","Solarus 13", "Jupiter - Titan", "Florida, USA", LocalDateTime.now());
		return ServerResponse.status(HttpStatus.OK).bodyValue(r);
	}

}
