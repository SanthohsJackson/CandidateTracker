package com.tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.entity.Candidate;
import com.tracker.repo.CandidateRepo;

/**
 * @author Santhosh
 *
 */
@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tracker.service.CandidateService#getAllCandidates()
	 */
	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates = new ArrayList<>();
		candidateRepo.findAll().forEach(candidate -> candidates.add(candidate));
		return candidates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tracker.service.CandidateService#getCandidateById(java.lang.Long)
	 */
	public Candidate getCandidateById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("Candidate object can not be null");
		}
		Optional<Candidate> candidate = candidateRepo.findById(id);
		return candidate.isPresent() ? candidate.get() : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tracker.service.CandidateService#saveCandidate(com.tracker.entity.
	 * Candidate)
	 */
	public Candidate saveCandidate(Candidate candidate) {
		if (candidate == null) {
			throw new IllegalArgumentException("Candidate object can not be null");
		}
		return candidateRepo.save(candidate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tracker.service.CandidateService#updateCandidate(com.tracker.entity.
	 * Candidate, java.lang.Long)
	 */
	public Candidate updateCandidate(Candidate candidate, Long id) {
		if (id == null) {
			throw new IllegalArgumentException("Candidate Id can not be null");
		}

		if (candidate == null) {
			throw new IllegalArgumentException("Candidate object can not be null");
		}
		if (candidate.getId() != id) {
			throw new IllegalArgumentException("Candidate id mentioned in the path and the object do no match");
		}
		if (!candidateRepo.existsById(id)) {
			throw new IllegalArgumentException("No candidate with id " + id + " was found");
		}
		return candidateRepo.save(candidate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tracker.service.CandidateService#deleteCandidate(java.lang.Long)
	 */
	public Candidate deleteCandidate(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("Candidate Id can not be null");
		}
		Optional<Candidate> candidate = candidateRepo.findById(id);
		if (candidate.isPresent()) {
			candidateRepo.deleteById(id);
		} else {
			throw new IllegalArgumentException("No candidate with id " + id + " was found");
		}
		return candidate.get();
	}

}
