package Practice;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class XmlResponse {
	//@Test 
	void validateXmlRespose() {
		given().when().get("http://restapi.adequateshop.com/api/Traveler").then().statusCode(200).header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1")).log().body();
	}
	
	//@Test
	void validateResponseXml() {
		Response res=given().when().get("http://restapi.adequateshop.com/api/Traveler");
		
		String contentTyep=res.getHeader("Content-Type");
		Assert.assertEquals(contentTyep, "application/xml; charset=utf-8");
		
		
		String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		
		Assert.assertEquals(name, "Developer");
	}
	
	@Test
	void multipleDataValidation() {
		Response res=given().when().get("http://restapi.adequateshop.com/api/Traveler");
		
		XmlPath path=new XmlPath(res.asString());
		
		List< String> list=path.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean flag=false;
		for(String name:list) {
			if(name.equals("developer")) {
				flag=true;
				break;
			}
		}
		System.out.println(flag);
		
	}
}
