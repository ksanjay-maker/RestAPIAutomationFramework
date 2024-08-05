package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "AllData")
	public String[][] AllDataProvider() {
		String fName = System.getProperty("user.dir") + "//TestData//data.xlsx";

		int totalRowCount = ReadExcelFile.getRowCount(fName, "Sheet2");
		int totalColCount = ReadExcelFile.getColCount(fName, "Sheet2");

		String userData[][] = new String[totalRowCount - 1][totalColCount];

		for (int rowNum = 1; rowNum < totalRowCount; rowNum++) {
			for (int colNum = 0; colNum < totalColCount; colNum++) {
				userData[rowNum - 1][colNum] = ReadExcelFile.getCellValue(fName, "Sheet2", rowNum, colNum);
			}

		}
		return userData;
	}

	@DataProvider(name = "UserNamesData")
	public String[] UserNamesDataProvider() {
		String fName = System.getProperty("user.dir") + "//TestData//data.xlsx";

		int totalRowCount = ReadExcelFile.getRowCount(fName, "Sheet2");
		// int totalColCount= ReadExcelFile.getColCount(fName, "Sheet2");

		String userNamesData[] = new String[totalRowCount - 1];

		for (int rowNum = 1; rowNum < totalRowCount; rowNum++) {
			userNamesData[rowNum - 1] = ReadExcelFile.getCellValue(fName, "Sheet2", rowNum, 1);

		}
		return userNamesData;
	}

}