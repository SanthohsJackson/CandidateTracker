package com.tracker.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.entity.Candidate;
import com.tracker.repo.CandidateRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CandidateRepoTests {

	private static final String QUALIFICATION = "Qualification";

	private static final String PROFILE_LINK = "profileLink";

	private static final String NAME = "Name";

	private static final String INTERESTS = "Interests";

	private static final long CANDIDATE_ID = 100l;

	@Autowired
	private CandidateRepo candidateRepo;

	@Test
	public void findAllTest() {

		List<Candidate> candidates = new ArrayList<>();
		Iterable<Candidate> candidateData = candidateRepo.findAll();
		assertNotNull(candidateData);
		candidateData.forEach(candidate -> candidates.add(candidate));
		assertEquals(4, candidates.size());

	}

	@Test
	public void findByIdTest() {
		Optional<Candidate> candidate = candidateRepo.findById(CANDIDATE_ID);
		assertTrue(candidate.isPresent());
	}

	@Test
	public void saveTest() {
		Candidate candidate = getCandidate();

		Candidate savedInfo = candidateRepo.save(candidate);
		assertNotNull(savedInfo.getId());
		assertEquals(NAME, candidate.getName());
	}

	@Test
	public void updateTest() {
		Candidate candidate = candidateRepo.findById(CANDIDATE_ID).get();
		candidate.setName(NAME);
		Candidate updatedCandidate = candidateRepo.save(candidate);
		assertEquals(NAME, updatedCandidate.getName());
	}

	@Test
	public void deleteTest() {
		candidateRepo.deleteById(CANDIDATE_ID);
	}

	private Candidate getCandidate() {
		Candidate candidate = new Candidate();
		candidate.setInterests(INTERESTS);
		candidate.setName(NAME);
		candidate.setProfileLink(PROFILE_LINK);
		candidate.setQualification(QUALIFICATION);
		return candidate;
	}

}
