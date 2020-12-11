package com.prokarma.apigee.caches.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstant;
import com.prokarma.apigee.caches.domain.ErrorResponse;

@Provider
public class CacheOperationFailureExceptionHandler
    implements ExceptionMapper<ApigeeCacheOperationFailedException> {

  private Logger logger = LoggerFactory.getLogger(CacheOperationFailureExceptionHandler.class);

  @Override
  public Response toResponse(ApigeeCacheOperationFailedException exception) {

    logger.error("{} - {}", exception.getMessageCode(), exception.getMessage());
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setStatus(ApigeeCacheConstant.FAIL.getValue());
    errorResponse.setErrorType(ApigeeCacheOperationFailedException.class.getName());
    errorResponse.setMessage(exception.getMessage());
    return Response.status(Integer.valueOf(exception.getMessageCode())).entity(errorResponse)
        .type("application/json").build();

  }

}
