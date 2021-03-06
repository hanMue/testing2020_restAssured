package quickstart;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.http.ContentType;


public class TestFunktion {	
	
	@Test
	public void getAllEmployeesAndLogBody() {
		baseURI = "https://jsonplaceholder.typicode.com";
		given().when().
		get("/todos").
		then().log().body();
	}

	@Test 
	public void createEmployeeWithMapAndValidateStatusCode() {
		
		//Map um JSON-Objekt zu simulieren
		Map<String, Object>  request = new HashMap();
		request.put("userId","1");
		request.put("id","100");
		request.put("title","Hallo");
		request.put("body","Hallo Welt");
		
		baseURI = "https://jsonplaceholder.typicode.com";
		given().body(request).
		when().
		post("/posts").
		then().assertThat().statusCode(201).and().log().all();
	}
}
