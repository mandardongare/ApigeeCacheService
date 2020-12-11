package com.prokarma.apigee.caches.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstant;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.prokarma.apigee.caches.converter.ApigeeCacheConverter;
import com.prokarma.apigee.caches.converter.CacheResponseConverter;
import com.prokarma.apigee.caches.domain.CacheRequest;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettings;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettingsExpirySetting;
import com.prokarma.apigee.caches.domain.CacheResponse;
import com.prokarma.apigee.caches.model.Cache;
import com.prokarma.apigee.caches.model.CacheExpirySettings;
import com.prokarma.apigee.caches.model.CacheExpirySettingsExpirySetting;
import com.prokarma.apigee.caches.service.CacheService;
import com.prokarma.apigee.caches.util.ObjectMapperUtil;

@Tag("unit")
class CacheControllerTest {

  @InjectMocks
  private CacheController cacheController;

  @Mock
  private CacheService cacheService;

  @Mock
  private ApigeeCacheConverter apigeeCacheConverter;

  @Mock
  private CacheResponseConverter cacheResponseConverter;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  private final String dummyAuth = "Bearer XXXX", dummyOrgName = "dummy-orgName",
      dummyEnvironment = "dummy-env", dummyCacheId = "dummyCache";

  @Test
  void testgetCacheWhenPassingValidConfigDetailsShouldReturnSuccess() {
    when(cacheService.getCacheNames(dummyAuth, dummyOrgName, dummyEnvironment))
        .thenReturn(getSuccessResponseForgetCache());
    when(cacheResponseConverter.convert(Mockito.any(String.class)))
        .thenReturn((CacheResponse) createValidCacheResponse());
    Response response = cacheController.getCache(dummyAuth, dummyOrgName, dummyEnvironment);
    assertNotNull(response);
    assertEquals(ApigeeCacheConstants.SUCCESS_STATUS_CODE, response.getStatus());
  }

  @Test
  void testcreateCacheWhenPassingValidConfigDetailsAndValidCacheRequestShouldReturnSuccess() {
    when(cacheService.createCache(ObjectMapperUtil.returnJsonFromObject(createValidCache()),
        dummyAuth, dummyOrgName, dummyEnvironment)).thenReturn(getSuccessResponseForCreateCache());

    when(apigeeCacheConverter.convert(Mockito.any(CacheRequest.class)))
        .thenReturn((Cache) createValidCache());

    when(cacheResponseConverter.convert(Mockito.any(String.class)))
        .thenReturn((CacheResponse) createValidCacheResponse());
    Response response = cacheController.createCache(dummyAuth, dummyOrgName, dummyEnvironment,
        createCacheRequest());
    assertNotNull(response);
    assertEquals(ApigeeCacheConstants.SUCCESS_STATUS_CODE, response.getStatus());
  }

  @Test
  void testupdateCacheWhenPassingValidConfigDetailsAndValidCacheRequestShouldReturnSuccess() {
    when(cacheService.updateCache(ObjectMapperUtil.returnJsonFromObject(createValidCache()),
        dummyAuth, dummyOrgName, dummyEnvironment, dummyCacheId))
            .thenReturn(getSuccessResponseForUpdateCache());

    when(apigeeCacheConverter.convert(Mockito.any(CacheRequest.class)))
        .thenReturn((Cache) createValidCache());

    when(cacheResponseConverter.convert(Mockito.any(String.class)))
        .thenReturn((CacheResponse) createValidCacheResponse());
    Response response = cacheController.updateCache(dummyAuth, dummyOrgName, dummyEnvironment,
        dummyCacheId, createCacheRequest());
    assertNotNull(response);
    assertEquals(ApigeeCacheConstants.SUCCESS_STATUS_CODE, response.getStatus());
  }

  @Test
  void testdeleteCacheWhenPassingValidConfigDetailsShouldReturnSuccess() {
    when(cacheService.deleteCache(dummyAuth, dummyOrgName, dummyEnvironment, dummyCacheId))
        .thenReturn(getSuccessResponseForDeleteCache());
    when(cacheResponseConverter.convert(Mockito.any(String.class)))
        .thenReturn((CacheResponse) createValidCacheResponse());
    Response response =
        cacheController.deleteCache(dummyAuth, dummyOrgName, dummyEnvironment, dummyCacheId);
    assertNotNull(response);
    assertEquals(ApigeeCacheConstants.SUCCESS_STATUS_CODE, response.getStatus());
  }


  private CacheRequest createCacheRequest() {
    CacheRequest cacheRequest = new CacheRequest();
    cacheRequest.setName("dummyCache");
    cacheRequest.setDescription("dummy desc");
    cacheRequest.setSkipCache(1000);
    CacheRequestExpirySettings cacheExpirySettings = new CacheRequestExpirySettings();
    cacheExpirySettings
        .expirySetting(new CacheRequestExpirySettingsExpirySetting().value("10-10-2020"));
    cacheExpirySettings.setValuesNull("true");
    cacheRequest.setExpirySettings(cacheExpirySettings);
    cacheRequest.setDistributed(true);

    return cacheRequest;
  }

  private Cache createValidCache() {
    Cache cache = new Cache();
    cache.setName("dummyCache");
    cache.setDescription("dummy desc");
    cache.setSkipCacheIfElementSizeInKBExceeds(1000);
    CacheExpirySettings cacheExpirySettings = new CacheExpirySettings();
    cacheExpirySettings.expirySetting(new CacheExpirySettingsExpirySetting().value("10-10-2020"));
    cacheExpirySettings.setValuesNull("true");
    cache.setExpirySettings(cacheExpirySettings);
    cache.setDistributed(true);
    return cache;
  }

  private String getSuccessResponseForgetCache() {
    return "[ \"dummyCache\" ]";
  }

  private String getSuccessResponseForCreateCache() {
    return ApigeeCacheConstants.POST_SUCCESS;
  }

  private String getSuccessResponseForUpdateCache() {
    return ApigeeCacheConstants.PUT_SUCCESS;
  }

  private String getSuccessResponseForDeleteCache() {
    return ApigeeCacheConstants.PUT_SUCCESS;
  }

  private CacheResponse createValidCacheResponse() {
    CacheResponse response = new CacheResponse();
    response.setStatus(ApigeeCacheConstant.SUCCESS.getValue());
    response.setMessage("[ \"dummyCache\" ]");
    return response;
  }

}
