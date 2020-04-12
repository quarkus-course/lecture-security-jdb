package tech.donau;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/greeting")
public class UserResource {

    @GET
    @RolesAllowed("User")
    public String getInfo(@Context SecurityContext context) {
        return "Hello " + context.getUserPrincipal().getName();
    }

    @GET
    @Path("/admin")
    @RolesAllowed("Admin")
    public String admin(@Context SecurityContext context) {
        return "admin secret";
    }
}
