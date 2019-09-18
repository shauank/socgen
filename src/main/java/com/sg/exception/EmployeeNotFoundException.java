package com.sg.exception;

import org.springframework.http.HttpStatus;

/**
 * @author shpatel
 *
 */
public class EmployeeNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627284095073341289L;
	private static final String EXCEPTION_TYPE = "Employee Exception";

	public EmployeeNotFoundException(String errorMessage) {
		this.errorMessage = String.format("Exception Type: %s, Exception Message %s", EXCEPTION_TYPE, errorMessage);
		this.status = HttpStatus.NOT_FOUND;
	}
}
