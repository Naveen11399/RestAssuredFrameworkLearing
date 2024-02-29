package api.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.endPoints.StudentEndPoints;
import api.payloads.createStudent;
import api.payloads.studentInfo;
import io.restassured.response.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentTest {

	Faker faker;

	createStudent create_Std;

	studentInfo studentPesonal;

//	@Test
	public void GetStudentAPI() {

		Response response = StudentEndPoints.getStudentDetail();
		// response.then().log().all();
		String name = response.jsonPath().getString("data.studentInfo.name");
		System.out.println("Name: " + name);

	}

	@Test(priority = 1)
	public void createStudentApi() throws JsonProcessingException {

		faker = new Faker();

		create_Std = new createStudent();

		studentPesonal = new studentInfo();

		studentPesonal.setAdmissionNumber(faker.number().numberBetween(7899, 23456));
		studentPesonal.setName(faker.name().firstName());
		// create_Std.setDob(faker.date().birthday());

		// Generate random date of birth
		Date dob = faker.date().birthday();
		// Format the date to "yyyy-MM-dd"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDob = sdf.format(dob);
		studentPesonal.setDob(formattedDob);
		studentPesonal.setGender(faker.demographic().sex());

		studentPesonal.setGradeId(faker.number().numberBetween(1, 2));

		create_Std.setStudentInfo(studentPesonal);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(create_Std);

		System.out.println(json);

		Response response = StudentEndPoints.createStudent(create_Std);

		//System.out.println("Response: " + response.asString());

		String message = response.jsonPath().getString("message");
		System.out.println("message: " + message);

		String name = response.jsonPath().getString("data.firstName");
		System.out.println("name: " + name);

		String studentId = response.jsonPath().getString("data.id");
		//System.out.println("studentId: " + studentId);

		studentPesonal.setStudentId(studentId);
		create_Std.setStudentInfo(studentPesonal);
	}

	@Test(priority = 2)
	public void getCreatedStudentInfo() {

		Response response = StudentEndPoints.getCreatedStudent(this.studentPesonal.getStudentId());
		//response.then().log().all();
		// System.out.println("Response: " + response.asString());
		String message = response.jsonPath().getString("message");
		System.out.println("message: " + message);


	}

	@Test(priority = 3)
	public void deleteStudentInfo() {

		Response response = StudentEndPoints.deleteStudent(this.studentPesonal.getStudentId());

		String message = response.jsonPath().getString("message");
		System.out.println("message: " + message);
		//response.then().log().all();

		// System.out.println("Response: " + response.asString());
	}

	
	
}
