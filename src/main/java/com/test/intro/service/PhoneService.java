package com.test.intro.service;

import java.util.List;

import com.test.intro.jpa.model.PhonesEntity;

/**
 * The Interface PhoneService.
 */
public interface PhoneService {

	/**
	 * Save phone.
	 *
	 * @param phone the phone
	 * @param userId the user id
	 * @return the phones entity
	 */
	List<PhonesEntity> savePhone(List<PhonesEntity> phones);
}
