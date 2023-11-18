package com.myException;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 7677611344323115488L;
	public InvalidInputException(String message) {
		super(message);
	}
}
