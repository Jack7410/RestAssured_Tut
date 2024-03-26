package day7;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.testng.annotations.Test;

public class RestAssuredAuthentication {
	
	@Test
	void basicAuth() {
		given().auth().basic("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200)
		.log().all();
	}
	
	@Test
	void digestAuth() {
		given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200)
		.body("authenticated", equalTo(true)).log().all();
	}
	
	@Test
	void preemptiveAuth() {
		given().auth().preemptive().basic("postman", "password").when().get("https://postman-echo.com/basic-auth").then().statusCode(200)
		.log().all();
		
		
	}

}
