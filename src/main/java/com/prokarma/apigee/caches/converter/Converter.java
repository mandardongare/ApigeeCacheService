package com.prokarma.apigee.caches.converter;

public interface Converter<I, O> {
  O convert(I input);
}
