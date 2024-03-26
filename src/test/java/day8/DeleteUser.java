package day8;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	void deleteUser(ITestContext contex) {
		String token="35eb03447de74340bc240ac39db76e11baa7da8f64469b84f82c0303c68600d4";

		
		given().header("Authorization","Bearer "+token).contentType("application/json").pathParam("id", contex.getAttribute("User_Id"))
		.when().delete(" https://gorest.co.in/public/v2/users/{id}").then().statusCode(204).log().all();
	}

}
