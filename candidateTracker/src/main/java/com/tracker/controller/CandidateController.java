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
 * @author Santhosh
 *
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	/**
	 * @return
	 */
	@GetMapping("/")
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Candidate getCandidateById(@PathVariable Long id) {
		return candidateService.getCandidateById(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidate saveCandidate(@RequestBody Candidate candidate) {
		return candidateService.saveCandidate(candidate);
	}

	/**
	 * @param candidate
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public Candidate updateCandidate(@RequestBody Candidate candidate, @PathVariable Long id) {
		return candidateService.updateCandidate(candidate, id);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Candidate deleteCandidate(@PathVariable Long id) {
		return candidateService.deleteCandidate(id);
	}

}
