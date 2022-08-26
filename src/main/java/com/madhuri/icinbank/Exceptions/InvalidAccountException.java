package com.madhuri.icinbank.Exceptions;

public class InvalidAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidAccountException(String message) {
        super(message);
    }
}
