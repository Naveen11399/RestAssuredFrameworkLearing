package api.payloads;

import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
public class StdImportPojo {
	
	private String studentDetails;

public String getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(String addExcelPayload) {
		this.studentDetails = addExcelPayload;
	}


	
	
}
