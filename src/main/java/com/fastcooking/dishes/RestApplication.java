package com.fastcooking.dishes;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fastcooking.dishes.filter.CorsFilter;
import com.fastcooking.dishes.resource.DishResource;
import com.fastcooking.dishes.service.DishServiceImpl;
import com.fastcooking.dishes.util.AppBinder;

public class RestApplication {

    private final static String URL = "http://localhost:8080";

    public static void main(String[] args) throws IOException {
        
        ResourceConfig resourceConfig = new ResourceConfig();

        DishResource dishResource = new DishResource(new DishServiceImpl());

        resourceConfig
            .register(dishResource)
            .register(JacksonFeature.class)
            .register(CorsFilter.class)
            .register(new AppBinder());

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(URL), resourceConfig);

        System.out.println("Running....");
        
        System.in.read();   


        server.shutdownNow();

        System.out.println("Server stopped.");
    }
}