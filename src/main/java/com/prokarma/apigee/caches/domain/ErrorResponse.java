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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * It represents the failure response of the Api
 */
@ApiModel(description = "It represents the failure response of the Api")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-12-03T08:03:39.782Z")
public class ErrorResponse   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("errorType")
  private String errorType = null;

  public ErrorResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status will always be fail.
   * @return status
   **/
  @JsonProperty("status")
  @ApiModelProperty(example = "fail", required = true, value = "The status will always be fail.")
  @NotNull
 @Pattern(regexp="^[fail]$")  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A human-readable message describing error.
   * @return message
   **/
  @JsonProperty("message")
  @ApiModelProperty(example = "Failed to create the cache.", required = true, value = "A human-readable message describing error.")
  @NotNull
 @Pattern(regexp=".*?")  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse errorType(String errorType) {
    this.errorType = errorType;
    return this;
  }

  /**
   * the type of exception thrown.
   * @return errorType
   **/
  @JsonProperty("errorType")
  @ApiModelProperty(example = "InvalidCacheObjectException.", required = true, value = "the type of exception thrown.")
  @NotNull
 @Pattern(regexp=".*?")  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.errorType, errorResponse.errorType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, errorType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
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

