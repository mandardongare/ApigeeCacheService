package com.prokarma.apigee.caches.domain;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;


public class CacheRequest {

  private @Valid String name = null;
  private @Valid String description = null;
  private @Valid CacheRequestCompression compression = null;
  private @Valid Integer diskSize = null;
  private @Valid CacheRequestExpirySettings expirySettings = null;
  private @Valid Boolean distributed = true;
  private @Valid Integer inMemorySize = null;
  private @Valid Boolean overflowToDisk = false;
  private @Valid Integer maxElementsInMemory = null;
  private @Valid Integer maxElementsOnDisk = null;
  private @Valid String persistent = "false";
  private @Valid Integer skipCache = null;

  /**
   * Output only. Name of cache.
   **/
  public CacheRequest name(String name) {
    this.name = name;
    return this;
  }


  @ApiModelProperty(example = "name", required = true, value = "Output only. Name of cache.")
  @JsonProperty("name")
  @NotNull
  @Pattern(regexp = ".*?")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Description of the cache resource.
   **/
  public CacheRequest description(String description) {
    this.description = description;
    return this;
  }


  @ApiModelProperty(example = "my new cache", value = "Description of the cache resource.")
  @JsonProperty("description")
  @Pattern(regexp = ".*?")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  public CacheRequest compression(CacheRequestCompression compression) {
    this.compression = compression;
    return this;
  }


  @ApiModelProperty(value = "")
  @JsonProperty("compression")
  public CacheRequestCompression getCompression() {
    return compression;
  }

  public void setCompression(CacheRequestCompression compression) {
    this.compression = compression;
  }

  /**
   * Deprecated. This value is ignored. Disk space used for the cache in MBs.
   **/
  public CacheRequest diskSize(Integer diskSize) {
    this.diskSize = diskSize;
    return this;
  }


  @ApiModelProperty(example = "0",
      value = "Deprecated. This value is ignored. Disk space used for the cache in MBs.")
  @JsonProperty("diskSize")
  public Integer getDiskSize() {
    return diskSize;
  }

  public void setDiskSize(Integer diskSize) {
    this.diskSize = diskSize;
  }

  /**
   **/
  public CacheRequest expirySettings(CacheRequestExpirySettings expirySettings) {
    this.expirySettings = expirySettings;
    return this;
  }


  @ApiModelProperty(value = "")
  @JsonProperty("expirySettings")
  public CacheRequestExpirySettings getExpirySettings() {
    return expirySettings;
  }

  public void setExpirySettings(CacheRequestExpirySettings expirySettings) {
    this.expirySettings = expirySettings;
  }

  /**
   * Output only. Flag that specifies whether the cache is distributed.
   **/
  public CacheRequest distributed(Boolean distributed) {
    this.distributed = distributed;
    return this;
  }


  @ApiModelProperty(example = "true",
      value = "Output only. Flag that specifies whether the cache is distributed.")
  @JsonProperty("distributed")
  public Boolean isDistributed() {
    return distributed;
  }

  public void setDistributed(Boolean distributed) {
    this.distributed = distributed;
  }

  /**
   * Deprecated. This value is ignored. Size threshold, in KBs, above which cache entries will be
   * compressed.
   **/
  public CacheRequest inMemorySize(Integer inMemorySize) {
    this.inMemorySize = inMemorySize;
    return this;
  }


  @ApiModelProperty(example = "0",
      value = "Deprecated. This value is ignored. Size threshold, in KBs, above which cache entries will be compressed.")
  @JsonProperty("inMemorySize")
  public Integer getInMemorySize() {
    return inMemorySize;
  }

  public void setInMemorySize(Integer inMemorySize) {
    this.inMemorySize = inMemorySize;
  }

  /**
   * Flag that specifies to overflow the in-memory cache to disk.
   **/
  public CacheRequest overflowToDisk(Boolean overflowToDisk) {
    this.overflowToDisk = overflowToDisk;
    return this;
  }


  @ApiModelProperty(example = "false",
      value = "Flag that specifies to overflow the in-memory cache to disk.")
  @JsonProperty("overflowToDisk")
  public Boolean isOverflowToDisk() {
    return overflowToDisk;
  }

  public void setOverflowToDisk(Boolean overflowToDisk) {
    this.overflowToDisk = overflowToDisk;
  }

