package com.selenium.core.ddf.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.core.ddf.base.BaseTest;
import com.selenium.core.ddf.util.DataUtil;
import com.selenium.core.ddf.util.ExtentManager;
import com.selenium.core.ddf.util.Xls_Reader;

public class DummyTestC extends BaseTest {
	
	String TestCaseName = "TestC";
	Xls_Reader xls;
	
	@Test(dataProvider="getData")
	public void testC(Hashtable<String,String> data){
		test = rep.startTest("DummyTestC");
	
		if(!DataUtil.isRunnable(TestCaseName, xls) || data.get("Runmodes").equals("N")){
			
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
			
		}
		
		test = rep.startTest("Dummy TestC");
		test.log(LogStatus.INFO, "Starting Dummy Test C");
		test.log(LogStatus.FAIL, "Failed Dummy Test C");
		
		test.log(LogStatus.FAIL, "Screen Shot  " +test.addScreenCapture("C:\\Users\\skoppula\\Documents\\ScreenShots\\test.png"));
		
	}
	
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		super.init();
		Xls_Reader xls = new Xls_Reader(prop.getProperty("xlspath"));
		return DataUtil.getTestData(xls,TestCaseName);
	
}

}