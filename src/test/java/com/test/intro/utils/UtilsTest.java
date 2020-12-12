package com.test.intro.utils;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.test.intro.domain.PhonesDTO;
import com.test.intro.domain.UserDTO;
import com.test.intro.jpa.model.PhonesEntity;
import com.test.intro.jpa.model.UserEntity;

/**
 * The Class UtilsTest.
 */
public class UtilsTest {


	@Test
	public void getPhoneDTOTest() {
		PhonesEntity phone = new PhonesEntity(1, LocalDateTime.now(), 12345, 1, 56, new UserEntity());
		PhonesDTO dto = Utils.getPhoneDTO(phone);
		
		assertNotNull(dto);
	}
	
	@Test
	public void getPhonesEntityTest() {
		List<PhonesDTO> phones = new ArrayList<>();
		phones.add(new PhonesDTO(1, LocalDateTime.now(), "12345", "1", "56", new UserDTO()));
		Set<PhonesEntity> phoneSet = Utils.getListPhoneEntity(phones);
		
		assertNotNull(phoneSet);
	}
	
	@Test
	public void getPhonesDTOListTest() {
		List<PhonesEntity> phones = new ArrayList<>();
		phones.add(new PhonesEntity(1, LocalDateTime.now(), 12345, 1, 56, new UserEntity()));
		
		List<PhonesDTO> phoneList = Utils.getPhoneListDTO(phones );
		
		assertNotNull(phoneList);
	}
}
