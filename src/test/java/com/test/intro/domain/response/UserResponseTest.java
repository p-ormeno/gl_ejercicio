package com.test.intro.domain.response;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class UserResponseTest.
 */
public class UserResponseTest {
	
	@Test
	public void constructorEmptyTest() {
		UserResponse response = new UserResponse();

		Assert.assertNotNull(response);
	}
	
	@Test
	public void constructorArgTest() {
		UserResponse response = new UserResponse("1", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "toke", true);

		Assert.assertNotNull(response);
	}

}
