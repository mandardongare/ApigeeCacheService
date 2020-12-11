package com.prokarma.apigee.caches.model;

import java.util.Objects;

public class CacheCompression {
  private Integer minimumSizeInKB = null;

  /**
   * Size threshold, in KBs, above which cache entries will be compressed.
   **/
  public CacheCompression minimumSizeInKB(Integer minimumSizeInKB) {
    this.minimumSizeInKB = minimumSizeInKB;
    return this;
  }


  public Integer getMinimumSizeInKB() {
    return minimumSizeInKB;
  }

  public void setMinimumSizeInKB(Integer minimumSizeInKB) {
    this.minimumSizeInKB = minimumSizeInKB;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CacheCompression cacheCompression = (CacheCompression) o;
    return Objects.equals(minimumSizeInKB, cacheCompression.minimumSizeInKB);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minimumSizeInKB);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheCompression {\n");

    sb.append("    minimumSizeInKB: ").append(toIndentedString(minimumSizeInKB)).append("\n");
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
