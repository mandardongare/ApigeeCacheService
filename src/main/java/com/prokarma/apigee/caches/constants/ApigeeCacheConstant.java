package com.prokarma.apigee.caches.constants;

public enum ApigeeCacheConstant {
	
	SUCCESS("success"), FAIL("fail");
	
	private ApigeeCacheConstant(String value) {
	    this.value = value;
	  }

	  private String value;

	  public String getValue() {
	    return value;
	  }

}
