package nl.fedex;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@lombok.extern.slf4j.Slf4j
public class AggregationService {
    @Inject
    @RestClient
    FedExProxy proxy;
    AggregationsClient shipment = proxy::getShipmentProducts;
    AggregationClient<Integer> track = proxy::getTrackStatus;
    AggregationClient<String> pricing = proxy::getPricing;

    public Aggregation getAggregation(List<Integer> shipmentsOrderNumbers,
                                      List<Integer> trackOrderNumbers,
                                      List<String> pricingCountryCodes){
        return new Aggregation(pricing.getJsonObject(pricingCountryCodes),shipment.getJsonObject(shipmentsOrderNumbers),track.getJsonObject(trackOrderNumbers));
    }
}