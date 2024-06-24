package example.logbook;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ExampleTest {
    @RestClient
    ExampleClient exampleClient;

    @Test
    void testHelloEndpoint() {
        given().body("World")
                .when().post("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello World"));
    }

    @Test
    void testHelloClient() {
        assertEquals("Hello World", exampleClient.hello("World"));
    }
}