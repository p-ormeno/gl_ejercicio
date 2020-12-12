package com.test.intro.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.intro.domain.PhonesDTO;
import com.test.intro.domain.UserDTO;
import com.test.intro.jpa.model.UserEntity;
import com.test.intro.jpa.repository.UserJpaRepository;
import com.test.intro.service.PhoneService;
import com.test.intro.utils.Utils;

public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl serviceImpl = new UserServiceImpl();
	
	@Mock
	private UserJpaRepository userJpaRepository;
	
	@Mock
	private PhoneService phoneService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void newUserTest() {
		
		UserDTO dto = this.defaultUser();
		UserEntity entity = Utils.getUserEntity(dto);
		entity.setUserId(UUID.randomUUID().toString());
		
		Mockito.when(userJpaRepository.save(Mockito.any(UserEntity.class))).thenReturn(entity);
		
		ResponseEntity<Object> response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void mailTest() {
		UserDTO dto = this.defaultUser();

		// test for already used mail
		Mockito.when(userJpaRepository.findUserByEmail(Mockito.anyString())).thenReturn(new UserEntity());
		ResponseEntity<Object> response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		// Test for null email
		dto.setEmail(null);
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		// Test for incorrect pattern
		dto.setEmail("john@hello");
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

	}
	
	@Test
	public void passWordTest() {
		UserDTO dto = this.defaultUser();

		// test for correct pattern
		ResponseEntity<Object> response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		// Test for null password
		dto.setPassword(null);
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		// Test for incorrect pattern
		dto.setPassword("hello");
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

	}
	
	@Test
	public void phonesTest() {
		UserDTO dto = this.defaultUser();

		// test for phones
		ResponseEntity<Object> response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		// Test for null phones
		dto.setPhones(null);
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		//Test for empty phones
		dto.setPhones(new ArrayList<>());
		response = serviceImpl.registerUser(dto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
	}

	private UserDTO defaultUser() {
		List<PhonesDTO> phonesDTO = new ArrayList<>();
		phonesDTO.add(new PhonesDTO(null, null, "1234567", "45", "56", null));
		
		return new UserDTO(null, null, null, "John Doe", "john.doe@gmail.com", "Hunter22", null, null, phonesDTO);
	}
}
