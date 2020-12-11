package com.prokarma.apigee.caches.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Enables different expiration mechanisms to be applied to entries in the cache. Cache entries can
 * be expired a certain number of seconds after creation, at a specific time of day each day, or on
 * a specific date.
 **/
import io.swagger.annotations.ApiModelProperty;

public class CacheExpirySettings {
  @JsonProperty("expiryDate")
  private CacheExpirySettingsExpirySetting expirySetting = null;
  private String valuesNull = "false";

  /**
   **/
  public CacheExpirySettings expirySetting(CacheExpirySettingsExpirySetting expirySetting) {
    this.expirySetting = expirySetting;
    return this;
  }


  @ApiModelProperty(value = "")
  @JsonProperty("expiryDate")

  public CacheExpirySettingsExpirySetting getExpirySetting() {
    return expirySetting;
  }

  public void setExpirySetting(CacheExpirySettingsExpirySetting expirySetting) {
    this.expirySetting = expirySetting;
  }

  /**
   * The Populate cache policy also lets you set expiry settings. The &#x60;valuesNull&#x60;
   * property controls which expiry settings are applied for each entry. * If &#x60;valuesNull
   * &#x3D; false&#x60; (default), expiry settings in the PopulateCache policy are used. * If
   * &#x60;valuesNull &#x3D; true&#x60;, expiry settings in the PopulateCache policy are ignored.
   **/
  public CacheExpirySettings valuesNull(String valuesNull) {
    this.valuesNull = valuesNull;
    return this;
  }


  @ApiModelProperty(
      value = "The Populate cache policy also lets you set expiry settings. The `valuesNull` property controls which expiry settings are applied for each entry.  * If `valuesNull = false` (default), expiry settings in the PopulateCache policy are used.  * If `valuesNull = true`, expiry settings in the PopulateCache policy are ignored.")
  @JsonProperty("valuesNull")

  public String isValuesNull() {
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
    CacheExpirySettings cacheExpirySettings = (CacheExpirySettings) o;
    return Objects.equals(expirySetting, cacheExpirySettings.expirySetting)
        && Objects.equals(valuesNull, cacheExpirySettings.valuesNull);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirySetting, valuesNull);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheExpirySettings {\n");

    sb.append("    expirySetting: ").append(toIndentedString(expirySetting)).append("\n");
    sb.append("    valuesNull: ").append(toIndentedString(valuesNull)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
