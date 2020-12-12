package com.test.intro.utils;

/**
 * The Class Constants.
 */
public class Constants {
	
	/**
     * Instantiates a new constants.
     */
    private Constants() {
    	super();
    }

	/** The Constant EMAIL_PATTERN. */
	public static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	/** The Constant PASS_PATTERN. */
	public static final String PASS_PATTERN = "^[A-Z]{1,}+[a-z]+[0-9]{2,}$";
	
	/** The Constant MESSAGE. */
	public static final String MESSAGE = "message";
	
	/** The Constant MSG_INCORRECT_PASS. */
	public static final String MSG_INCORRECT_PASS = "Invalid password format! Must contain 1 uppercase letter, 2 numbers and lowercase letters";
	
	/** The Constant MSG_INVALID_EMAIL. */
	public static final String MSG_INVALID_EMAIL = "El correo es invalido!";
	
	/** The Constant MSG_ALREADY_USED_EMAIL. */
	public static final String MSG_ALREADY_USED_EMAIL = "El correo ya está registrado";
}
