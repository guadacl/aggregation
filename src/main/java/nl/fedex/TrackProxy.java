package nl.fedex;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

//pricing?countryCode=NL
@RegisterRestClient
public interface TrackProxy {


  @GET
  @Path("/shipment-products")
  List<String> getShipmentProducts(@QueryParam("orderNumber") Integer orderNumber);

  @GET
  @Path("/track-status")
  String getTrackStatus(@QueryParam("orderNumber") Integer orderNumber);

  @GET
  @Path("/pricing")
  String getPricing(@QueryParam("countryCode") String countryCode);
}
