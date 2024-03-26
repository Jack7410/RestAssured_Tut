package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PracticeResponse {
	  
	  
	 
	 
	 
	 
	 @Test 
	 	void testMethod() {
		Response res=given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");
		
		JSONObject obj=new JSONObject(res.asString());
		
		boolean flag= false;
		int num=0;
		
		for(int i=0;i<obj.getJSONArray("book").length();i++) {
			
			String srt=obj.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if(srt.equals("Moby Dick")) {
				flag=true;
				num=i;
				break;
			}
		}
		
		if(flag==true) {
			System.out.println("Record found at index"+(num+1));
		}else {
			System.out.println("Record not found");
		}
		
		
		
		
		
		
	 }
	 
	 
	 
	
	 
}
  