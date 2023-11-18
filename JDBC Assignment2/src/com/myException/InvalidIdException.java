package com.myException;

public class InvalidIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7271406653295030233L;

	public InvalidIdException(String message) {
		super(message);
	}
}