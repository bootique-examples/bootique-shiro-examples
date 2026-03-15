package io.bootique.examples.shiro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@Path("public")
@Produces(MediaType.TEXT_PLAIN)
public class PublicApi {

    @GET
    public String get() {
        Subject s = SecurityUtils.getSubject();

        return s.getPrincipal() != null
                ? String.format("Hi, %s! This API is public. You are logged in as '%s'.", s.getPrincipal(), s.hasRole("admin") ? "admin" : "user")
                : "Hi! This API is public and you are not logged in.";
    }
}
