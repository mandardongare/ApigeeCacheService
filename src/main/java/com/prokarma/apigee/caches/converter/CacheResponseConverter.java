package com.prokarma.apigee.caches.converter;

import com.prokarma.apigee.caches.constants.ApigeeCacheConstant;
import com.prokarma.apigee.caches.domain.CacheResponse;

public class CacheResponseConverter implements Converter<String,CacheResponse> {

	@Override
	public CacheResponse convert(String input) {
		CacheResponse response = new CacheResponse();
		response.setStatus(ApigeeCacheConstant.SUCCESS.getValue());
		response.setMessage(input);
		return response;
	}
}
