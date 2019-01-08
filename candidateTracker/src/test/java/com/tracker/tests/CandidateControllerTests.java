package com.tracker.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.entity.Candidate;


/**
 * @author Santhosh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class CandidateControllerTests {

	
	private static final String DELETED_CANDIDATE_NAME = "Ravi";

	private static final String QUALIFICATION = "Qualification";

	private static final String PROFILE_LINK = "profileLink";

	private static final String NAME = "Name";

	private static final String INTERESTS = "Interests";

	
	@Autowired
	private MockMvc mvc;	

	@Test
    public void getAllCandidateTest()
      throws Exception {      
        mvc.perform(get("/candidate/")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(4)));
    }
	
	
	@Test
    public void getCandidateByIdTest()
      throws Exception {      
        mvc.perform(get("/candidate/100")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.id", is(100)));
    }
	
	
	@Test
    public void saveCandidateByIdTest()
      throws Exception {      
		
		ObjectMapper mapper = new ObjectMapper();         	
        mvc.perform(post("/candidate/")
          .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(getCandidate())))
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.name", is(NAME)));
    }
	
	
	@Test
    public void deleteCandidateTest()
      throws Exception { 		        	
        mvc.perform(delete(("/candidate/200")))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.name", is(DELETED_CANDIDATE_NAME)));
    }
	
	
	@Test
    public void updateCandidateByIdTest()
      throws Exception {      
		
		ObjectMapper mapper = new ObjectMapper(); 
		Candidate candidate= getCandidate();
		candidate.setId(100l);
        mvc.perform(put("/candidate/100")
          .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(candidate)))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.name", is(NAME)));
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
