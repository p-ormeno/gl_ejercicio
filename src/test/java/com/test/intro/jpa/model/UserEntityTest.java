package com.test.intro.jpa.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class UserEntityTest.
 */
public class UserEntityTest {

	@Test
	public void constructorEmptyTest() {
		UserEntity user = new UserEntity();

		Assert.assertNotNull(user);
	}
	
	@Test
	public void constructorArgTest() {
		Set<PhonesEntity> phones = new HashSet<>();

		UserEntity user = new UserEntity("id", LocalDateTime.now(), LocalDateTime.now(), "name", "text", "text", true,
				LocalDateTime.now(), "token", phones);

		Assert.assertNotNull(user);
	}
}
