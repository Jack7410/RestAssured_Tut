package Practice;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HeaderDemo {
	
	@Test(priority = 1)
	void testHeaders() {
		when().get("https://www.google.com/").then().header("Content-Type","text/html; charset=ISO-8859-1").
		header("Cache-Control","private, max-age=0").log();
		
	}
	//@Test(priority = 2)
	void getHeaders() {
		Response res=when().get("https://www.google.com/");
		
		String contentType=res.getHeader("Content-type");
		String cacheControl=res.getHeader("Cache-Control");
		System.out.println("Content-Type header is : "+contentType);
		System.out.println("Cache-Control header is : "+cacheControl);
		
		Headers myHeaders= res.getHeaders();
		
		for(Header he:myHeaders) {
			System.out.println("This is header : "+he.getName()+" and value is : "+he.getValue());
		}
	}
	
	
}
 