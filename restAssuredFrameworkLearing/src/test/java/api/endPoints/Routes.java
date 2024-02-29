package api.endPoints;

public class Routes {

	public static String SpurtBase_URL = "http://3.6.249.0/backend/api";

	public static String SpurtPost_URL = SpurtBase_URL + "/list/contact-us";

	public static String Base_URL = "https://dev-schoolapi.izome.in/api";

	public static String Post_URL = Base_URL + "/auth/login";

	public static String GET_Std_URL = Base_URL + "/student/get-student/38";
	
	public static String Create_Std_URL = Base_URL+"/student/create-student";
	
	public static String Get_Created_Std_URL = Base_URL+"/student/get-student/{studentId}";
	
	public static String Delete_Std_URL = Base_URL+"/student/delete-student/{studentId}";
	
	public static String Std_Bulk_URL = Base_URL+"/student/upload-student-details?";
	
	
	//Get---https://dev-schoolapi.izome.in/api/student/view-file-info?fileName=Student-sample-data%20(1)%20(1)_1709097570458.xlsx&filePath=https://3icms.s3.ap-south-1.amazonaws.com/student-management/imports

	//https://dev-schoolapi.izome.in/api/student/add-student-excel
}
