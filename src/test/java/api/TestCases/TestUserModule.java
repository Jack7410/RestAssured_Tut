  package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.UserEndPoint;
import api.PayLoad.UserPayLoad;
import io.restassured.response.Response;

public class TestUserModule {
	
	Faker fake;
	static UserPayLoad payload;
	
	@BeforeClass
	void setData() {
		fake=new Faker();
		payload =new UserPayLoad();
		
		payload.setId(fake.number().numberBetween(1, 100));
		payload.setUsername(fake.name().username());
		payload.setFirstName(fake.name().firstName());
		payload.setLastName(fake.name().lastName());
		payload.setEmail(fake.internet().safeEmailAddress());
		payload.setPassword(fake.internet().password());
		payload.setPhone(fake.phoneNumber().phoneNumber());
		payload.setUserStatus(0);
		
		
	}
	
	@Test(priority = 1) 
	void test_Post_User() {
		Response res=	UserEndPoint.post_User(payload);
		
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority = 2)
	
	void test_Get_User() {
		Response res=UserEndPoint.get_User(payload.getUsername());
		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority = 3)
	void test_Update_User() {
		
		payload.setFirstName("John");
		payload.setLastName("Week");
		payload.setUserStatus(1);
		
		Response res=UserEndPoint.update_User(payload.getUsername(), payload);
		
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Response res2=UserEndPoint.get_User(payload.getUsername());
		
		res2.then().log().all();
	}
	
	@Test(priority = 4)
	void test_Delete_User() {
		Response res=UserEndPoint.delete_User(payload.getUsername());
		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getStatusCode());
	}
	
	
	
	
	
	
	
}
