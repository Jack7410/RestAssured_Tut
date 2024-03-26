package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CookiesDemo {
	
	//@Test
	void testMethod() {
		given().when().get("https://www.google.co.in/").then(). 
		cookie("AEC","Ae3NU9OhKEFY8TZVErxpThC2Zc5bnQ-yzJF5G1bCUyQMhjNXBF4esZ3G5Ds; expires=Sat, 10-Aug-2024 06:32:26 GMT; path=/; domain=.google.co.in; Secure; HttpOnly; SameSite=lax"). 
		log().all();
	}
	
	//@Test
	void getCookie() {
		Response res= given().when().get("https://www.google.com/");
		System.out.println(res.getCookie("AEC"));
	}
	
	@Test
	void GetCookies() { 
		 Response res=given().when().get("https://www.google.com/");
		 Map<String,String> mp= res.getCookies();
		 
		 for(String cookies: mp.values()) {
			 System.out.println("The value of cookies "+"\n "+cookies);
		 }
	}
	

	
}
