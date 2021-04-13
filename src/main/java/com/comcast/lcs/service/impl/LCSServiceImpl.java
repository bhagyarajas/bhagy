package com.comcast.lcs.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.comcast.lcs.constants.LCSConstants;
import com.comcast.lcs.domain.LCS;
import com.comcast.lcs.response.LCSResponse;
import com.comcast.lcs.service.LCSService;

@Component
public class LCSServiceImpl implements LCSService {

	@Override
	public LCSResponse findLongestCommonSubString(String[] strArray) {

		String minsubStr = Arrays.stream(strArray).min(Comparator.comparingInt(String::length)).get();
		String maxSubString = LCSConstants.EMPTY_STRING;
		Set<String> subStrSet = getSubStringSet(minsubStr);
		for (String subStr : subStrSet) {
			if (containsAllSubString(subStr, strArray)) {
				if (subStr.length() > maxSubString.length())
					maxSubString = subStr;
			}
		}
		LCSResponse lCSResponse = new LCSResponse();
		List<LCS> lcsList = new ArrayList<>();
		LCS lcs = new LCS();
		lcs.setValue(maxSubString);
		lcsList.add(lcs);
		lCSResponse.setLcs(lcsList);
		return lCSResponse;

	}

	/**
	 * This method check the current substring is present in all the string values in the array
	 * @param value
	 * @param strSet
	 * @return
	 */
	private static boolean containsAllSubString(String value, String[] strSet) {

		for (String str2 : strSet) {
			if (!str2.contains(value)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method creates a set of all the possible substring from a string
	 * @param minsubStr
	 * @return
	 */
	private static Set<String> getSubStringSet(String minsubStr) {
		Set<String> subStrSet = new HashSet<String>();
		for (int i = 0; i < minsubStr.length(); i++) {
			for (int j = i + 1; j <= minsubStr.length(); j++) {
				subStrSet.add(minsubStr.substring(i, j));
			}
		}
		return subStrSet;
	}
}
