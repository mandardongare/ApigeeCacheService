package com.prokarma.apigee.caches.exception;

public class ApigeeCacheOperationFailedException extends RuntimeException {

	  private static final long serialVersionUID = 1L;
	  private final String messageCode;
	  private final String message;

	  public String getMessageCode() {
	    return messageCode;
	  }

	  @Override
	  public String getMessage() {
	    return message;
	  }

	public ApigeeCacheOperationFailedException(String messageCode, String message) {
		super();
		this.messageCode = messageCode;
		this.message = message;
	}
	  
}
