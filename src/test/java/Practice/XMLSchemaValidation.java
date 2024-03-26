package Practice;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {
	
	@Test
	void TestMethod() {
		given().when().get("http://restapi.adequateshop.com/api/Traveler")
		 .then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("travelersSchema.xsd"));
	}
}
 