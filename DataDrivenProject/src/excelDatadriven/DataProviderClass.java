package excelDatadriven;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="OlaTest")
	public Object[][] getData()throws Exception{
		
		return GetExcelData.readExcelData("C:\\Users\\olatu\\eclipse-workspace\\DataDrivenProject\\DataResource\\TestData.xlsx","Sheet1");
		
	}

}
