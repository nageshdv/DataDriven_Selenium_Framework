package com.selenium.core.ddf.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports("C:\\Users\\skoppula\\Documents\\Reports\\"+fileName, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportConfig.xml"));
			
			extent.addSystemInfo("Selenium Version", "2.46").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
