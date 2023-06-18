package nl.fedex;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class AggregationService {
    @Inject
    @RestClient
    FedExProxy proxy;

    public Aggregation getAggregation(List<Integer> shipmentsOrderNumbers,
                                      List<Integer> trackOrderNumbers,
                                      List<String> pricingCountryCodes){
        AggregationsClient shipment = proxy::getShipmentProducts;
        AggregationClient<Integer> track = proxy::getTrackStatus;
        AggregationClient<String> pricing = proxy::getPricing;
        return new Aggregation(pricing.getJsonObject(pricingCountryCodes),shipment.getJsonObject(shipmentsOrderNumbers),
                track.getJsonObject(trackOrderNumbers));
    }
}