package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParam {
	
	// https://reqres.in/api/users?page=2&id=7&first_name=Michael
	
	@Test
	void method() {
		given().pathParam("mypath", "users").queryParam("page", 2).queryParam("id", 9).queryParam("first_name", "Michael").
		when().get("https://reqres.in/api/{mypath}").then().statusCode(200).log().all();
		
	}

}
