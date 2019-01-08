package com.tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.entity.Candidate;
import com.tracker.repo.CandidateRepo;

/**
 * 
 * Default service implementation for {@link CandidateService}
 * @author Santhosh
 *
 */
@Service
public class CandidateServiceImpl implements CandidateService {

	Logger LOGGER = LoggerFactory.getLogger(CandidateServiceImpl.class);

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
		LOGGER.debug("Fetched {} candidates information", candidates.size());
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
		LOGGER.debug("Saving candidate information with name {}", candidate.getName());
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
		LOGGER.debug("Updating candidate information with id {}", id);
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
		LOGGER.debug("Deleting candidate information with id {}", id);
		return candidate.get();
	}

}
