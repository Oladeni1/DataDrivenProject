package excelDatadriven;

import java.util.Map;

import org.testng.annotations.Test;

public class TestCase {
	
    @Test(dataProvider = "OlaTest", dataProviderClass = DataProviderClass.class)
	public void test(Map<String, Object>data) {
    	
    System.err.println("Username = " + data.get("Username")  + " And " + "Password = " + data.get("Password"));

	}

}
