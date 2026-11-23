package com.fastcooking.dishes.resource;

import java.net.URI;
import java.util.List;

import com.fastcooking.dishes.dto.DishRequest;
import com.fastcooking.dishes.dto.DishResponse;
import com.fastcooking.dishes.service.DishService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/dishes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class DishResource {
    
    private final DishService dishService;

    @Inject
    public DishResource(DishService dishService) {
        this.dishService = dishService;
    }

    @GET 
    public List<DishResponse> findAll(){
        return dishService.findAll();
    }

    @GET 
    @Path ("/{id}")
    public DishResponse findById(@PathParam("id") Long id){
        return dishService.findById(id);
    }

    @POST 
    public Response create(DishRequest request, @Context UriInfo uriInfo){
        
        Long id = dishService.create(request).id();

        UriBuilder builder =  uriInfo.getAbsolutePathBuilder();
        builder.path(id.toString());
        URI location = builder.build();
        
        return Response
            .created(location)
            .entity(request)
            .build();
        
    }

    @PUT 
    @Path ("/{id}")
    public Response update(@PathParam("id") Long id, DishRequest request){
        
        dishService.update(id, request);
    
        return Response.ok(request).build();
    }

    @DELETE 
    @Path ("/{id}")
    public void delete(@PathParam ("id") Long id){
        dishService.delete(id);
    }
}
