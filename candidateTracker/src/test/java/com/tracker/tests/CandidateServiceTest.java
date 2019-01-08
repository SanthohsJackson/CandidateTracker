package com.tracker.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.entity.Candidate;
import com.tracker.service.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateServiceTest {

	private static final long NON_EXISITING_ID = 123123l;

	private static final Long CANDIDATE_ID = 100l;

	private static final String QUALIFICATION = "Qualification";

	private static final String PROFILE_LINK = "profileLink";

	private static final String NAME = "Name";

	private static final String INTERESTS = "Interests";
	@Autowired
	private CandidateService candidateService;

	@Test
	public void findAllTest() {
		List<Candidate> candidates = candidateService.getAllCandidates();
		assertNotNull(candidates);
		assertEquals(4, candidates.size());
	}

	@Test
	public void findByIDTest() {
		Candidate candidate = candidateService.getCandidateById(CANDIDATE_ID);
		Assert.assertNotNull(candidate);
		Assert.assertEquals(CANDIDATE_ID, candidate.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void findByIDWhenNullTest() {
		candidateService.getCandidateById(null);
	}

	@Test
	public void saveCandidateTest() {
		candidateService.saveCandidate(getCandidate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveCandidateWhenNullTest() {
		candidateService.saveCandidate(null);
	}

	@Test
	public void updateCandidateTest() {
		Candidate candidate = candidateService.getCandidateById(CANDIDATE_ID);
		candidate.setName(NAME);
		Candidate updatedCandidate = candidateService.updateCandidate(candidate, CANDIDATE_ID);
		Assert.assertEquals(NAME, updatedCandidate.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateCandidateWhenCandidateNullTest() {
		candidateService.updateCandidate(null, CANDIDATE_ID);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateCandidateWhenIdNullTest() {
		Candidate candidate = candidateService.getCandidateById(CANDIDATE_ID);
		candidate.setName(NAME);
		candidateService.updateCandidate(candidate, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateCandidateWithNoMatchingIdTest() {
		Candidate candidate = candidateService.getCandidateById(CANDIDATE_ID);
		candidate.setName(NAME);
		candidateService.updateCandidate(candidate, NON_EXISITING_ID);
	}

	@Test
	public void deleteCandidateTest() {
		Candidate candidate = candidateService.saveCandidate(getCandidate());
		Candidate deletedCandidate = candidateService.deleteCandidate(candidate.getId());
		Assert.assertEquals(candidate.getId(), deletedCandidate.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteCandidateWhenIdNullTest() {
		candidateService.deleteCandidate(null);
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
