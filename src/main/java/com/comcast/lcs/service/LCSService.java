package com.comcast.lcs.service;

import org.springframework.stereotype.Component;

import com.comcast.lcs.response.LCSResponse;
@Component
public interface LCSService {
	
	LCSResponse findLongestCommonSubString(String[] strArray);
		
}
