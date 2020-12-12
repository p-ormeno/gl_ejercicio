package com.test.intro.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.intro.domain.UserDTO;
import com.test.intro.domain.response.UserResponse;
import com.test.intro.jpa.model.PhonesEntity;
import com.test.intro.jpa.model.UserEntity;
import com.test.intro.jpa.repository.UserJpaRepository;
import com.test.intro.service.PhoneService;
import com.test.intro.service.UserService;
import com.test.intro.utils.Constants;
import com.test.intro.utils.Utils;

import lombok.extern.slf4j.Slf4j;



/**
 * The Class UserServiceImpl.
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
    private UserJpaRepository userJpaRepository;

	@Override
	public ResponseEntity<Object> registerUser(UserDTO userDTO) {
		UserResponse userResponse = null;
		HashMap<String, Object> map = new HashMap<>();

		UserEntity newUser = Utils.getUserEntity(userDTO);
		List<PhonesEntity> phones = new ArrayList<>();
		
		if(userDTO.getPhones() != null && !userDTO.getPhones().isEmpty()) {
			userDTO.getPhones().forEach(phone -> phones.add(Utils.getPhoneEntity(phone)));
		}

		if (newUser.getUserEmail() != null && Boolean.TRUE.equals(Utils.isValidRegex(Constants.EMAIL_PATTERN, newUser.getUserEmail()))) {
			if (userJpaRepository.findUserByEmail(newUser.getUserEmail()) == null) {
				if (newUser.getUserPassword() != null && Boolean.TRUE.equals(Utils.isValidRegex(Constants.PASS_PATTERN, newUser.getUserPassword()))) {
					createNewUser(newUser);
					newUser = userJpaRepository.save(newUser);
				} else {
					map.put(Constants.MESSAGE, Constants.MSG_INCORRECT_PASS);
					log.error(Constants.MSG_INCORRECT_PASS);
				}
			} else {
				map.put(Constants.MESSAGE, Constants.MSG_ALREADY_USED_EMAIL);
				log.error(Constants.MSG_ALREADY_USED_EMAIL);
			}

		} else {
			map.put(Constants.MESSAGE, Constants.MSG_INVALID_EMAIL);
			log.error(Constants.MSG_INVALID_EMAIL);
		}

		if (newUser != null && newUser.getUserId() != null && !phones.isEmpty() ) {
			for (PhonesEntity phone : phones) {
				phone.setUser(newUser);
			}
			phoneService.savePhone(phones);

			userResponse = new UserResponse(newUser.getUserId(), newUser.getInsertDate(),
					newUser.getUpdateDate(), newUser.getLastLogin(), newUser.getToken(), newUser.getIsActive());
			log.error("User added!");
		}
		
		if(userResponse == null) {
			return new ResponseEntity<>( map, HttpStatus.NOT_ACCEPTABLE );
		}else {
			return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
		}

	}

	/**
	 * Creates the new user.
	 *
	 * @param newUser the new user
	 */
	private void createNewUser(UserEntity newUser) {
		LocalDateTime insertNow = LocalDateTime.now();
		newUser.setInsertDate(insertNow);
		newUser.setLastLogin(insertNow);
		newUser.setIsActive(Boolean.TRUE);
		newUser.setToken(UUID.randomUUID().toString());
	}

}
