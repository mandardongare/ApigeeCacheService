package com.prokarma.apigee.caches.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.prokarma.apigee.caches.domain.CacheResponse;

@Tag("unit")
class CacheResponseConverterTest {

  private CacheResponseConverter cacheResponseConverter;

  @BeforeEach
  public void setUp() {
    cacheResponseConverter = new CacheResponseConverter();
  }

  @Test
  void testConvertWhenPassingValidResponseShouldConvertItIntoCacheResponseObject() {
    CacheResponse cacheResponse = cacheResponseConverter.convert("Cache created Successfully");
    assertNotNull(cacheResponse);
    assertEquals("success", cacheResponse.getStatus());
  }
}
