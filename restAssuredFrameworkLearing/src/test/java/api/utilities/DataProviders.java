package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="StdBulk")
	public String[][] getAllData() throws IOException {

	String path = System.getProperty("user.dir") + "//testdata//Student-sample-data (1) (1).xlsx";
		
	//	String path="/restAssuredFrameworkLearing/testdata/Student-sample-data (1) (1).xlsx";

		XLUtility xl = new XLUtility(path);

		int rowCount = xl.getRowCount("Student Bulk Create excel Sheet");

		int colCount = xl.getCellCount("Student Bulk Create excel Sheet", 1);

		String apiData[][] = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				apiData[i - 1][j] = xl.getCellData("Student Bulk Create excel Sheet", i, j);

			}
		}

		return apiData;

	}
	
	
	@DataProvider(name="StdName")
	public String[] getStudentName() throws IOException {

		String path = System.getProperty("user.dir") + "/testdata/Student-sample-data (1) (1).xlsx";

		XLUtility xl = new XLUtility(path);

		int rowCount = xl.getRowCount("Student Bulk Create excel Sheet");

	

		String apiData[] = new String[rowCount];

		for (int i = 1; i <= rowCount; i++) {
		 

				apiData[i - 1] = xl.getCellData("Student Bulk Create excel Sheet", i,1);

			}
		

		return apiData;

	}
	
	
	
}
