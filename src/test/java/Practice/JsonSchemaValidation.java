package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test 
	void testMethod() {
		given().when().get("https://reqres.in/api/users?page=2").then().assertThat().
		body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"));
	}
}
