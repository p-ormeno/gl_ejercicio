package com.test.intro.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.intro.domain.PhonesDTO;
import com.test.intro.domain.UserDTO;
import com.test.intro.jpa.model.PhonesEntity;
import com.test.intro.jpa.model.UserEntity;

/**
 * The Class Utils.
 */
public class Utils {
	
	
	/**
	 * Gets the phone DTO.
	 *
	 * @param phonesEntity the phones entity
	 * @return the phone DTO
	 */
	public static PhonesDTO getPhoneDTO(PhonesEntity phonesEntity) {
		PhonesDTO dto = null;
		if (phonesEntity != null) {
			dto = new PhonesDTO();

			dto.setPhoneId(phonesEntity.getPhoneId());
			dto.setNumber(phonesEntity.getPhoneNumber().toString());
			dto.setCitycode(phonesEntity.getCityCode().toString());
			dto.setContrycode(phonesEntity.getCountryCode().toString());
			dto.setInsertDate(phonesEntity.getInsertDate());
			dto.setUser( getUserDTO(phonesEntity.getUser()) );
		}
		return dto;
	}
	
	/**
	 * Gets the phone list DTO.
	 *
	 * @param phones the phones
	 * @return the phone list DTO
	 */
	public static List<PhonesDTO> getPhoneListDTO(Iterable<PhonesEntity> phones) {
		List<PhonesDTO> dtos = null;

		if (phones != null && phones.iterator().hasNext()) {
			dtos = new ArrayList<>();

			for (Iterator<PhonesEntity> phone = phones.iterator(); phone.hasNext();) {
				dtos.add(getPhoneDTO(phone.next()));
			}
		}
		return dtos;
	}
	
	/**
	 * Gets the user DTO.
	 *
	 * @param userEntity the user entity
	 * @return the user DTO
	 */
	public static UserDTO getUserDTO(UserEntity userEntity) {
		UserDTO dto = null;
		if (userEntity != null) {
			dto = new UserDTO();

			dto.setUserId(userEntity.getUserId());
			dto.setInsertDate(userEntity.getInsertDate());
			dto.setUpdateDate(userEntity.getUpdateDate());
			dto.setName(userEntity.getUserName());
			dto.setEmail(userEntity.getUserEmail());
			dto.setPassword(userEntity.getUserPassword());
			dto.setIsActive(userEntity.getIsActive());
			dto.setLastLogin(userEntity.getLastLogin());
		}
		return dto;
	}

	
	
	/**
	 * Gets the phone entity.
	 *
	 * @param dto the dto
	 * @return the phone entity
	 */
	public static PhonesEntity getPhoneEntity(PhonesDTO dto) {
		PhonesEntity phonesEntity = null;
		if (dto != null) {
			phonesEntity = new PhonesEntity();

			phonesEntity.setPhoneId(dto.getPhoneId());
			phonesEntity.setPhoneNumber(Integer.parseInt(dto.getNumber()));
			phonesEntity.setCityCode(Integer.parseInt(dto.getCitycode()));
			phonesEntity.setCountryCode(Integer.parseInt(dto.getContrycode()));
			phonesEntity.setInsertDate(dto.getInsertDate());
		}
		return phonesEntity;
	}
	
	/**
	 * Gets the user entity.
	 *
	 * @param dto the dto
	 * @return the user entity
	 */
	public static UserEntity getUserEntity(UserDTO dto) {
		UserEntity userEntity = null;
		if (dto != null) {
			userEntity = new UserEntity();

			userEntity.setUserId(dto.getUserId());
			userEntity.setInsertDate(dto.getInsertDate());
			userEntity.setUpdateDate(dto.getUpdateDate());
			userEntity.setUserName(dto.getName());
			userEntity.setUserEmail(dto.getEmail());
			userEntity.setUserPassword(dto.getPassword());
			userEntity.setIsActive(dto.getIsActive());
			userEntity.setLastLogin(dto.getLastLogin());
		}
		return userEntity;
	}
	
	/**
	 * Gets the list phone entity.
	 *
	 * @param phones the phones
	 * @return the list phone entity
	 */
	public static Set<PhonesEntity> getListPhoneEntity(List<PhonesDTO> phones) {
		final List<PhonesEntity> phonesEntity = new ArrayList<>();

		if (phones != null && !phones.isEmpty()) {
			phones.forEach(phone -> phonesEntity.add(getPhoneEntity(phone)));
		}
		return new HashSet<>(phonesEntity);
	}
	

	/**
	 * Checks if is valid regex.
	 *
	 * @param regex the regex
	 * @param text the text
	 * @return true, if is valid regex
	 */
	public static boolean isValidRegex(String regex, String text) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		return matcher.matches();
	}

}
