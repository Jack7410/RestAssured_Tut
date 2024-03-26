package day2;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class WaystoCreatePostBody {
	
	/*
	 * Post body by HashMap 
	 * Post body by Org.json 
	 * Post body by POJO class 
	 * Post body by external json
	 */
	
	int id;
//	@Test (priority = 1)
	
	
	
	// Post body by HashMap 
	void postByHashMap() {

        	  
        HashMap data=new HashMap();
        
         String []str= {"Volume1","Volumn2","Volumn3"};
		  data.put("author", "Devid Morse");
		  data.put("category", "adventure");
		  data.put("Price", "10.00");
		  data.put("title", "The Jungle");
		  data.put("id", 1);
		  data.put("Editions", str);
		  
		  given().contentType("application/json").body(data).when().post("http://localhost:3000/store").
		  then().statusCode(201).body("Editions[0]",equalTo( "Volume1"))
		  .header("Content-Type", equalTo("application/json; charset=utf-8"))
		  .log().all();
		  
		 
		  
	}
	
	//@Test(priority = 2)
	void deleteRecord() {
		given().when().delete("http://localhost:3000/store/1").then().statusCode(404).log().all();
	}
	
	// @Test
	
	// Post body by Org.json
	void postByJson() {
		JSONObject data=new JSONObject();
		
		
		
		 String []str= {"Volume1","Volumn2","Volumn3"};
		  data.put("author", "Morse Jorge");
		  data.put("category", "Survival");
		  data.put("Price", "11.00");
		  data.put("title", "The Life");
		  data.put("id", 2);
		  data.put("Editions", str);
		  
		  given().contentType("application/json") .body(data.toString()) .when().post("http://localhost:3000/store").then().statusCode(201).log().all();
		
	}
	
	// Post body by POJO class
	
	// @Test
	void postByPOJOClass() {
		
		PojoClass data=new PojoClass();
		
		data.setAuthor("Mike");
		data.setCategory("Horror");
		data.setPrice("12.02");
		data.setTitle("Gost House");
		
		given().contentType("application/json").body(data).when().post("http://localhost:3000/store").then().statusCode(201).
		body("author", equalTo("Mike")).  log().all();
	}
	
	// Post body by external json
	
	@Test 
	
	void postByExternalJson() throws Exception {
		
		File file =new File(".//body.json");
		
		FileReader reader=new FileReader(file);
		JSONTokener token=new JSONTokener(reader);
		JSONObject obj=new JSONObject(token);
		
		given().contentType("application/json").body(obj.toString()).when().post("http://localhost:3000/store").then().statusCode(201).log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
