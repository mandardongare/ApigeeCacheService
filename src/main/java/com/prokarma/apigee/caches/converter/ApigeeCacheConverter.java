package com.prokarma.apigee.caches.converter;

import com.prokarma.apigee.caches.domain.CacheRequest;
import com.prokarma.apigee.caches.model.Cache;
import com.prokarma.apigee.caches.model.CacheCompression;
import com.prokarma.apigee.caches.model.CacheExpirySettings;
import com.prokarma.apigee.caches.model.CacheExpirySettingsExpirySetting;

public class ApigeeCacheConverter implements Converter<CacheRequest, Cache> {

  @Override
  public Cache convert(CacheRequest input) {
    Cache cache = new Cache();

    CacheCompression cacheCompression = new CacheCompression();
    if (input.getCompression() != null && input.getCompression().getMinimumSize() != null)
      cacheCompression.setMinimumSizeInKB(input.getCompression().getMinimumSize());
    cache.setCompression(cacheCompression);

    cache.setDescription(input.getDescription());
    cache.setName(input.getName());

    CacheExpirySettings expirySettings = new CacheExpirySettings();
    CacheExpirySettingsExpirySetting cexpirySetting = new CacheExpirySettingsExpirySetting();
    if (input.getExpirySettings() != null && input.getExpirySettings().getExpirySetting() != null
        && input.getExpirySettings().getExpirySetting().getValue() != null)
      cexpirySetting.setValue(input.getExpirySettings().getExpirySetting().getValue());
    expirySettings.setExpirySetting(cexpirySetting);
    expirySettings.setValuesNull(input.getExpirySettings().getValuesNull());
    cache.setExpirySettings(expirySettings);

    cache.setDiskSizeInMB(input.getDiskSize() != null ? input.getDiskSize() : null);
    cache.setDistributed(input.isDistributed());
    cache.setInMemorySizeInKB(input.getInMemorySize() != null ? input.getInMemorySize() : null);
    cache.setMaxElementsInMemory(
        input.getMaxElementsInMemory() != null ? input.getMaxElementsInMemory() : null);
    cache.setMaxElementsOnDisk(
        input.getMaxElementsOnDisk() != null ? input.getMaxElementsOnDisk() : null);
    cache.setSkipCacheIfElementSizeInKBExceeds(input.getSkipCache());

    return cache;
  }

}
