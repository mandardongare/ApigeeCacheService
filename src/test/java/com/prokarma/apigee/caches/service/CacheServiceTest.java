package com.prokarma.apigee.caches.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.model.Cache;
import com.prokarma.apigee.caches.model.CacheExpirySettings;
import com.prokarma.apigee.caches.model.CacheExpirySettingsExpirySetting;
import com.prokarma.apigee.caches.util.ApigeeApiCaller;
import com.prokarma.apigee.caches.util.ObjectMapperUtil;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;


@Tag("unit")
class CacheServiceTest {

  @InjectMocks
  private CacheServiceImpl cacheService;

  @Mock
  ApigeeApiCaller apigeeApiCaller;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetCacheNamesWhenMockingApigeeCallShouldReturnSuccessResponse() {
    when(apigeeApiCaller.invokeApigeeApi(Mockito.any(Request.class)))
        .thenReturn(createGetResponse());
    String response = cacheService.getCacheNames("Bearer XXXX", "dummy-eval", "dummy-env");
    assertEquals("[ \"mycache3\" ]", response);
  }

  @Test
  void testCreateCacheWhenMockingApigeeCallShouldReturnResponseAsCreated() {
    when(apigeeApiCaller.invokeApigeeApi(Mockito.any(Request.class)))
        .thenReturn(createPostResponse());
    String response =
        cacheService.createCache(createJson(), "Bearer XXXX", "dummy-eval", "dummy-env");
    assertEquals(ApigeeCacheConstants.POST_SUCCESS, response);
  }

  @Test
  void testUpdateCacheWhenMockingApigeeCallShouldReturnSuccessResponse() {
    when(apigeeApiCaller.invokeApigeeApi(Mockito.any(Request.class)))
        .thenReturn(createPutResponse());
    String response =
        cacheService.updateCache(createJson(), "Bearer XXXX", "dummy-eval", "dummy-env", "mycache");
    assertEquals(ApigeeCacheConstants.PUT_SUCCESS, response);
  }

  @Test
  void testDeleteCacheWhenMockingApigeeCallShouldReturnSuccessResponse() {
    when(apigeeApiCaller.invokeApigeeApi(Mockito.any(Request.class)))
        .thenReturn(createDeleteResponse());
    String response = cacheService.deleteCache("Bearer XXXX", "dummy-eval", "dummy-env", "mycache");
    assertEquals(ApigeeCacheConstants.DELETE_SUCCESS, response);
  }

  private String createJson() {
    Cache cache = new Cache();
    cache.setName("dummyName");
    cache.setDescription("dummy desc");
    cache.setSkipCacheIfElementSizeInKBExceeds(1000);
    CacheExpirySettings cacheExpirySettings = new CacheExpirySettings();
    cacheExpirySettings.expirySetting(new CacheExpirySettingsExpirySetting().value("10-10-2020"));
    cacheExpirySettings.setValuesNull("true");
    cache.setExpirySettings(cacheExpirySettings);
    cache.setDistributed(true);
    return ObjectMapperUtil.returnJsonFromObject(cache);
  }

  private Response createGetResponse() {
    return new Response.Builder().request(new Request.Builder().url("http://dummyurl.com").build())
        .protocol(Protocol.HTTP_1_1).code(200).body(ResponseBody
            .create(MediaType.parse("application/json; charset=utf-8"), "[ \"mycache3\" ]"))
        .message("success").build();
  }

  private Response createPostResponse() {
    return new Response.Builder().request(new Request.Builder().url("http://dummyurl.com").build())
        .protocol(Protocol.HTTP_1_1).code(201)
        .body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{}"))
        .message("created").build();
  }

  private Response createPutResponse() {
    return new Response.Builder().request(new Request.Builder().url("http://dummyurl.com").build())
        .protocol(Protocol.HTTP_1_1).code(200)
        .body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{}"))
        .message("created").build();
  }

  private Response createDeleteResponse() {
    return new Response.Builder().request(new Request.Builder().url("http://dummyurl.com").build())
        .protocol(Protocol.HTTP_1_1).code(200)
        .body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{}"))
        .message("created").build();
  }

}
