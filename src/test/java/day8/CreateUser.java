package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class CreateUser {
	
	//@Test
	void createUser(ITestContext contex) {
		String token="35eb03447de74340bc240ac39db76e11baa7da8f64469b84f82c0303c68600d4";
		
		Faker faker=new Faker();
		
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("name", faker.name().firstName());
		jsonobj.put("gender","Male");
		jsonobj.put("email", faker.internet().safeEmailAddress());
		jsonobj.put("status", "Active");
		
		int id =given().header("Authorization","Bearer "+token).contentType("application/json").body(jsonobj.toString()).when()
				
				.post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		
		contex.setAttribute("User_Id", id);
		
		
		System.out.println(id);
	}
	
	@Test
	void createStoreRec(ITestContext context) {
		
		Faker faker =new Faker ();
		
		JSONObject obj=new JSONObject();
		obj.put("author", faker.name().fullName());
		obj.put("category","Null" );
		obj.put("price",faker.idNumber());
		obj.put("title", faker.superhero().name());
		obj.put("id",faker.number().randomDigitNotZero());
		
		
		int id =given().contentType("application/json").body(obj.toString()).when().post("  http://localhost:3000/store")
		.jsonPath().getInt("id");
		
		context.setAttribute("UserId", id);
		
	}

}
