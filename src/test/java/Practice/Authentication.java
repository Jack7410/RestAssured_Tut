package Practice;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {
	
	@Test (priority = 1)
	void basicAuth() {
		given().auth().basic("postman", "password").when().get("https://postman-echo.com/basic-auth").
		then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}
	
	@Test(priority = 2)
	void digestAuth() {
		 given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth").
		 then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}
	
	@Test(priority = 3)
	void preemptiveAuth() {
		given().auth().preemptive().basic("postman", "password").then().statusCode(200).log().all();
	}
	
	@Test
	void bearerTokenAuth() {
		
	}
}
