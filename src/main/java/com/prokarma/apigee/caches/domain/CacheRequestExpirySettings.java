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
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Enables different expiration mechanisms to be applied to entries in the cache. Cache entries can be expired a certain number of seconds after creation, at a specific time of day each day, or on a specific date.
 */
@ApiModel(description = "Enables different expiration mechanisms to be applied to entries in the cache. Cache entries can be expired a certain number of seconds after creation, at a specific time of day each day, or on a specific date.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-12-03T08:03:39.782Z")
public class CacheRequestExpirySettings   {
  @JsonProperty("expiryDate")
  private CacheRequestExpirySettingsExpirySetting expirySetting = null;

  @JsonProperty("valuesNull")
  private String valuesNull = "false";

  public CacheRequestExpirySettings expirySetting(CacheRequestExpirySettingsExpirySetting expirySetting) {
    this.expirySetting = expirySetting;
    return this;
  }

  /**
   * Get expirySetting
   * @return expirySetting
   **/
  @JsonProperty("expiryDate")
  @ApiModelProperty(value = "")
  @Valid
  public CacheRequestExpirySettingsExpirySetting getExpirySetting() {
    return expirySetting;
  }

  public void setExpirySetting(CacheRequestExpirySettingsExpirySetting expirySetting) {
    this.expirySetting = expirySetting;
  }

  public CacheRequestExpirySettings valuesNull(String valuesNull) {
    this.valuesNull = valuesNull;
    return this;
  }

  /**
   * The Populate cache policy also lets you set expiry settings. The &#x60;valuesNull&#x60; property controls which expiry settings are applied for each entry.  * If &#x60;valuesNull &#x3D; false&#x60; (default), expiry settings in the PopulateCache policy are used.  * If &#x60;valuesNull &#x3D; true&#x60;, expiry settings in the PopulateCache policy are ignored.
   * @return valuesNull
   **/
  @JsonProperty("valuesNull")
  @ApiModelProperty(example = "false", value = "The Populate cache policy also lets you set expiry settings. The `valuesNull` property controls which expiry settings are applied for each entry.  * If `valuesNull = false` (default), expiry settings in the PopulateCache policy are used.  * If `valuesNull = true`, expiry settings in the PopulateCache policy are ignored.")
 @Pattern(regexp=".*?")  public String getValuesNull() {
    return valuesNull;
  }

  public void setValuesNull(String valuesNull) {
    this.valuesNull = valuesNull;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CacheRequestExpirySettings cacheRequestExpirySettings = (CacheRequestExpirySettings) o;
    return Objects.equals(this.expirySetting, cacheRequestExpirySettings.expirySetting) &&
        Objects.equals(this.valuesNull, cacheRequestExpirySettings.valuesNull);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirySetting, valuesNull);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheRequestExpirySettings {\n");
    
    sb.append("    expirySetting: ").append(toIndentedString(expirySetting)).append("\n");
    sb.append("    valuesNull: ").append(toIndentedString(valuesNull)).append("\n");
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