  /**
   * Deprecated. Maximum number of entries the cache keeps in memory. Upon reaching the maximum
   * limit the entries are evicted using the LRU algorithm.
   **/
  public CacheRequest maxElementsInMemory(Integer maxElementsInMemory) {
    this.maxElementsInMemory = maxElementsInMemory;
    return this;
  }


  @ApiModelProperty(example = "0",
      value = "Deprecated. Maximum number of entries the cache keeps in memory. Upon reaching the maximum limit the entries are evicted using the LRU algorithm.")
  @JsonProperty("maxElementsInMemory")
  public Integer getMaxElementsInMemory() {
    return maxElementsInMemory;
  }

  public void setMaxElementsInMemory(Integer maxElementsInMemory) {
    this.maxElementsInMemory = maxElementsInMemory;
  }

  /**
   * Deprecated. This value is ignored. Upon reaching the max limit the entries are evicted using
   * the LRU algorithm.
   **/
  public CacheRequest maxElementsOnDisk(Integer maxElementsOnDisk) {
    this.maxElementsOnDisk = maxElementsOnDisk;
    return this;
  }


  @ApiModelProperty(example = "0",
      value = "Deprecated. This value is ignored. Upon reaching the max limit the entries are evicted using the LRU algorithm.")
  @JsonProperty("maxElementsOnDisk")
  public Integer getMaxElementsOnDisk() {
    return maxElementsOnDisk;
  }

  public void setMaxElementsOnDisk(Integer maxElementsOnDisk) {
    this.maxElementsOnDisk = maxElementsOnDisk;
  }

  /**
   * Deprecated. This value is ignored. Use expirySettings.
   **/
  public CacheRequest persistent(String persistent) {
    this.persistent = persistent;
    return this;
  }


  @ApiModelProperty(example = "false",
      value = "Deprecated. This value is ignored. Use expirySettings.")
  @JsonProperty("persistent")
  @Pattern(regexp = ".*?")
  public String getPersistent() {
    return persistent;
  }

  public void setPersistent(String persistent) {
    this.persistent = persistent;
  }

  /**
   * Deprecated. This value is ignored. Use expirySettings.
   **/
  public CacheRequest skipCache(Integer skipCache) {
    this.skipCache = skipCache;
    return this;
  }


  @ApiModelProperty(example = "1000",
      value = "Deprecated. This value is ignored. Use expirySettings.")
  @JsonProperty("skipCache")
  public Integer getSkipCache() {
    return skipCache;
  }

  public void setSkipCache(Integer skipCache) {
    this.skipCache = skipCache;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CacheRequest cacheRequest = (CacheRequest) o;
    return Objects.equals(name, cacheRequest.name)
        && Objects.equals(description, cacheRequest.description)
        && Objects.equals(compression, cacheRequest.compression)
        && Objects.equals(diskSize, cacheRequest.diskSize)
        && Objects.equals(expirySettings, cacheRequest.expirySettings)
        && Objects.equals(distributed, cacheRequest.distributed)
        && Objects.equals(inMemorySize, cacheRequest.inMemorySize)
        && Objects.equals(overflowToDisk, cacheRequest.overflowToDisk)
        && Objects.equals(maxElementsInMemory, cacheRequest.maxElementsInMemory)
        && Objects.equals(maxElementsOnDisk, cacheRequest.maxElementsOnDisk)
        && Objects.equals(persistent, cacheRequest.persistent)
        && Objects.equals(skipCache, cacheRequest.skipCache);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, compression, diskSize, expirySettings, distributed,
        inMemorySize, overflowToDisk, maxElementsInMemory, maxElementsOnDisk, persistent,
        skipCache);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CacheRequest {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
    sb.append("    diskSize: ").append(toIndentedString(diskSize)).append("\n");
    sb.append("    expirySettings: ").append(toIndentedString(expirySettings)).append("\n");
    sb.append("    distributed: ").append(toIndentedString(distributed)).append("\n");
    sb.append("    inMemorySize: ").append(toIndentedString(inMemorySize)).append("\n");
    sb.append("    overflowToDisk: ").append(toIndentedString(overflowToDisk)).append("\n");
    sb.append("    maxElementsInMemory: ").append(toIndentedString(maxElementsInMemory))
        .append("\n");
    sb.append("    maxElementsOnDisk: ").append(toIndentedString(maxElementsOnDisk)).append("\n");
    sb.append("    persistent: ").append(toIndentedString(persistent)).append("\n");
    sb.append("    skipCache: ").append(toIndentedString(skipCache)).append("\n");
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

