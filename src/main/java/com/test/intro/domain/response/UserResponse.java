package com.test.intro.domain.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserResponse.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	/** The id. */
	private String id;
	
	/** The created. */
	private LocalDateTime created;
	
	/** The modified. */
	private LocalDateTime modified;
	
	/** The last login. */
	private LocalDateTime last_login;
	
	/** The token. */
	private String token;
	
	/** The isactive. */
	private Boolean isactive;

}
