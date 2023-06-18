package nl.fedex;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class AggregationClientTest {

    public static final String TRANSIT = "TRANSIT";
    static Map<String,String> tracks;

    @BeforeAll
    static void setUpBeforeClass() {
        AggregationClient<Integer> track = i -> TRANSIT;
        List<Integer> trackOrderNumbers = new ArrayList<>();
        trackOrderNumbers.add(1);
        tracks = track.getJsonObject(trackOrderNumbers);
    }

    @Test
    void getJsonObject() {
        assertEquals(TRANSIT ,tracks.get("1"));
    }

    @Test
    void getJsonObject_no_present() {
        assertNotEquals(TRANSIT ,tracks.get("2"));
    }
}