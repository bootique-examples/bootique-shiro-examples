package io.bootique.examples.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.net.URI;

@Path("")
public class LoginController {

    @GET
    @Path("login")
    public Response login(@QueryParam("username") String username,
                          @QueryParam("password") String password) throws Exception{
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        URI targetURIForRedirection = new URI("/login.jsp");
        return Response.seeOther(targetURIForRedirection).build();
    }

    @GET
    @Path("login.jsp")
    public Response checkLogin() throws Exception{
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.checkRole("admin");
        } catch (UnauthorizedException | UnauthenticatedException e) {
            URI targetURIForRedirection = new URI("/denied");
            return Response.seeOther(targetURIForRedirection).build();
        }
        return Response.ok("ok").build();
    }

    @GET
    @Path("logout")
    public Response logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return Response.ok("Logged out.").build();
    }
}
