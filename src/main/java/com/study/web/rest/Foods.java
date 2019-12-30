package com.study.web.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/foods")
public class Foods {
    private static List<String> foods = new ArrayList<>(Arrays.asList("Apple", "Banana"));
    
    @GET
    public String list() {
        return new Gson().toJson(foods);
    }
    
    @GET
    @Path("/{id}")
    public String get(@PathParam("id") Integer id) {
        return new Gson().toJson(foods.get(id));
    }
    
    @POST
    public String add(@FormParam("value") String value) {
        foods.add(value);
        return "add ok";
    }
    
    @PUT
    @Path("/{id}")
    public String update(@PathParam("id") int id, @FormParam("value") String value) {
        foods.set(id, value);
        return "update ok";
    }
    
    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") int id) {
        foods.remove(id);
        return "delete ok";
    }
}