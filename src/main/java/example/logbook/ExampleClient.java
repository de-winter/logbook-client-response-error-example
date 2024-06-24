package example.logbook;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081")
public interface ExampleClient {
    @POST
    @Path("/hello")
    @Produces("text/plain")
    String hello(String name);
}
