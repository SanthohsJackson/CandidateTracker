package com.tracker.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.entity.Candidate;

/**
 * Data Repository for {@link Candidate}
 * 
 * @author Santhosh
 *
 */
public interface CandidateRepo extends CrudRepository<Candidate,Long> {

}
