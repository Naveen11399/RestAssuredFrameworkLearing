package api.payloads;

import java.util.List;

import lombok.Getter;
import lombok.Setter;



//@Getter @Setter
public class StdImportPojo {
	
	 private String studentDetails;
	 
	 private List<Integer> studentId;
	 
	 private List<String> studentName;
	 

	    public List<Integer> getStudentId() {
		return studentId;
	}

	public void setStudentId(List<Integer> ids) {
		this.studentId = ids;
	}

	public List<String> getStudentName() {
		return studentName;
	}

	public void setStudentName(List<String> firstNames) {
		this.studentName = firstNames;
	}

		public String getStudentDetails() {
	        return studentDetails;
	    }

	    public void setStudentDetails(String studentDetails) {
	        this.studentDetails = studentDetails;
	    }

	
}
