package com.prokarma.apigee.caches.constants;

import com.squareup.okhttp.MediaType;

public class ApigeeCacheConstants {
  private ApigeeCacheConstants() {}

  public static final String BASE_URL = "https://api.enterprise.apigee.com/v1/organizations/";
  public static final String ENVIRONMENT = "/environments/";
  public static final String CASHES = "/caches";
  public static final MediaType MEDIA_TYPE_JSON =
      MediaType.parse("application/json; charset=utf-8");
  public static final String AUTHORIZATION = "Authorization";
  public static final String POST_SUCCESS = "Cache created successfully";
  public static final String PUT_SUCCESS = "Cache updated successfully";
  public static final String DELETE_SUCCESS = "Cache deleted successfully";

  public static final String POST_FAIL = "Failed to create Cache due to error - ";
  public static final String PUT_FAIL = "Failed to update Cache due to error - ";
  public static final String DELETE_FAIL = "Failed to delete Cache due to error - ";
  public static final String GET_FAIL = "Failed to retrieve Cache due to error - ";
  public static final String EMPTY = "No records found";
  public static final String GENERAL_FAILURE_STATUS_CODE = "500";
  public static final String GENERAL_FAILURE_MESSAGE = "Failed to process the request";
  public static final String APIGEE_FAILURE_MESSAGE = "Failed to fetch response from Apigee";

  public static final int SUCCESS_STATUS_CODE = 200;
  public static final int POST_SUCCESS_STATUS_CODE = 201;
}
