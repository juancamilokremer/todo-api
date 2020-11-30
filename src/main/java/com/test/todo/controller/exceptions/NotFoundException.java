package com.test.todo.controller.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {
	private static final String DESCRIPTION = "Bad Request Exception (400)";

	public NotFoundException(String message) {
		super(DESCRIPTION + " . " + message);
	}
}
