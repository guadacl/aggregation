package nl.fedex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
	
@Getter
@Setter
@AllArgsConstructor
public class Aggregation {

 private Map<String, List<String>> shipments;
 private Map<String, String> track;
 private Map<String, String> pricing;
 
}



