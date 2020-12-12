package com.test.intro.jpa.model;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class PhonesEntityTest.
 */
public class PhonesEntityTest {

	@Test
	public void constructorEmptyTest() {
		PhonesEntity phone = new PhonesEntity();

		Assert.assertNotNull(phone);
	}
	
	@Test
	public void constructorArgTest() {
		PhonesEntity phone = new PhonesEntity(1, LocalDateTime.now(), 12345, 1, 56, new UserEntity());

		Assert.assertNotNull(phone);
	}
}
