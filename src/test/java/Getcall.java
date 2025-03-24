import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getcall {

	   @Test(priority = 1)
	    void Read_user() {
	        // Base URL
	        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

	        // Create RequestSpecification
	        RequestSpecification httpRequest = RestAssured.given();

	        // Send GET request
	        Response response = httpRequest.get();

	        // Validate response status code
	        System.out.println("Status received => " + response.getStatusLine());
	        System.out.println("Response => " + response.prettyPrint());
	        
	        // Adding assertion for status code to make the test meaningful
	        assert response.getStatusCode() == 200 : "Expected status code 200 but got " + response.getStatusCode();
	    }
	}


