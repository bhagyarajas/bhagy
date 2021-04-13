package com.comcast.lcs.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.comcast.lcs.response.LCSResponse;
import com.comcast.lcs.service.LCSService;
@RunWith(SpringRunner.class)
public class LCSServiceImplTest  
{
	@TestConfiguration
    static class LCSServiceImplTestContextConfiguration {
 
        @Bean
        public LCSService lcsService() {
            return new LCSServiceImpl();
        }
    }
	
	@Autowired
	public LCSService lcsService;
	
	@Test
	public void testFindLongestCommonSubString() {
		LCSResponse lcsResponse =lcsService.findLongestCommonSubString(new String[] {"comcast","comcastic","broadcaster"});
		assertEquals("cast", lcsResponse.getLcs().get(0).getValue());
		
	}
	
}
