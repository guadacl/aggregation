package nl.fedex;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

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
	@RestClient
	TrackProxy trackProxy;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAggregation(
    		 @QueryParam("shipmentsOrderNumber") List<Integer> shipmentsOrderNumber,
    		 @QueryParam("trackOrderNumbers") List<Integer> trackOrderNumbers,
    		 @QueryParam("pricingCountryCodes") List<String> pricingCountryCodes
    		) {
    	
    	
   // 	shipmentsOrderNumber.stream().map(a -> {
    		
    //	}).coll
    	
    	var ret1 = trackProxy.getShipmentProducts(109347263);
    	
    	var ret2 = trackProxy.getPricing("109347263");
    	var ret3 = trackProxy.getTrackStatus(109347263);
    	System.out.println(ret1);
    	System.out.println(ret2);
    	System.out.println(ret3);
    	
        return Response.status(200).entity(new Aggregation()).build();
    }
}
