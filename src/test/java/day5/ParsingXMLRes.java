package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLRes {
	

	
	//@Test
	void testXMLRes() {
		given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1").
		then().statusCode(200).header("Content-Type", "application/xml; charset=utf-8").
		body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer")).log().all();
	}
	
	//@Test
	void validateXMLRes() {
		Response res=given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
		
		Assert.assertEquals(res.getHeader("Content-Type"), "application/xml; charset=utf-8");
		
		String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		
		Assert.assertEquals(name, "Developer");
	}
	
	@Test
	void validateXMLResObject() {
		Response res=given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj= new XmlPath(res.asString());
		
		List list=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean flag=false;
		
		for(int i=0;i<list.size();i++) {
			String name=list.get(i).toString();
			
			System.out.println(name);
			if(name.equals("Ashor1")) {
				flag=true;
				break;
			}
		}
		
		System.out.println(flag);
		
		 
		
	}

}
