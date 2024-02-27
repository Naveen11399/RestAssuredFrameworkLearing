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

}
