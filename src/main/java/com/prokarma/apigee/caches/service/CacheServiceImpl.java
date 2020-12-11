package com.prokarma.apigee.caches.service;

import java.io.IOException;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.exception.ApigeeCacheOperationFailedException;
import com.prokarma.apigee.caches.exception.GeneralFailureException;
import com.prokarma.apigee.caches.util.ApigeeApiCaller;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class CacheServiceImpl implements CacheService {

  Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

  @Inject
  private ApigeeApiCaller apigeeApiCaller;

  @Override
  public String getCacheNames(String authorization, String orgName, String environment) {
    try {
      String url = ApigeeCacheConstants.BASE_URL + orgName + ApigeeCacheConstants.ENVIRONMENT
          + environment + ApigeeCacheConstants.CASHES;

      Request request = new Request.Builder().url(url)
          .addHeader(ApigeeCacheConstants.AUTHORIZATION, authorization).get().build();

      Response response = apigeeApiCaller.invokeApigeeApi(request);

      if ((response.code() != ApigeeCacheConstants.SUCCESS_STATUS_CODE)) {
        throw new ApigeeCacheOperationFailedException(String.valueOf(response.code()),
            ApigeeCacheConstants.GET_FAIL + response.message());
      }

      return response.body().string();
    } catch (IOException e) {
      logger.error("Failed to list caches: {0}", e);
      throw new GeneralFailureException(ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }

  }

  @Override
  public String createCache(String json, String authorization, String orgName, String environment) {
    try {
      RequestBody body = RequestBody.create(ApigeeCacheConstants.MEDIA_TYPE_JSON, json);
      String url = ApigeeCacheConstants.BASE_URL + orgName + ApigeeCacheConstants.ENVIRONMENT
          + environment + ApigeeCacheConstants.CASHES;

      Request request = new Request.Builder().url(url)
          .addHeader(ApigeeCacheConstants.AUTHORIZATION, authorization).post(body).build();

      Response response = apigeeApiCaller.invokeApigeeApi(request);

      if ((response.code() != ApigeeCacheConstants.POST_SUCCESS_STATUS_CODE)) {
        throw new ApigeeCacheOperationFailedException(String.valueOf(response.code()),
            ApigeeCacheConstants.POST_FAIL + response.message());
      }
      logger.info("Cache created: {}", response.body().string());

      return ApigeeCacheConstants.POST_SUCCESS;
    } catch (IOException e) {
      logger.error("Failed to create cache: {0}", e);
      throw new GeneralFailureException(ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }
  }

  @Override
  public String updateCache(String json, String authorization, String orgName, String environment,
      String cacheId) {
    try {
      RequestBody body = RequestBody.create(ApigeeCacheConstants.MEDIA_TYPE_JSON, json);
      String url = ApigeeCacheConstants.BASE_URL + orgName + ApigeeCacheConstants.ENVIRONMENT
          + environment + ApigeeCacheConstants.CASHES + "/" + cacheId;

      Request request = new Request.Builder().url(url)
          .addHeader(ApigeeCacheConstants.AUTHORIZATION, authorization).put(body).build();

      Response response = apigeeApiCaller.invokeApigeeApi(request);

      if (response.code() != ApigeeCacheConstants.SUCCESS_STATUS_CODE) {
        throw new ApigeeCacheOperationFailedException(String.valueOf(response.code()),
            ApigeeCacheConstants.PUT_FAIL + response.message());
      }
      logger.info("Cache Updated: {}", response.body().string());

      return ApigeeCacheConstants.PUT_SUCCESS;
    } catch (IOException e) {
      logger.error("Failed to update cache: {0}", e);
      throw new GeneralFailureException(ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }

  }


  @Override
  public String deleteCache(String authorization, String orgName, String environment,
      String cacheId) {
    try {
      String url = ApigeeCacheConstants.BASE_URL + orgName + ApigeeCacheConstants.ENVIRONMENT
          + environment + ApigeeCacheConstants.CASHES + "/" + cacheId;
      Request request = new Request.Builder().url(url)
          .addHeader(ApigeeCacheConstants.AUTHORIZATION, authorization).delete().build();

      Response response = apigeeApiCaller.invokeApigeeApi(request);

      if ((response.code() != ApigeeCacheConstants.SUCCESS_STATUS_CODE)) {
        throw new ApigeeCacheOperationFailedException(String.valueOf(response.code()),
            ApigeeCacheConstants.DELETE_FAIL + response.message());
      }
      logger.info("Cache Deleted: {}", response.body().string());
      return ApigeeCacheConstants.DELETE_SUCCESS;
    } catch (IOException e) {
      logger.error("Failed to delete cache: {0}", e);
      throw new GeneralFailureException(ApigeeCacheConstants.GENERAL_FAILURE_STATUS_CODE,
          ApigeeCacheConstants.GENERAL_FAILURE_MESSAGE);
    }
  }
}
