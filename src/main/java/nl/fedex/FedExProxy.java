package nl.fedex;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
public interface FedExProxy {

  @GET
  @Path("/shipment-products")
  List<String> getShipmentProducts(@QueryParam("orderNumber") Integer orderNumber);

  @GET
  @Path("/track-status")
  @Produces(MediaType.APPLICATION_JSON)
  String getTrackStatus(@QueryParam("orderNumber") Integer orderNumber);

  @GET
  @Path("/pricing")
  String getPricing(@QueryParam("countryCode") String countryCode);
}
