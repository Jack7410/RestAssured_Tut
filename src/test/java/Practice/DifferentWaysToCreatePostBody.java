package Practice;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonToken;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DifferentWaysToCreatePostBody {
	
	/* Different ways to create post body
		* By hash map
		* By pogo class
		* By Org.Json
		* By external Json
	*/
//	@Test
	void postUsingHashMap() {
		
		String [] courses= {"Perl","C##","Python"};
		HashMap hm=new HashMap();
		
		hm.put("Name", "Merry");
		hm.put("lastName","Smith");
		hm.put("courses", courses);
		
		given().contentType("application/json").body(hm).when().post("http://localhost:3000/student").then().statusCode(201)
		.body("Name", equalTo("Merry")).body("lastName", equalTo("Smith"))
		.body("courses[0]",equalTo("Perl"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
		
	}
	
//	@Test
	void postUsingJsonLibrary() {
		JSONObject data=new JSONObject();
		String [] courses= {"Ruby","Java","Python"};
		data.put("Name", "Mick");
		data.put("lastName", "Marty");
		data.put("courses",courses );
		data.put("id",1);
		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/student").then().statusCode(201).log().all();
			
	}
	
	//@Test
	void postUsingPOJO() {
		POJO_Class pojo=new POJO_Class();
		
		pojo.setName("Will");
		pojo.setLastName("Farna");
		
		String [] courses= {"ML","AI","DataMining"};
		pojo.setCourses(courses);
		
		given().contentType("application/json").body(pojo).when().
		post("http://localhost:3000/student").then().statusCode(201).body("name", equalTo("Will")).log().all();
		
	}
	
	@Test
	void postUsingExternalJson() throws IOException {
		File file=new File(".//Data.json");
		FileInputStream input=new FileInputStream(file);
		JSONTokener tokener=new JSONTokener(input);
		JSONObject obj=new JSONObject(tokener);
		
		given().contentType("application/json").body(obj.toString()).when().post("http://localhost:3000/student").then().statusCode(201).log().all();
		
		
	}
	
	
	

}
