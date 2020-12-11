package com.prokarma.apigee.caches.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
public class Cache   {
  private  CacheCompression compression = null;
  private  String description = null;
  private  Integer diskSizeInMB = 0;
  private  Boolean distributed = true;
  private  CacheExpirySettings expirySettings = null;
  private  Integer inMemorySizeInKB = 0;
  private  Integer maxElementsInMemory = 0;
  private  Integer maxElementsOnDisk = 0;
  private  String name = null;
  private  Boolean overflowToDisk = false;
  private  Boolean persistent = false;
  private  Integer skipCacheIfElementSizeInKBExceeds = null;

  /**
   **/
  public Cache compression(CacheCompression compression) {
    this.compression = compression;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("compression")

  public CacheCompression getCompression() {
    return compression;
  }
  public void setCompression(CacheCompression compression) {
    this.compression = compression;
  }

  /**
   * Description of the cache resource.
   **/
  public Cache description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(value = "Description of the cache resource.")
  @JsonProperty("description")

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Deprecated. This value is ignored. Disk space used for the cache in MBs.
   **/
  public Cache diskSizeInMB(Integer diskSizeInMB) {
    this.diskSizeInMB = diskSizeInMB;
    return this;
  }

  
  @ApiModelProperty(value = "Deprecated. This value is ignored. Disk space used for the cache in MBs.")
  @JsonProperty("diskSizeInMB")

  public Integer getDiskSizeInMB() {
    return diskSizeInMB;
  }
  public void setDiskSizeInMB(Integer diskSizeInMB) {
    this.diskSizeInMB = diskSizeInMB;
  }

  /**
   * Output only. Flag that specifies whether the cache is distributed.
   **/
  public Cache distributed(Boolean distributed) {
    this.distributed = distributed;
    return this;
  }

  
  @ApiModelProperty(value = "Output only. Flag that specifies whether the cache is distributed.")
  @JsonProperty("distributed")
  public Boolean isDistributed() {
	    return distributed;
	  }
  public void setDistributed(Boolean distributed) {
    this.distributed = distributed;
  }

  /**
   **/
  public Cache expirySettings(CacheExpirySettings expirySettings) {
    this.expirySettings = expirySettings;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("expirySettings")

  public CacheExpirySettings getExpirySettings() {
    return expirySettings;
  }
  public void setExpirySettings(CacheExpirySettings expirySettings) {
    this.expirySettings = expirySettings;
  }

  /**
   * Deprecated. This value is ignored. Size threshold, in KBs, above which cache entries will be compressed.
   **/
  public Cache inMemorySizeInKB(Integer inMemorySizeInKB) {
    this.inMemorySizeInKB = inMemorySizeInKB;
    return this;
  }

  
  @ApiModelProperty(value = "Deprecated. This value is ignored. Size threshold, in KBs, above which cache entries will be compressed.")
  @JsonProperty("inMemorySizeInKB")

  public Integer getInMemorySizeInKB() {
    return inMemorySizeInKB;
  }
  public void setInMemorySizeInKB(Integer inMemorySizeInKB) {
    this.inMemorySizeInKB = inMemorySizeInKB;
  }

  /**
   * Deprecated. Maximum number of entries the cache keeps in memory. Upon reaching the maximum limit the entries are evicted using the LRU algorithm.
   **/
  public Cache maxElementsInMemory(Integer maxElementsInMemory) {
    this.maxElementsInMemory = maxElementsInMemory;
    return this;
  }

  
  @ApiModelProperty(value = "Deprecated. Maximum number of entries the cache keeps in memory. Upon reaching the maximum limit the entries are evicted using the LRU algorithm.")
  @JsonProperty("maxElementsInMemory")

  public Integer getMaxElementsInMemory() {
    return maxElementsInMemory;
  }
  public void setMaxElementsInMemory(Integer maxElementsInMemory) {
    this.maxElementsInMemory = maxElementsInMemory;
  }

  /**
   * Deprecated. This value is ignored. Upon reaching the max limit the entries are evicted using the LRU algorithm.
   **/
  public Cache maxElementsOnDisk(Integer maxElementsOnDisk) {
    this.maxElementsOnDisk = maxElementsOnDisk;
    return this;
  }

  
  @ApiModelProperty(value = "Deprecated. This value is ignored. Upon reaching the max limit the entries are evicted using the LRU algorithm.")
  @JsonProperty("maxElementsOnDisk")

  public Integer getMaxElementsOnDisk() {
    return maxElementsOnDisk;
  }
  public void setMaxElementsOnDisk(Integer maxElementsOnDisk) {
    this.maxElementsOnDisk = maxElementsOnDisk;
  }

  /**
   * Output only. Name of cache.
   **/
  public Cache name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "Output only. Name of cache.")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Flag that specifies to overflow the in-memory cache to disk.
   **/
  public Cache overflowToDisk(Boolean overflowToDisk) {
    this.overflowToDisk = overflowToDisk;
    return this;
  }

  
  @ApiModelProperty(value = "Flag that specifies to overflow the in-memory cache to disk.")
  @JsonProperty("overflowToDisk")

  public Boolean isOverflowToDisk() {
    return overflowToDisk;
  }
  public void setOverflowToDisk(Boolean overflowToDisk) {
    this.overflowToDisk = overflowToDisk;
  }

  /**
   * Deprecated. This value is ignored. Use expirySettings.
   **/
  public Cache persistent(Boolean persistent) {
    this.persistent = persistent;
    return this;
  }

  
  @ApiModelProperty(value = "Deprecated. This value is ignored. Use expirySettings.")
  @JsonProperty("persistent")

  public Boolean isPersistent() {
    return persistent;
  }
  public void setPersistent(Boolean persistent) {
    this.persistent = persistent;
  }

  /**
   * Size limit, in KBs, for cache entries. Data exceeding the limit will not be cached.
   **/
  public Cache skipCacheIfElementSizeInKBExceeds(Integer skipCacheIfElementSizeInKBExceeds) {
    this.skipCacheIfElementSizeInKBExceeds = skipCacheIfElementSizeInKBExceeds;
    return this;
  }

  
  @ApiModelProperty(value = "Size limit, in KBs, for cache entries. Data exceeding the limit will not be cached.")
  @JsonProperty("skipCacheIfElementSizeInKBExceeds")

  public Integer getSkipCacheIfElementSizeInKBExceeds() {
    return skipCacheIfElementSizeInKBExceeds;
  }
  public void setSkipCacheIfElementSizeInKBExceeds(Integer skipCacheIfElementSizeInKBExceeds) {
    this.skipCacheIfElementSizeInKBExceeds = skipCacheIfElementSizeInKBExceeds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cache cache = (Cache) o;
    return Objects.equals(compression, cache.compression) &&
        Objects.equals(description, cache.description) &&
        Objects.equals(diskSizeInMB, cache.diskSizeInMB) &&
        Objects.equals(distributed, cache.distributed) &&
        Objects.equals(expirySettings, cache.expirySettings) &&
        Objects.equals(inMemorySizeInKB, cache.inMemorySizeInKB) &&
        Objects.equals(maxElementsInMemory, cache.maxElementsInMemory) &&
        Objects.equals(maxElementsOnDisk, cache.maxElementsOnDisk) &&
        Objects.equals(name, cache.name) &&
        Objects.equals(overflowToDisk, cache.overflowToDisk) &&
        Objects.equals(persistent, cache.persistent) &&
        Objects.equals(skipCacheIfElementSizeInKBExceeds, cache.skipCacheIfElementSizeInKBExceeds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(compression, description, diskSizeInMB, distributed, expirySettings, inMemorySizeInKB, maxElementsInMemory, maxElementsOnDisk, name, overflowToDisk, persistent, skipCacheIfElementSizeInKBExceeds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cache {\n");
    
    sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    diskSizeInMB: ").append(toIndentedString(diskSizeInMB)).append("\n");
    sb.append("    distributed: ").append(toIndentedString(distributed)).append("\n");
    sb.append("    expirySettings: ").append(toIndentedString(expirySettings)).append("\n");
    sb.append("    inMemorySizeInKB: ").append(toIndentedString(inMemorySizeInKB)).append("\n");
    sb.append("    maxElementsInMemory: ").append(toIndentedString(maxElementsInMemory)).append("\n");
    sb.append("    maxElementsOnDisk: ").append(toIndentedString(maxElementsOnDisk)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    overflowToDisk: ").append(toIndentedString(overflowToDisk)).append("\n");
    sb.append("    persistent: ").append(toIndentedString(persistent)).append("\n");
    sb.append("    skipCacheIfElementSizeInKBExceeds: ").append(toIndentedString(skipCacheIfElementSizeInKBExceeds)).append("\n");
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
