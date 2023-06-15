package nl.fedex;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
	
@Getter
@Setter
public class Aggregation {
	private Map<String, List<String>> shipments;

	public Aggregation(Map<String, List<String>> map) {
		this.shipments = map;
	}

	public Map<String, List<String>> getShipments() {
		return shipments;
	}

	public void setShipments(Map<String, List<String>> shipments) {
		this.shipments = shipments;
	}

	
 //private Shipments shipments;
 //private Track track;
 //private Pricing pricing;
 
}



