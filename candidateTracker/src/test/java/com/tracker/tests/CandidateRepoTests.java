package com.tracker.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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

	@Autowired
	private CandidateRepo candidateRepo;

	@Test
	public void checkGetAllCandidateTest() {

		List<Candidate> candidates = new ArrayList<>();
		Iterable<Candidate> candidateData = candidateRepo.findAll();
		assertNotNull(candidateData);
		candidateData.forEach(candidate -> candidates.add(candidate));
		assertEquals(4, candidates.size());

	}
}
