/**
 * 
 */
package com.gor.rocket.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.gor.rocket.model.Rocket;

/**
 * @author irish
 *
 */
public interface RocketRepository extends ReactiveMongoRepository<Rocket, String> 
{

}
