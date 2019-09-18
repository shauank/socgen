package com.sg.exception;

import org.springframework.http.HttpStatus;

/**
 * @author shpatel
 *
 */
public class BaseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7418342813594566727L;
	protected HttpStatus status;
	protected String errorMessage;

	public BaseException() {
		super();
	}
}
