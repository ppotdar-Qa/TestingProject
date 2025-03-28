import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;


public class APIGET_Call {
	
	
		@Test()
		public void RetriverUser() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response response= RestAssured.given()
				           .when()
				           .get("/posts/1")
				           .then()
				           .statusCode(200)
				           .extract()
				           .response();
		
		//Extract message
		
		String title=response.jsonPath().getString("title");
		
		// print message
		
		System.out.println("Title:-"+title);
		System.out.println("validate 200 status code");
				
	
		}
}
