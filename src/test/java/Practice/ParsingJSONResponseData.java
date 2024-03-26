package Practice;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {
	
	//@Test(priority = 1)
	void testJsonData() {
		when().get("http://localhost:3000/store").then()  . body("book[3].title", equalTo("The Lord of the Rings")).statusCode(200);
	}
	
	//@Test
	void validateJSON() {
		Response res=given().when().get("http://localhost:3000/store");
		
		assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		assertEquals(res.statusCode(),200);
		assertEquals(res.jsonPath().get("book[3].title").toString(),"The Lord of the Rings");
		
	}
	
	
	@Test
	void test() {
		Response response= given().contentType(ContentType.JSON).  when().get("http://localhost:3000/store");
		
		JSONObject obj=new JSONObject(response.asString());
		
		for(int i=0;i< obj.getJSONArray("book").length();i++) {
			String title=obj.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println("Book title is : "+title);
		}
		

	}
}
