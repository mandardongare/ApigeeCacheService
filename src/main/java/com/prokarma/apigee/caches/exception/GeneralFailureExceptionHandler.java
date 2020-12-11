package com.prokarma.apigee.caches.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstant;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.domain.ErrorResponse;

@Provider
public class GeneralFailureExceptionHandler implements ExceptionMapper<GeneralFailureException> {

  @Override
  public Response toResponse(GeneralFailureException exception) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setErrorType(GeneralFailureException.class.getName());
    errorResponse.setStatus(ApigeeCacheConstant.FAIL.getValue());
    errorResponse.setMessage(ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    return Response.status(Integer.valueOf(exception.getMessageCode())).entity(errorResponse)
        .type("application/json").build();
  }

}
