package io.bootique.examples.shiro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


@Path("private")
@Produces(MediaType.TEXT_PLAIN)
public class PrivateApi {

    @GET
    public String get() {
        Subject s = SecurityUtils.getSubject();
        return String.format("Hi, %s! This API is protected. You are logged in as '%s'.",
                s.getPrincipal(),
                s.hasRole("admin") ? "admin" : "user");
    }
}
