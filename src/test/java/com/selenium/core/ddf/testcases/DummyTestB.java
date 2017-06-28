package com.selenium.core.ddf.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.core.ddf.base.BaseTest;
import com.selenium.core.ddf.util.DataUtil;
import com.selenium.core.ddf.util.ExtentManager;
import com.selenium.core.ddf.util.Xls_Reader;


	public class DummyTestB extends BaseTest {
		String testCaseName = "TestB";
		SoftAssert softAssert;
		Xls_Reader xls;
		
		@Test(dataProvider="getData")
		public void testB(Hashtable<String,String> data){
			
			test = rep.startTest("TestB");
			test.log(LogStatus.INFO, "Starting the Test TesB");
			test.log(LogStatus.INFO, data.toString());
			
			if(!DataUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equals("N")){
			
				test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
				throw new SkipException("Skipping the test as runmode is N");
				
			}
				
			openBrowser("Chrome");
			test.log(LogStatus.INFO, "Opening Browser");
			navigate("appurl");
			
			
			
		}
		
		@BeforeMethod
		public void init(){
			softAssert = new SoftAssert();
			
			
		}
		
		@AfterMethod
		public void quit(){
			try{
				softAssert.assertAll();
				
				
			}catch(Error e){
				
				test.log(LogStatus.FAIL, e.getMessage());
			}
			
			rep.endTest(test);
			rep.flush();
		}
		
		@DataProvider
		public Object[][] getData(){
			
			super.init();
			xls = new Xls_Reader(prop.getProperty("xlspath"));
			return DataUtil.getTestData(xls,testCaseName);
		
	}

}
