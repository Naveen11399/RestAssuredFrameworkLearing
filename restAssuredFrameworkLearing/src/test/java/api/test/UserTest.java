package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.StudentEndPoints;
import api.endPoints.UserEndPoints;
import api.payloads.UserPojo;
import io.restassured.response.Response;

public class UserTest {

	private static Faker faker;

	private static UserPojo userpayload;

	//@BeforeClass
	public void UserTest() {

		faker = new Faker();

		userpayload = new UserPojo();

		userpayload.setMessage(faker.name().fullName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setName(faker.gameOfThrones().character());
		userpayload.setPhoneNumber(Long.toString(faker.number().numberBetween(100000000, 999999999)));

	}

	//@Test
	public void ContactUsApi() {
		System.out.println(userpayload.getEmail());
		System.out.println(userpayload.getName());
		System.out.println(userpayload.getMessage());
		System.out.println(userpayload.getPhoneNumber());

		Response response = UserEndPoints.submitTheContact(userpayload);
		response.then().log().all();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	


}
