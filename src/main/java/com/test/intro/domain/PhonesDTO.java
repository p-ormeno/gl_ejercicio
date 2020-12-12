package com.test.intro.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PhonesDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhonesDTO {

	private Integer phoneId;

	private LocalDateTime insertDate;

	private String number;

	private String citycode;

	private String contrycode;
	
	private UserDTO user;
}
