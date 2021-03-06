/*
 * Apigee Cache Microservice
 * Create a microservice that will perform CRUD operations on Apigee Edge cache.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dmandar@pkglobal.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.prokarma.apigee.caches.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Set to one of the following: &#x60;timeoutInSec&#x60;, &#x60;timeOfDay&#x60; or &#x60;expiryDate&#x60;.
 */
@ApiModel(description = "Set to one of the following: `timeoutInSec`, `timeOfDay` or `expiryDate`.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-12-03T08:03:39.782Z")
public class CacheRequestExpirySettingsExpirySetting   {
  @JsonProperty("value")
  private String value = null;

  public CacheRequestExpirySettingsExpirySetting value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Specified as &#x60;ss&#x60;, &#x60;hh:mm:ss&#x60;, or &#x60;mm-dd-yyyy&#x60;.
   * @return value
   **/
  @JsonProperty("value")
  @ApiModelProperty(value = "Specified as `ss`, `hh:mm:ss`, or `mm-dd-yyyy`.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CacheRequestExpirySettingsExpirySetting cacheRequestExpirySettingsExpirySetting = (CacheRequestExpirySettingsExpirySetting) o;
    return Objects.equals(this.value, cacheRequestExpirySettingsExpirySetting.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheRequestExpirySettingsExpirySetting {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

