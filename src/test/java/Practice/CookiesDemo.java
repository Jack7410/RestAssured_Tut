package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	String[][] cookiesInfo;
	
	//@Test
	void method() {
		when().get("https://www.google.com/").then().log().all();
	}
	
	@Test
	void getCookie() {
		Response res=when().get("https://www.google.com/");
			
		Map<String, String> mp=res.getCookies();
		
		for(String k: mp.keySet()) {
			String cookieValue=res.getCookie(k);
			System.out.println(k+": "+cookieValue);
			
		
		}
	}
	
	

}
