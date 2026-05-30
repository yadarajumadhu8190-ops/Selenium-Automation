package utilities;



	import java.io.IOException;

import org.testng.annotations.DataProvider;

	public class DataProviders {

		@DataProvider(name = "LoginData")
		public String[][] getLoginData() throws IOException {

			// Excel file path
			String path = ".\\testData\\LoginData.xlsx";

			// Create object of ExcelUtility
			ExcelUtility xlutil = new ExcelUtility(path);

			// Get total rows and cells
			int totalrows = xlutil.getRowCount("Sheet1");
			int totalcells = xlutil.getCellCount("Sheet1", 1);

			// Create two dimensional array
			String logindata[][] = new String[totalrows][totalcells];

			// Read data from excel
			for (int i = 1; i <= totalrows; i++) {

				for (int j = 0; j < totalcells; j++) {

					logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
				}
			}

			return logindata;
		}
	}

