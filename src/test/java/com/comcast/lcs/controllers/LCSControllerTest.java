package com.comcast.lcs.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.comcast.lcs.domain.LCS;
import com.comcast.lcs.request.LCSRequest;
import com.comcast.lcs.service.LCSService;
import com.comcast.lcs.service.impl.LCSServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(LCSController.class)
public class LCSControllerTest {
	@Autowired
	private MockMvc mockMvc;

	private LCSRequest lcsRequest;

	@Before
	public void setUp() {
		lcsRequest = new LCSRequest();
		List<LCS> lcsList = new ArrayList<>();
		LCS lcs1 = new LCS();
		LCS lcs2 = new LCS();
		LCS lcs3 = new LCS();
		lcs1.setValue("comcast");
		lcs2.setValue("comcastic");
		lcs3.setValue("broadcaster");
		lcsList.add(lcs1);
		lcsList.add(lcs2);
		lcsList.add(lcs3);
		lcsRequest.setSetOfStrings(lcsList);
	}

	@Test
	public void testFindLongestCommonSubString() throws Exception {
		String uri = "/lcs";
		String inputJson = mapToJson(lcsRequest);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testFindLongestCommonSubStringForBadRequest() throws Exception {
		String uri = "/lcs";
		lcsRequest.setSetOfStrings(new ArrayList<>());
		String inputJson = mapToJson(lcsRequest);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(400, mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testFindLongestCommonSubStringForInvalidRequest() throws Exception {
		String uri = "/lcs";
		lcsRequest.setSetOfStrings(null);
		String inputJson = mapToJson(lcsRequest);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(500, mvcResult.getResponse().getStatus());
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@TestConfiguration
	static class AdditionalConfig {
		@Bean
		public LCSService lCSService() {
			return new LCSServiceImpl();
		}
	}

	@Before
	public void tearDown() {

	}

}
