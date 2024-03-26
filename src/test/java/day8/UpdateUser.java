package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class UpdateUser {
	
	//@Test
	void updateUser(ITestContext context) {
		String token="35eb03447de74340bc240ac39db76e11baa7da8f64469b84f82c0303c68600d4";

		
		Faker faker=new Faker();
		
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("name", faker.name().firstName());
		jsonobj.put("gender","Male");
		jsonobj.put("email", faker.internet().safeEmailAddress());
		jsonobj.put("status", "In-active");
		
		given().header("Authorization", "Bearer "+token).contentType("application/json").body(jsonobj).pathParam("id", context.getAttribute("User_Id"))
		.when().put(" https://gorest.co.in/public/v2/users/{id}").then().log().all();
	}
	
	@Test
	void updateStoreRec(ITestContext context) {
		
		JSONObject obj=new JSONObject();
		obj.put("category","Not Null" );
		
		given().contentType("application/json").body(obj.toString()).when().pathParam("id", context.getAttribute("UserId"))
		.patch("http://localhost:3000/store/{id}").then().log().all();
	}
}
