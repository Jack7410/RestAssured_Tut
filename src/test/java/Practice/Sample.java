package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sample {

	//@Test
	 void validateXmlRes() {
		given().contentType(ContentType.JSON).when().get("http://restapi.adequateshop.com/api/Traveler").then().
		body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		.log().cookies();
	}
	
	@Test
	void validateXMlRes2() {
	Response res=	given().when().get("http://restapi.adequateshop.com/api/Traveler");
	
	XmlPath xmlres=new XmlPath(res.asString());
	
	List list =xmlres.getList("TravelerinformationResponse.travelers.Travelerinformation");
	
	int num=0;
	
	for(int i=0;i<list.size();i++) {
		num+=1;
	}
	
	System.out.println(num);
	
	
		
	}
	
	
}
