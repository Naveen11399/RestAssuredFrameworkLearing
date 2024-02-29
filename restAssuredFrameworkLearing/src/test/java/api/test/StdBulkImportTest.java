package api.test;

import java.io.File;

import org.testng.annotations.Test;

import api.endPoints.StudentEndPoints;
import api.payloads.StudentBulkImportPojo;
import api.payloads.reportDetails;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class StdBulkImportTest {

	@Test(dataProvider = "StdBulk", dataProviderClass = DataProviders.class)
	public void testDataFromExcel(String admissionNumber, String admissionDate, String studentName, String gender,
			String dob, String grade, String section, String aadharNumber, String studentEmail, String studentContactNo,
			String address, String secondLanguage, String thirdLanguage, String bloodGroup, String nationality,
			String country, String state, String religion, String community, String previousSchool,
			String previousGrade, String dateOfLeaving, String tcIssuedDate, String reasonOfLeaving, String fatherName,
			String fatherContactNo, String fatherEmailId, String fatherQualification, String fatherIncome,
			String fatherOccupation, String fatherDesignation, String fatherCompanyName, String fatherAadharNo,
			String fatherPassportNo, String fatherCompanyAddress, String motherName, String motherContactNo,
			String motherEmailId, String motherQualification, String motherIncome, String motherOccupation,
			String motherDesignation, String motherCompanyName, String motherAadharNo, String motherPassportNo,
			String motherCompanyAddress, String guardianName, String guardianEmailId, String guardianContactNo,
			String guardianQualification, String guardianIncome, String guardianOccupation, String guardianDesignation,
			String guardianCompanyName, String guardianAadharNo, String guardianPassportNo,
			String guardianCompanyAddress, String communication) {

		// File fileToAttach = new File(System.getProperty("user.dir") + "//testdata//Student-sample-data (1) (1).xlsx");
		StudentBulkImportPojo student = new StudentBulkImportPojo();

		reportDetails report = new reportDetails();
		report.setAdmissionNumber(admissionNumber);
		report.setAdmissionDate(admissionDate);
		report.setStudentName(studentName);
		report.setGender(gender);
		report.setDob(dob);
		report.setGrade(grade);
		report.setSection(section);
		report.setAadharNumber(aadharNumber);
		report.setStudentEmail(studentEmail);
		report.setStudentContactNo(studentContactNo);
		report.setAddress(address);
		report.setSecondLanguage(secondLanguage);
		report.setThirdLanguage(thirdLanguage);
		report.setBloodGroup(bloodGroup);
		report.setNationality(nationality);
		report.setCountry(country);
		report.setState(state);
		report.setReligion(religion);
		report.setCommunity(community);
		report.setPreviousSchool(previousSchool);
		report.setPreviousGrade(previousGrade);
		report.setDateOfLeaving(dateOfLeaving);
		report.setTcIssuedDate(tcIssuedDate);
		report.setReasonOfLeaving(reasonOfLeaving);
		report.setFatherName(fatherName);
		report.setFatherContactNo(fatherContactNo);
		report.setFatherEmailId(fatherEmailId);
		report.setFatherQualification(fatherQualification);
		report.setFatherIncome(fatherIncome);
		report.setFatherOccupation(fatherOccupation);
		report.setFatherDesignation(fatherDesignation);
		report.setFatherCompanyName(fatherCompanyName);
		report.setFatherAadharNo(fatherAadharNo);
		report.setFatherPassportNo(fatherPassportNo);
		report.setFatherCompanyAddress(fatherCompanyAddress);
		report.setMotherName(motherName);
		report.setMotherContactNo(motherContactNo);
		report.setMotherEmailId(motherEmailId);
		report.setMotherQualification(motherQualification);
		report.setMotherIncome(motherIncome);
		report.setMotherOccupation(motherOccupation);
		report.setMotherDesignation(motherDesignation);
		report.setMotherCompanyName(motherCompanyName);
		report.setMotherAadharNo(motherAadharNo);
		report.setMotherPassportNo(motherPassportNo);
		report.setMotherCompanyAddress(motherCompanyAddress);
		report.setGuardianName(guardianName);
		report.setGuardianEmailId(guardianEmailId);
		report.setGuardianContactNo(guardianContactNo);
		report.setGuardianQualification(guardianQualification);
		report.setGuardianIncome(guardianIncome);
		report.setGuardianOccupation(guardianOccupation);
		report.setGuardianDesignation(guardianDesignation);
		report.setGuardianCompanyName(guardianCompanyName);
		report.setGuardianAadharNo(guardianAadharNo);
		report.setGuardianPassportNo(guardianPassportNo);
		report.setGuardianCompanyAddress(guardianCompanyAddress);
		report.setCommunication(communication);

		//student.setReportDetails(report);

//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
//
//		System.out.println(json);
		Response response = StudentEndPoints.createBulkStudent(report);
		
		response.then().log().all();

		System.out.println("Response: " + response.asString());
	}
}
