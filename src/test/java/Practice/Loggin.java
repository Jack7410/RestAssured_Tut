package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Loggin {

	@Test
	void testLogs() {
		when().get("https://www.google.com/").then().log().all();  
	}
}
