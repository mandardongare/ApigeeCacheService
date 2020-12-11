package com.prokarma.apigee.caches.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.exception.GeneralFailureException;

public class ObjectMapperUtil {

  private static final Logger LOG = LoggerFactory.getLogger(ObjectMapperUtil.class);

  private ObjectMapperUtil() {
    throw new AssertionError("No Object Creation");
  }

  public static String returnJsonFromObject(Object object) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      LOG.error("Failed to process the json: {} with exception {}", object, ex);
      throw new GeneralFailureException(ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }
  }
}
