package nl.fedex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.smallrye.config.ConfigLogging.log;

@FunctionalInterface
public interface AggregationClient<E> {

    String apply(E id);

    default Map<String,String> getJsonObject(List<E> ids){
        Map<String, String> map = new HashMap<>();
        try {
            ids.stream().forEach(a->map.put(a.toString(), apply(a)));
        }catch (Exception e){
            log.error(e.toString());
        }
        return map;
    };
}
