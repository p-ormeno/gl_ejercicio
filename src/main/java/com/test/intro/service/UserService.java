package com.test.intro.service;

import org.springframework.http.ResponseEntity;

import com.test.intro.domain.UserDTO;

/**
 * The Interface UserService.
 */
public interface UserService {

	ResponseEntity<Object> registerUser(UserDTO userDTO);
}
