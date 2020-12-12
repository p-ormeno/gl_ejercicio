package com.test.intro.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.test.intro.jpa.model.PhonesEntity;
import com.test.intro.jpa.model.UserEntity;
import com.test.intro.jpa.repository.PhonesJpaRepository;

/**
 * The Class PhoneServiceImplTest.
 */
public class PhoneServiceImplTest {

	@InjectMocks
	private PhoneServiceImpl serviceImpl = new PhoneServiceImpl();
	
	@Mock
	private PhonesJpaRepository phonesJpaRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addPhoneOk() {
		PhonesEntity phone = new PhonesEntity(1, LocalDateTime.now(), 12345, 1, 56, new UserEntity());
		List<PhonesEntity> phoneList = new ArrayList<>();
		phoneList.add(phone);

		List<PhonesEntity> result = serviceImpl.savePhone(phoneList);
		assertNotNull(result);
	}
	
	
}
