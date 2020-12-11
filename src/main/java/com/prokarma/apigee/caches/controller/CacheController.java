package com.prokarma.apigee.caches.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prokarma.apigee.caches.converter.ApigeeCacheConverter;
import com.prokarma.apigee.caches.converter.CacheResponseConverter;
import com.prokarma.apigee.caches.domain.CacheRequest;
import com.prokarma.apigee.caches.domain.CacheResponse;
import com.prokarma.apigee.caches.model.Cache;
import com.prokarma.apigee.caches.service.CacheService;
import com.prokarma.apigee.caches.util.ObjectMapperUtil;

@Path("/cache/v1")
public class CacheController {

  Logger logger = LoggerFactory.getLogger(CacheController.class);

  @Inject
  private CacheService cacheService;

  @Inject
  private ApigeeCacheConverter apigeeCacheConverter;

  @Inject
  private CacheResponseConverter cacheResponseConverter;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/management-cache-policy/managed-cache-policy/{org-name}/{env-name}")
  public Response getCache(@NotNull @HeaderParam("Authorization") String authorization,
      @PathParam("org-name") String organization, @PathParam("env-name") String environment) {
    String response = cacheService.getCacheNames(authorization, organization, environment);
    logger.info("The caches retrieved: {}", response);
    CacheResponse cacheResponse = cacheResponseConverter.convert(response);
    return Response.ok(cacheResponse, MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/management-cache-policy/managed-cache-create-policy/{org-name}/{env-name}")
  public Response createCache(@NotNull @HeaderParam("Authorization") String authorization,
      @PathParam("org-name") String organization, @PathParam("env-name") String environment,
      @Valid CacheRequest cacheRequest) {
    logger.info("Input CacheRequest to be create: {}",
        ObjectMapperUtil.returnJsonFromObject(cacheRequest));
    Cache cache = apigeeCacheConverter.convert(cacheRequest);
    String response = cacheService.createCache(ObjectMapperUtil.returnJsonFromObject(cache),
        authorization, organization, environment);
    CacheResponse cacheResponse = cacheResponseConverter.convert(response);
    return Response.ok(cacheResponse, MediaType.APPLICATION_JSON).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/management-cache-policy/managed-cache-update-policy/{org-name}/{env-name}/{cache-id}")
  public Response updateCache(@NotNull @HeaderParam("Authorization") String authorization,
      @PathParam("org-name") String organization, @PathParam("env-name") String environment,
      @PathParam("cache-id") String cacheId, @Valid CacheRequest cacheRequest) {
    logger.info("Input CacheRequest to be update: {}",
        ObjectMapperUtil.returnJsonFromObject(cacheRequest));
    Cache cache = apigeeCacheConverter.convert(cacheRequest);
    String response = cacheService.updateCache(ObjectMapperUtil.returnJsonFromObject(cache),
        authorization, organization, environment, cacheId);
    CacheResponse cacheResponse = cacheResponseConverter.convert(response);
    return Response.ok(cacheResponse, MediaType.APPLICATION_JSON).build();
  }

  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/management-cache-policy/managed-cache-delete-policy/{org-name}/{env-name}/{cache-id}")
  public Response deleteCache(@NotNull @HeaderParam("Authorization") String authorization,
      @PathParam("org-name") String organization, @PathParam("env-name") String environment,
      @PathParam("cache-id") String cacheId) {
    logger.info("Cache to be delete: {}", cacheId);
    String response = cacheService.deleteCache(authorization, organization, environment, cacheId);
    CacheResponse cacheResponse = cacheResponseConverter.convert(response);
    return Response.ok(cacheResponse, MediaType.APPLICATION_JSON).build();
  }
}
