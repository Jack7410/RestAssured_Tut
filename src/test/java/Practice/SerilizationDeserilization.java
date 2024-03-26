package Practice;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class SerilizationDeserilization {
	
	//@Test
	void serilizationMethod() throws Exception {
		POJO_Class pojo=new POJO_Class();
		
		pojo.setName("Smith");
		pojo.setLastName("Warnar");
		String[] arr= {"ML","AI","Deep Learning"};
		pojo.setCourses(arr);
		
		ObjectMapper mapper=new ObjectMapper();
		String str= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		
		System.out.println(str);
	}
	
	//@Test
	void sample()  throws Exception {
		HashMap hm=new HashMap();
		
		hm.put("Name","Denny");
		hm.put("LastName", "Dickon");
		String [] arr= {"M1","M2"};
		hm.put("Courses",arr);
		
		ObjectMapper mapper=new ObjectMapper();
		
		String str=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hm);
		
		System.out.println(str);
	}
	
	@Test
	void Deserilization()  throws Exception{
		String data="{\r\n"
				+ "  \"Courses\" : [ \"M1\", \"M2\" ],\r\n"
				+ "  \"LastName\" : \"Dickon\",\r\n"
				+ "  \"Name\" : \"Denny\"\r\n"
				+ "}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		POJO_Class pojo= mapper.readValue(data, POJO_Class.class);
		
		
		
		System.out.println(pojo.getName() );
		
	}

}
