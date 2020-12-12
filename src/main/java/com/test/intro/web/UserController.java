package com.test.intro.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.intro.domain.UserDTO;
import com.test.intro.service.UserService;
import com.test.intro.utils.Urls;

/**
 * The Class UserController.
 */
@CrossOrigin
@RestController
@RequestMapping(value = Urls.USERS)
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;
	
	@PostMapping(path = Urls.REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> signUp(@RequestBody UserDTO user) {
		return userService.registerUser(user);
	}
}
