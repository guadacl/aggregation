package nl.fedex;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.smallrye.config.ConfigLogging.log;

@FunctionalInterface
public interface AggregationsClient {
    List<String> apply(Integer id);

    default Map<String,List<String>> getJsonObject(List<Integer> ids){
        Map<String, List<String>> map = new HashMap<>();
        try {
            ids.stream().forEach(a->map.put(a.toString(), apply(a)));
            return map;
        }catch (Exception e){
            log.error(e.toString());
        }
        return map;
    };
}