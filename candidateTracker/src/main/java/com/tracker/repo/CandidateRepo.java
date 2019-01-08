package com.tracker.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.entity.Candidate;

public interface CandidateRepo extends CrudRepository<Candidate,Long> {

}
