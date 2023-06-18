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


    public Aggregation getAggregation(List<Integer> shipmentsOrderNumbers,
                                      List<Integer> trackOrderNumbers,
                                      List<String> pricingCountryCodes){

        AggregationsClient shipment = proxy::getShipmentProducts;
        var shipments = shipment.getJsonObject(shipmentsOrderNumbers);

        AggregationClient<Integer> track = proxy::getTrackStatus;
        var tracks = track.getJsonObject(trackOrderNumbers);

        AggregationClient<String> pricing = proxy::getPricing;
        var pricings = pricing.getJsonObject(pricingCountryCodes);

        return new Aggregation(pricings,shipments,tracks);
    }
}