package nl.fedex;

import lombok.Getter;
import lombok.Setter;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
	
@Getter
@Setter
public class Aggregation {
 private Shipments shipments;
 private Track track;
 private Pricing pricing;
 
}



