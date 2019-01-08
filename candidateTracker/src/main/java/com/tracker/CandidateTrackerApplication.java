package com.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Santhosh
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.tracker.repo") 
@EntityScan("com.tracker.entity")
@EnableAutoConfiguration
public class CandidateTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateTrackerApplication.class, args);
	}

}
