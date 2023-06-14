package nl.fedex;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AggregationResourceTest {

    @Test
    public void testAggregationEndpoint() {
//        given()
//          .when().get("/aggregation")
//          .then()
//             .statusCode(200)
  //           .body(is("Hello from RESTEasy Reactive")).
    //         log()
      //       .all();
        
        //Log.info("as string");
        System.out.println((given().
          when().get("/aggregation")
        		.getBody().asString()));
        
    }

}