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

    @Test
    public void testQuery() {
//        given()
//          .when().get("/aggregation")
//          .then()
//             .statusCode(200)
        //           .body(is("Hello from RESTEasy Reactive")).
        //         log()
        //       .all();

        //Log.info("as string");
        given()
                .queryParam("shipmentsOrderNumber", "987654321")
                .queryParam("shipmentsOrderNumber", "123456789")
                .queryParam("trackOrderNumbers", "987654321")
                .queryParam("trackOrderNumbers", "123456789")
                .queryParam("pricingCountryCodes", "NL")
                .queryParam("pricingCountryCodes", "CN")
                . when().get("/aggregation")
          .then()
             .statusCode(200).log().all();
               // .getBody().asString()));

    }

}