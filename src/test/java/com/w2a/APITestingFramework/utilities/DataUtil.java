package com.w2a.APITestingFramework.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.APITestingFramework.setUp.BaseTest;


public class DataUtil extends BaseTest {

	
	
	@DataProvider(name="data")
	
	public static Object[][] getData(Method m)
	{
		int rows = excel.getRowCount(config.getProperty("testDataSheet"));
	
		System.out.println("Total rows are "+ rows);
		
		
		String testName= m.getName();
		System.out.println("Test Name is " + testName);
		

		

		// Find the test case start row
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			String testCaseName = excel.getCellData(config.getProperty("testDataSheet"), 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}

		System.out.println("Test Case starts from row num " + testCaseRowNum);

		// Checking total rows in test case

		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;

		while (!excel.getCellData(config.getProperty("testDataSheet"), 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}
		System.out.println("Total rows of data are :" + testRows);

		// Checking total columns in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData(config.getProperty("testDataSheet"), testCols, colStartColNum).equals("")) {
			testCols++;
		}

		System.out.println("Total columns are :" + testCols);

		// Printing data
        
		Object[][] data= new Object[testRows][1];
		
		int i=0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			
			Hashtable<String,String> table = new Hashtable<String,String>();
			
			
			for (int cNum = 0; cNum < testCols; cNum++) {
				
			//System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
			String testData=excel.getCellData(config.getProperty("testDataSheet"), cNum, rNum);
			String colName=excel.getCellData(config.getProperty("testDataSheet"), cNum, colStartColNum);
		    
			table.put(colName, testData);
				
			}
			
			data[i][0]=table;
			i++;
		}
		
		return data;
	}
}
