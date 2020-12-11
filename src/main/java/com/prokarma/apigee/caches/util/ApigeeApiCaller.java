package com.prokarma.apigee.caches.util;

import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.exception.ApigeeCacheOperationFailedException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class ApigeeApiCaller {

  public Response invokeApigeeApi(Request request) {
    try {
      OkHttpClient client = new OkHttpClient();
      return client.newCall(request).execute();
    } catch (Exception e) {
      throw new ApigeeCacheOperationFailedException(
          ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }
  }

}
