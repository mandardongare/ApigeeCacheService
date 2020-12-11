package com.prokarma.apigee.caches.converter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.prokarma.apigee.caches.domain.CacheRequest;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettings;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettingsExpirySetting;
import com.prokarma.apigee.caches.model.Cache;

@Tag("unit")
class ApigeeCacheConverterTest {

  private ApigeeCacheConverter apigeeCacheConverter;

  @BeforeEach
  public void setUp() {
    apigeeCacheConverter = new ApigeeCacheConverter();
  }

  @Test
  void testConvertWhenPassingValidCacheRequestObjectShouldConvertItIntoCacheObject() {
    Cache cache = apigeeCacheConverter.convert(createCacheRequest());
    assertNotNull(cache);
    assertEquals("myCache", cache.getName());
    assertEquals(Integer.valueOf(1000), cache.getSkipCacheIfElementSizeInKBExceeds());
  }

  private CacheRequest createCacheRequest() {
    CacheRequest cacheRequest = new CacheRequest();
    cacheRequest.setName("myCache");
    cacheRequest.setDescription("test description");
    cacheRequest.setDiskSize(0);
    cacheRequest.setOverflowToDisk(true);
    cacheRequest.setDistributed(true);
    cacheRequest.expirySettings(createCacheRequestExpirySetting());
    cacheRequest.setInMemorySize(0);
    cacheRequest.setSkipCache(1000);
    return cacheRequest;
  }

  private CacheRequestExpirySettings createCacheRequestExpirySetting() {
    CacheRequestExpirySettings setting = new CacheRequestExpirySettings();
    CacheRequestExpirySettingsExpirySetting cSetting =
        new CacheRequestExpirySettingsExpirySetting();
    cSetting.setValue("10-10-2021");
    setting.setExpirySetting(cSetting);
    return setting;
  }



}
