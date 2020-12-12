package com.test.intro.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.intro.jpa.model.PhonesEntity;
import com.test.intro.jpa.repository.PhonesJpaRepository;
import com.test.intro.service.PhoneService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
    private PhonesJpaRepository phonesJpaRepository;
	
	/**
	 * Save phone.
	 *
	 * @param phone the phone
	 * @return the phones entity
	 */
	public List<PhonesEntity> savePhone(List<PhonesEntity> phones) {
		phones.forEach(phone -> {
			phone.setInsertDate(LocalDateTime.now());
			phonesJpaRepository.save(phone);
			log.error("Phone number " + phone.getPhoneNumber() + " added to user " + phone.getUser().getUserName());
		});
		return phones;
	}

}
