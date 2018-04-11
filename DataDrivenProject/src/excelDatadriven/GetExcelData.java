package excelDatadriven;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	
	public static Object [][] readExcelData(String FileName, String SheetName) throws Exception {
		
		File file = new File(FileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet(SheetName);
		
		XSSFRow  row = null;
		XSSFCell cel = null;
		Map<String, Object> map = null;
		
		row = sheet.getRow(0);
		
		String[] header = new String[row.getLastCellNum()];
		
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		
		for (int j = row.getFirstCellNum(); j<row.getFirstCellNum(); j++) {
			
			cel = row.getCell(j);
			
			header[j] = cel.getStringCellValue();
		}
		
		//For loop through the row
		for(int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
			
		     row = sheet.getRow(i);
			
			map = new LinkedHashMap<String, Object>();
			
			
		//For loop through the col	
		for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
				
			cel = row.getCell(j);
			
			
			switch (cel.getCellType()) {
			
			case XSSFCell.CELL_TYPE_STRING :
				
				map.put(header[j], cel.getStringCellValue()); 
				break;
			
			case XSSFCell.CELL_TYPE_NUMERIC :
				
			     map.put(header[j], cel.getNumericCellValue()); 
			     break;
			}
				
			}
		      data[i-1][0] = map;
		}
		return data;
	}

}
