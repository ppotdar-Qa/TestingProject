import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;




public class AutomateApi_Post {
	
	
	@Test()
	void UserCreated() {
		        Response response = RestAssured.given()
		                .body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
		                .when()
		                .post("https://reqres.in/api/users")
		                .then()
		                
		                .statusCode(201) 
		                .log().all() 
		                .extract().response(); 
		    }
		}
	
	


