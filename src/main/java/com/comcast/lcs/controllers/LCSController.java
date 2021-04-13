package com.comcast.lcs.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.lcs.request.LCSRequest;
import com.comcast.lcs.response.LCSResponse;
import com.comcast.lcs.service.LCSService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class LCSController {

	private Logger LOGGER = Logger.getLogger(LCSController.class);

	@Autowired
	private LCSService lcsService;

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */
	@PostMapping(path = "/lcs", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> findLongestCommonSubString(@RequestBody(required = true) LCSRequest lcsRequest) {
		LOGGER.info("Entering method findLongestCommonSubString");
		if (lcsRequest.getSetOfStrings().size() == 0) {
			return ResponseEntity.badRequest().body("\"setOfStrings\" must not be empty");
		}

		List<String> lcsList = lcsRequest.getSetOfStrings().stream().map(lcs -> lcs.getValue())
				.collect(Collectors.toList());
		Set<String> lcsSet = new HashSet<>(lcsList);

		if (lcsSet.size() < lcsList.size()) {
			return ResponseEntity.badRequest().body("\"setOfStrings\" must be a Set");
		}
		LCSResponse lcsResponse = lcsService.findLongestCommonSubString(lcsList.stream().toArray(String[]::new));
		LOGGER.debug("Longest Common Substring is  " + lcsResponse.getLcs().get(0).getValue());
		LOGGER.info("Exiting method findLongestCommonSubString");
		return ResponseEntity.ok(lcsResponse);
	}

}
