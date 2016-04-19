package com.br.exception;

public class LoginExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginExistenteException(String message) {
		super(message);
	}
}
