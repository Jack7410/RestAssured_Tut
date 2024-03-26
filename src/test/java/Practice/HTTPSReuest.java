package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPSReuest {
	
	int id;
	
	@Test(priority = 1)
	void getUsers() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log().all();
	}
	
	@Test(priority = 2)
	void postUser() {
		HashMap hm=new HashMap();
		
		hm.put("name","Tom");
		hm.put("job","Actor");
		
		
	id=	given().contentType("application/json").body(hm).when().post("https://reqres.in/api/users").jsonPath().getInt("id");
	}
	
	@Test(priority = 3)
	void updateUser() {
		HashMap hm =new HashMap();
		
		hm.put("job", "Player");
		
		given().contentType("application/json").body(hm).when().put("https://reqres.in/api/users/"+id).then().statusCode(200).log().all();
		String name=given().contentType("application/json").body(hm).when().put("https://reqres.in/api/users/"+id).jsonPath().getString("name");
		System.out.println("Name is : " +name);
	}
	
	
	@Test(priority = 4)
	void getSingleUser() {
		String  name=given().when().get("https://reqres.in/api/users/"+id).jsonPath().getString("name");
		System.out.println(" *******************************************************");
		System.out.println(name);
	}
	
	
	
	@Test(priority = 5)
	void deleteUser() {
		given().when().delete("https://reqres.in/api/users/"+id).then().statusCode(204).log().all();
	}
	
}
