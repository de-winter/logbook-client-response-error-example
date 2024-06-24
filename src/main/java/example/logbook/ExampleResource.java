package example.logbook;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/")
public class ExampleResource {
    @POST
    @Path("/hello")
    @Produces("text/plain")
    public String hello(String name) {
        return "Hello " + name;
    }
}
