package api.endPoints;

import api.payloads.UserPojo;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response submitTheContact(UserPojo Payload) {
		
		Response response=
				          given()
	                   	  .contentType(ContentType.JSON)
	                
		                  .accept(ContentType.JSON)
		                
		                  .body(Payload)
		                  .when()
		                  .post(Routes.SpurtPost_URL);
		
		return response;
		
	}
	
	
	//https://dev-schoolapi.izome.in/api



	

}
