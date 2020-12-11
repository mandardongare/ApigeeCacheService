package com.prokarma.apigee.caches.model;


import java.util.Objects;

public class CacheExpirySettingsExpirySetting   {
  private String value = null;

  /**
   * Specified as &#x60;ss&#x60;, &#x60;hh:mm:ss&#x60;, or &#x60;mm-dd-yyyy&#x60;.
   **/
  public CacheExpirySettingsExpirySetting value(String value) {
    this.value = value;
    return this;
  }

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
    CacheExpirySettingsExpirySetting cacheExpirySettingsExpirySetting = (CacheExpirySettingsExpirySetting) o;
    return Objects.equals(value, cacheExpirySettingsExpirySetting.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheExpirySettingsExpirySetting {\n");
    
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
