package api.endPoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import com.aventstack.extentreports.gherkin.model.Given;

import api.payloads.StudentBulkImportPojo;
import api.payloads.createStudent;
import api.payloads.reportDetails;
import api.payloads.studentInfo;
import api.test.StdBulkImportTest;
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
		
		File file=new File(System.getProperty("user.dir") + "//testdata//Student-sample-data (1) (1).xlsx");
		
		Response response= given()
				.contentType("multipart/form-data")
	            .multiPart(file)
	            .multiPart("report", report, "application/json")
		        .auth()
		        .oauth2(Auth.getToken())
//		        .body(report)
	         	.when()
		
	         	 .post(Routes.Std_Bulk_URL + "?path=student-management/imports/");
		
		return response;
		
	}
	
	public static Response viewFileInfo(String fileName,String path ){
	
		
//		 String getRequestUrl = Routes.View_Std_BulK_URL + "?fileName=" + fileName + "&filePath=" + path;
		
		
		Response response=given()
				.auth()
				.oauth2(Auth.getToken())
				.queryParam("fileName", fileName)
                .queryParam("filePath", path)
				.when()
				.get(Routes.View_Std_BulK_URL);
		
		return response;

}
}