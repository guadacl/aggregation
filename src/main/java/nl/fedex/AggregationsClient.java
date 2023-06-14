package nl.fedex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface AggregationsClient {
    List<String> apply(Integer id);

    default Map<String,List<String>> getJsonObject(List<Integer> ids){
        Map<String, List<String>> map = new HashMap<>();
        ids.stream().forEach(a->map.put(a.toString(), apply(a)));
        return map;
    };
}