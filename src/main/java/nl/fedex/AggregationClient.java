package nl.fedex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface AggregationClient<E> {

    String apply(E id);

    default Map<String,String> getJsonObject(List<E> ids){
        Map<String, String> map = new HashMap<>();
        ids.stream().forEach(a->map.put(a.toString(), apply(a)));
        return map;
    };
}
