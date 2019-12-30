package com.study.web.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hellos")
public class Hellos {
    private static List<String> hellos = new ArrayList<>(Arrays.asList("HelloA", "HelloB"));
    
    @GET
    public String list() {
        return hellos.toString();
    }
    
    @GET
    @Path("/{id}")
    public String get(@PathParam("id") Integer id) {
        return hellos.get(id);
    }
    
    @POST
    public String add(@QueryParam("value") String value) {
        hellos.add(value);
        return "add ok";
    }
    
    @PUT
    @Path("/{id}")
    public String update(@PathParam("id") int id, @QueryParam("value") String value) {
        hellos.set(id, value);
        return "update ok";
    }
    
    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") int id) {
        hellos.remove(id);
        return "delete ok";
    }
}