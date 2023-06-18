package nl.fedex;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.QueryParam;

@Path("/aggregation")
public class AggregationResource {

	@Inject
	AggregationService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAggregation(
    		 @QueryParam("shipmentsOrderNumbers") List<Integer> shipmentsOrderNumber,
    		 @QueryParam("trackOrderNumbers") List<Integer> trackOrderNumbers,
    		 @QueryParam("pricingCountryCodes") List<String> pricingCountryCodes
    		) {
    	
        return Response.status(200).entity(service.getAggregation(shipmentsOrderNumber
		,trackOrderNumbers,pricingCountryCodes)).build();
    }
}
