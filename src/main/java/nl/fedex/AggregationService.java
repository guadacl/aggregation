package nl.fedex;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class AggregationService {
    @Inject
    @RestClient
    TrackProxy trackProxy;

    public Aggregation getAggregation(List<Integer> shipmentsOrderNumber,
                                      List<Integer> trackOrderNumbers,
                                      List<String> pricingCountryCodes){

        AggregationsClient shipment = trackProxy::getShipmentProducts;
        var shipments = shipment.getJsonObject(shipmentsOrderNumber);

        AggregationClient<Integer> track = trackProxy::getTrackStatus;
        var tracks = track.getJsonObject(trackOrderNumbers);

        AggregationClient<String> pricing = trackProxy::getPricing;
        var pricings = pricing.getJsonObject(pricingCountryCodes);

        return new Aggregation(shipments,tracks,pricings);
    }
}