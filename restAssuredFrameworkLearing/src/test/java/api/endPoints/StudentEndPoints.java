package api.endPoints;

import static io.restassured.RestAssured.given;

import java.util.Map;

import com.aventstack.extentreports.gherkin.model.Given;

import api.payloads.StudentBulkImportPojo;
import api.payloads.createStudent;
import api.payloads.reportDetails;
import api.payloads.studentInfo;
import api.test.StudentTest;
import bsh.This;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentEndPoints {
	
	studentInfo stdInfo =new studentInfo();
	
	public static Response getStudentDetail() {
		
		Response response=
				          given()
		                  .when()
		                  .auth()
		                  .oauth2(Auth.getToken())
		                  .get(Routes.GET_Std_URL);
		
		return response;
		
	}
	
	
	public static Response createStudent(createStudent create_Std) {
		Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.auth()
		.oauth2(Auth.getToken())
		.body(create_Std)
		.when()
		
		.post(Routes.Create_Std_URL);
		
		return response;
		
	}
	
	public static Response getCreatedStudent(String studentId) {
		System.out.println(studentId);
		Response response=
				given()
				.auth()
				.oauth2(Auth.getToken())
				.pathParam("studentId", studentId)
				.get(Routes.Get_Created_Std_URL);
		
		return response;
		
	}
	
	
	public static Response deleteStudent(String studentId) {
		Response  response=
				given()
				.auth()
				.oauth2(Auth.getToken())
				.pathParam("studentId", studentId)
				.delete(Routes.Delete_Std_URL);
		return response;
		
	}
	
	public static Response createBulkStudent(reportDetails report) {
		Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.auth()
		.oauth2(Auth.getToken())
		.body(report)
		.when()
		
		.post(Routes.Std_Bulk_URL);
		
		return response;
		
	}

}
