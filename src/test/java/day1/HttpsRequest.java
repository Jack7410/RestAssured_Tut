package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpsRequest {
	
	
	
	//@Test
	
	void getUsers() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log().all();
	}
	//@Test
	void postUsers() {
		HashMap hm=new HashMap();
		
		hm.put("Name","Smith");
		hm.put("Job", "Tester");
		
		given().contentType("application/json").body(hm).when().post("https://reqres.in/api/users").then().statusCode(201).body("Name", equalTo("Smith")).log().all();
	}
	
	@Test 
	void getUser() {
		given().when().get("https://reqres.in/api/users?page=2&id=5").then().statusCode(200).log().all();
	}
}
