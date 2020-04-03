/**
 * 
 */
package com.gor.rocket.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author irish
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Rocket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8730739126300967393L;
	/**
	 * 
	 */
	@Id
	private String id;
	/**
	 * 
	 */
	@Getter
	@Setter
	private String name;
	/**
	 * 
	 */
	@Getter
	@Setter
	private String destination;
	/**
	 * 
	 */
	@Getter
	@Setter
	private String launchLocation;
	/**
	 * 
	 */
	@Getter
	@Setter
	private LocalDateTime launchTime;

}
