package api.EndPoints;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.PayLoad.UserPayLoad;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class UserEndPoint {
	

	

	public static Response post_User(UserPayLoad payload) {
		Response res=given().contentType("application/json").accept("application/json").body(payload).when().post(Routes.post_Url);
	 	
	    return res;
	}
	
	public static Response get_User(String UserName) {
		Response res=given().pathParam("UserName", UserName) .when().get(Routes.get_Url);
		return res;
	}
	
	public static Response update_User(String UserName,UserPayLoad payload) {
		Response res=given().contentType("application/json").accept("application/json").body(payload).pathParam("UserName", UserName)
				.when().put(Routes.get_Url);
		return res;
	}
	
	public static Response delete_User(String UserName) {
		Response res=given().pathParam("UserName", UserName).when().delete(Routes.delete_Url);
		
		return res;
	}

}
