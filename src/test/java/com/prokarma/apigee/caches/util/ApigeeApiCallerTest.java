package com.prokarma.apigee.caches.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.prokarma.apigee.caches.constants.ApigeeCacheConstants;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Tag("unit")
class ApigeeApiCallerTest {

  @InjectMocks
  private ApigeeApiCaller apigeeApiCaller;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  private final String dummyAuth = "Bearer XXXX";

  @Test
  void testinvokeApigeeApiWhenPassingValidRequestObjectShouldReturnSuccess() {
    String url =
        "https://api.enterprise.apigee.com/v1/organizations/mandardongare119-eval/environments/test/caches";
    Request request = new Request.Builder().url(url)
        .addHeader(ApigeeCacheConstants.AUTHORIZATION, dummyAuth).get().build();

    Response response = apigeeApiCaller.invokeApigeeApi(request);
    assertNotNull(response);
    assertEquals(401, response.code());
  }


}
