package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.Candidate;
import com.tracker.service.CandidateService;

/**
 * 
 * Default controller for {@link Candidate} API's
 * 
 * @author Santhosh
 *
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	/**
	 * 
	 * API that returns list of all the candidates present.
	 * 
	 * @return List<{@link Candidate}>
	 */
	@GetMapping("/")
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	/**
	 * 
	 * API that return the candidate information based on the id provided.
	 * 
	 * @param id
	 * @return {@link Candidate}
	 */
	@GetMapping("/{id}")
	public Candidate getCandidateById(@PathVariable Long id) {
		return candidateService.getCandidateById(id);
	}

	/**
	 * 
	 * API that saves the candidate information.
	 * 
	 * @param candidate
	 * @return {@link Candidate}
	 */
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidate saveCandidate(@RequestBody Candidate candidate) {
		return candidateService.saveCandidate(candidate);
	}

	/**
	 * 
	 * API that update the candidate information based on the id provided.
	 * 
	 * @param candidate
	 * @param id
	 * @return {@link Candidate}
	 */
	@PutMapping("/{id}")
	public Candidate updateCandidate(@RequestBody Candidate candidate, @PathVariable Long id) {
		return candidateService.updateCandidate(candidate, id);
	}

	/**
	 * 
	 * API that deletes the candidate information.
	 * 
	 * @param id
	 * @return {@link Candidate}
	 */
	@DeleteMapping("/{id}")
	public Candidate deleteCandidate(@PathVariable Long id) {
		return candidateService.deleteCandidate(id);
	}

}
