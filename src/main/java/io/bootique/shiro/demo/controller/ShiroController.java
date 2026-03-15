package io.bootique.shiro.demo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("")
public class ShiroController {

    @GET
    @Path("pub")
    public String doSomething() {
        return "hello!";
    }

    @GET
    @Path("denied")
    public Response denied() {
        return Response.ok("permission denied").build();
    }

    @GET
    @Path("private")
    public Response privateEndpoint() {
        return Response.ok("admin").build();
    }
}
