package com.demo.exception;

public class UserAlreadyExistEception extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistEception(String message) {
		super(message);
	}
}
