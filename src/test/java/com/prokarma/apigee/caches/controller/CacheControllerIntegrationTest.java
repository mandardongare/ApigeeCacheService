package com.prokarma.apigee.caches.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.prokarma.apigee.caches.domain.CacheRequest;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettings;
import com.prokarma.apigee.caches.domain.CacheRequestExpirySettingsExpirySetting;
import com.prokarma.apigee.caches.service.CacheService;

@Tag("integration")
class CacheControllerIntegrationTest {

  @Mock
  CacheService cacheService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @RegisterExtension
  static ServerExtension serverExtension = new ServerExtension();

  private Client client = ClientBuilder.newClient();

  @Test
  void testGetCacheWhenPassingInvalidUrlShouldReturnErrorResponseNotFound() {
    Mockito.when(cacheService.getCacheNames("Bearer XXXX", "dummy-orgName", "dummy-env"))
        .thenReturn("[ \"dummyCache\" ]");
    Response response = client
        .target(serverExtension.getBaseUri()
            + "cache/v1/management-cache-policy/managed-cache-replace-policy/mandar-eval/test")
        .request().header("Authorization", "Bearer XXXX").get(Response.class);

    assertNotNull(response);
    assertEquals(HttpStatus.NOT_FOUND_404, response.getStatus());
  }

  @Test
  void testGetCacheWhenPassingInvalidAuthorizationTokenShouldReturnErrorResponseUnAuthorized() {
    Mockito.when(cacheService.getCacheNames("Bearer XXXX", "dummy-orgName", "dummy-env"))
        .thenReturn("[ \"dummyCache\" ]");
    Response response = client
        .target(serverExtension.getBaseUri()
            + "cache/v1/management-cache-policy/managed-cache-policy/mandar-eval/test")
        .request().header("Authorization", "Bearer XXXX").get(Response.class);

    assertNotNull(response);
    assertEquals(HttpStatus.UNAUTHORIZED_401, response.getStatus());
  }

  @Test
  void testCreateCacheWhenPassingInvalidAuthorizationTokenShouldReturnErrorResponseUnAuthorized() {
    Mockito.when(cacheService.getCacheNames("Bearer XXXX", "dummy-orgName", "dummy-env"))
        .thenReturn("[ \"dummyCache\" ]");
    Response response = client
        .target(serverExtension.getBaseUri()
            + "cache/v1/management-cache-policy/managed-cache-create-policy/mandar-eval/test")
        .request().header("Authorization", "Bearer XXXX")
        .post(Entity.entity(createCacheRequest(), MediaType.APPLICATION_JSON));

    assertNotNull(response);
    assertEquals(HttpStatus.UNAUTHORIZED_401, response.getStatus());
  }

  @Test
  void testUpdateCacheWhenPassingInvalidAuthorizationTokenShouldReturnErrorResponseUnAuthorized() {
    Mockito.when(cacheService.getCacheNames("Bearer XXXX", "dummy-orgName", "dummy-env"))
        .thenReturn("[ \"dummyCache\" ]");
    Response response = client.target(serverExtension.getBaseUri()
        + "cache/v1/management-cache-policy/managed-cache-update-policy/mandar-eval/test/myCacheId")
        .request().header("Authorization", "Bearer XXXX")
        .put(Entity.entity(createCacheRequest(), MediaType.APPLICATION_JSON));

    assertNotNull(response);
    assertEquals(HttpStatus.UNAUTHORIZED_401, response.getStatus());
  }

  @Test
  void testDeleteCacheWhenPassingInvalidAuthorizationTokenShouldReturnErrorResponseUnAuthorized() {
    Mockito.when(cacheService.getCacheNames("Bearer XXXX", "dummy-orgName", "dummy-env"))
        .thenReturn("[ \"dummyCache\" ]");
    Response response = client.target(serverExtension.getBaseUri()
        + "cache/v1/management-cache-policy/managed-cache-delete-policy/mandar-eval/test/myCacheId")
        .request().header("Authorization", "Bearer XXXX").delete(Response.class);

    assertNotNull(response);
    assertEquals(HttpStatus.UNAUTHORIZED_401, response.getStatus());
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
}
