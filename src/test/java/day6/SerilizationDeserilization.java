package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationDeserilization {
	
	//@Test
	void serilizationMethod() throws Throwable{
		StuPOJO stu=new StuPOJO();
		
		stu.setStudentId(1);
		stu.setStudentName("Devid"); 
		stu.setStudentDetp("Civil");
		
		String courses[]= {"EM","Architect"};
		stu.setCourses(courses);
		
		ObjectMapper mapper=new ObjectMapper();
		
		String jsonObject=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper);
		System.out.println(jsonObject);
		
	}
	
	@Test 
	void deSerilization() throws Exception, JsonProcessingException {
		String jsonData="{\r\n"
				+ "	\"StudentId\":1,\r\n"
				+ "	\"StudentName\":\"Smith\",\r\n"
				+ "	\"StudentDept\":\"Finance\",\r\n"
				+ "	\"Courses\":[\"EM\",\"FM\"]\r\n"
				+ "}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		StuPOJO stu=mapper.readValue(jsonData, StuPOJO.class);
		
		System.out.println("Name is :"+stu.getStudentName() );
	}

}
