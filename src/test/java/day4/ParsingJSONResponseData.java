package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJSONResponseData {
	
	//@Test
	void getJSONResponseData() {
		given().contentType("application/json").when().get("http://localhost:3000/store").then().statusCode(200).log().body();
	}
	
	//@Test
	void testJSONResposeData() {
		given().contentType("ContentType.JSON").when().get("http://localhost:3000/store")
		.then().body("book[0].author",equalTo("Nigel Rees"));
	}
	
	//@Test
	void testResponse() {
		Response res= given().contentType("ContentType.JSON").when().get("http://localhost:3000/store");
		Assert.assertEquals("Nigel Rees",res.jsonPath().get("book[0].author").toString(),"Missmatch");
	}
	
	//@Test
	void test() {
		Response res= given().contentType("ContentType.JSON").when().get("http://localhost:3000/store");
		List list=res.jsonPath().getList("book.author");
		
		for(int i=0;i<list.size();i++) {
			System.out.println("\n"+list.get(i));
		}
	}
	
	@Test
	void validateResponse() {
		Response res=given().contentType("ContentType.JSON").when().get("http://localhost:3000/store");
		
		JSONObject obj=new JSONObject(res.toString());
		
		for(int i=0;i<obj.getJSONArray("book").length();i++) {
			String author= obj.getJSONArray("book").getJSONObject(i).get("author").toString();
			System.out.println(author);
		}
	}
	
	

}
