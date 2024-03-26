package day3;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Headers {
	
	@Test
	void test() {
		 
	Response res=given().when().get("https://www.google.co.in/");
	
	 
	}
	
	//@Test
	void test2() {
		given().when().get("https://www.google.co.in/").then().statusCode(200).log().all();
	}
	
	@Test
	
	void getHeaders() {
		Response res= given().when().get("https://www.google.co.in/");
		io.restassured.http.Headers hds= res.getHeaders();
		
		for(Header head:hds) {
			System.out.println(head.getName()+" "+head.getValue()  );
		}
	
	}
}
