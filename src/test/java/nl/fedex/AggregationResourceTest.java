package nl.fedex;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class AggregationResourceTest {


    @Test
    public void testJson(){
        given()
                . when().get("/aggregation")
        .then()
                .body("$", hasKey("shipments"))
                .body("$", hasKey("pricing"))
                .body("$", hasKey("track"))
                .body("$", not(hasKey("shipments.987654321")));
    }
    @Test
    public void testQueryParameters() {
        given()
                .queryParam("shipmentsOrderNumbers", "987654321")
                .queryParam("shipmentsOrderNumbers", "123456789")
                .queryParam("trackOrderNumbers", "987654321")
                .queryParam("trackOrderNumbers", "123456789")
                .queryParam("pricingCountryCodes", "NL")
                .queryParam("pricingCountryCodes", "CN")
                . when().get("/aggregation")
          .then()
             .statusCode(200)
                .log()
               .all();

    }
    @Test
    public void testQuery() {
        given()
                .queryParam("shipmentsOrderNumbers", "987654321")
                .queryParam("shipmentsOrderNumbers", "123456789")
                . when().get("/aggregation")
                .then()
                .statusCode(200)
                .log()
                .all();

    }


}