package com.tracker.service;

import java.util.List;

import com.tracker.entity.Candidate;

/**
 * @author Santhosh
 *
 */
public interface CandidateService {

	/**
	 * Finds all the candidates.
	 * 
	 * @return List<Candidate>
	 */
	public List<Candidate> getAllCandidates();

	/**
	 * Finds a candidate based on the given ID
	 * 
	 * @param id
	 * @return Candidate
	 */
	public Candidate getCandidateById(Long id);

	/**
	 * Saves the candidate information.
	 * 
	 * @param Candidate
	 * @return Candidate
	 */
	public Candidate saveCandidate(Candidate candidate);

	/**
	 * Updated the candidate information.
	 * 
	 * @param Candidate
	 * @param id
	 * @return Candidate
	 */
	public Candidate updateCandidate(Candidate candidate, Long id);

	/**
	 * Deletes a candidate based on the mentioned id.
	 * 
	 * @param id
	 * @return Candidate
	 */
	public Candidate deleteCandidate(Long id);
}
