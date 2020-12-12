package com.test.intro.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	/** The user id. */
	private String userId;

	/** The insert date. */
	private LocalDateTime insertDate;

	/** The update date. */
	private LocalDateTime updateDate;

	/** The user name. */
	private String name;

	/** The user email. */
	private String email;

	/** The user password. */
	private String password;

	/** The is active. */
	private Boolean isActive;

	/** The last login. */
	private LocalDateTime lastLogin;
	
	/** The phones. */
	private List<PhonesDTO> phones;
}
