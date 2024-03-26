package api.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.EndPoints.UserEndPoint;
import api.PayLoad.UserPayLoad;
import api.Utilities.DataProviders;
import api.Utilities.ExcelRead;
import io.restassured.response.Response;

public class DataDrivenTest {

	UserPayLoad payload;
	
	//@Test(priority = 1,dataProvider = "UserData",dataProviderClass =DataProviders.class)
	void post_User(String userId,String Username,String firstName,String lastName,String email,String password, String phone,String userStatus) {
		payload=new UserPayLoad();
		
		payload.setId(Integer.valueOf(userId));
		payload.setUsername(Username);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		payload.setEmail(email);  
		payload.setPassword(password);
		payload.setPhone(phone);
		payload.setUserStatus(Integer.valueOf(userStatus));
		
		
		Response res=	UserEndPoint.post_User(payload);
		
		res.then().log().all();
		System.out.println("*********************************************");
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2,dataProvider = "UserName",dataProviderClass = DataProviders.class)
	void get_Users(String username) {
		Response res=UserEndPoint.get_User(username);
		
		res.then().log().all();
		
		System.out.println("******************************************");
	}
}
