package day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class XMLSchemaValidation {   
	
	  @Test
	   void validateXMlRes() {
		  given().when().get("http://localhost:3000/store").then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath(""));
	  }

}
