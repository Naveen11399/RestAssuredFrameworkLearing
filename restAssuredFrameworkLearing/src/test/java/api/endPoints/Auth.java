package api.endPoints;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Auth {
	@BeforeSuite
	 public static String getToken() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .accept(ContentType.JSON)
	                .body("{\r\n"
	                        + "  \"userName\": \"AniAdmin\",\r\n"
	                        + "  \"password\": \"Welcome@123\",\r\n"
	                        + "  \"instituteCode\": \"U2FsdGVkX1/f+8i3htNx2A1IyTXfdPwMNhelIbOkNdg=\",\r\n"
	                        + "  \"deviceType\": 1\r\n"
	                        + "}")
	                .when()
	                .post(Routes.Post_URL);

	        // Extract token from response body using JSONPath
	        String token = response.jsonPath().getString("data.token");

	        return token;
	    }

	   
	    public void getTokenTest() {
	        // Get the token
	        String token = getToken();

	        // Print token
	        System.out.println("Token: " + token);
	    }}